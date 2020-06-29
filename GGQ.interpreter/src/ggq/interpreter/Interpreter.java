package ggq.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Interpreter {
	
	static private <T> Collection<T> without(Collection<T> collection, T without) {
		return collection.stream().filter(obj -> obj != without).collect(Collectors.toList());
	}
	
	static private <T> List<T> tail(List<T> list) {
		return list.subList(1, list.size());
	}
	
	static private Stream<Map<Vertex, EObject>> generatePossibleMappings(Collection<EObject> host, List<Vertex> vertices) {
		if (vertices.isEmpty()) {
			Map<Vertex, EObject> emptyMapping = new HashMap<>(); 
			return Stream.of(emptyMapping);
		}
		
		Vertex node = vertices.get(0);
		return host.stream().flatMap(eobject -> {
			boolean eobjectMatchesType = eobject.eClass() == node.getType(); 
			if (!eobjectMatchesType) {
				Stream<Map<Vertex, EObject>> noValidMappings = Stream.empty();
				return noValidMappings;
			}
			
			Collection<EObject> hostWithoutThisEObject = without(host, eobject);
			
			Stream<Map<Vertex, EObject>> mappingsForRestOfQuery = generatePossibleMappings(hostWithoutThisEObject, tail(vertices));
			return mappingsForRestOfQuery.map(mapping -> {
				mapping.put(node, eobject); // mutation only happens bottom-up, so this is okay 
				return mapping;
			});
		});
	}
	
	static private boolean isEdgeInMapping(Map<Vertex, EObject> mapping, Edge edge) {
		Vertex source = edge.getSource();
		Vertex target = edge.getTarget();
		EReference type = edge.getType();
		
		EObject mappedSource = mapping.get(source);
		EObject mappedTarget = mapping.get(target);
		
		List<EObject> referencedTargets = (List<EObject>) mappedSource.eGet(type);
		boolean thereIsAMatchingRefInHostGraph = referencedTargets.contains(mappedTarget);
		
		return thereIsAMatchingRefInHostGraph;
	}
	
	static private boolean isMappingAMatch(Map<Vertex, EObject> mapping, Collection<Edge> queryEdges) {
		return queryEdges.stream().allMatch(edge-> isEdgeInMapping(mapping, edge));
	}
	
	static Stream<Map<Vertex, EObject>> match(Collection<EObject> host, GraphQuery query) {
		return generatePossibleMappings(host, query.getContainedVertices()).filter(mapping -> isMappingAMatch(mapping, query.getContainedEdges()));
	}
	
}
