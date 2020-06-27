package ggq.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Interpreter {
	
	static private <T> Collection<T> copyWithoutObject(Collection<T> collection, T without) {
		return collection.stream().filter(obj -> obj != without).collect(Collectors.toList());
	}
	
	static private Stream<Map<Vertex, EObject>> generatePossibleMappings(Collection<EObject> host, GraphQuery query, int queryNodesIndex) {
		if (queryNodesIndex >= query.getContainedVertices().size()) {
			return Stream.of(new HashMap<>());
		}
		
		Vertex node = query.getContainedVertices().get(queryNodesIndex);
		return host.stream().flatMap(eobject -> {
			if (eobject.eClass() != node.getType()) {
				return Stream.empty();
			}
			
			Collection<EObject> hostWithoutThisEObject = copyWithoutObject(host, eobject); 
			Stream<Map<Vertex, EObject>> mappingsForRestOfQuery = generatePossibleMappings(hostWithoutThisEObject, query, queryNodesIndex + 1);
			return mappingsForRestOfQuery.map(mapping -> {
				mapping.put(node, eobject);
				return mapping;
			});
		});
	}
	
	static private Stream<Map<Vertex, EObject>> generatePossibleMappings(Collection<EObject> host, GraphQuery query) {
		return generatePossibleMappings(host, query, 0);
	}
	
	static private boolean isMappingAMatch(Map<Vertex, EObject> mapping, Collection<Edge> queryEdges) {
		return queryEdges.stream().allMatch(edge-> {
			Vertex source = edge.getSource();
			Vertex target = edge.getTarget();
			EReference type = edge.getType();
			
			EObject mappedSource = mapping.get(source);
			EObject mappedTarget = mapping.get(target);
			
			List<EObject> referencedTargets = (List<EObject>) mappedSource.eGet(type);
			boolean thereIsAMatchingRefInHostGraph = referencedTargets.contains(mappedTarget);
			
			return thereIsAMatchingRefInHostGraph;
		});
	}
	
	static Stream<Map<Vertex, EObject>> match(Collection<EObject> host, GraphQuery query) {
		return generatePossibleMappings(host, query).filter(mapping -> isMappingAMatch(mapping, query.getContainedEdges()));
	}
	
}
