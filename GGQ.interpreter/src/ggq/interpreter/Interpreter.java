package ggq.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Interpreter {
	
	static private <T> Collection<T> without(Collection<T> collection, T without) {
		return collection.stream().filter(obj -> obj != without).collect(Collectors.toList());
	}
	
	static private <K, V> Map<K, V> union(Map<K, V> map, K key, V value) {
		Map<K, V> copy = new HashMap<>(map);
		copy.put(key,  value);
		return copy;
	}
	
	static private <T> List<T> tail(List<T> list) {
		return list.subList(1, list.size());
	}
	
	static private <T> T head(List<T> list) {
		return list.get(0);
	}
	
	static private <T> Collection<T> collectIterator(Iterator<T> it) {
		List<T> result = new ArrayList<T>();
	    it.forEachRemaining(result::add);
	    return result;
	}
	
	static private boolean isInstanceOfClass(EObject object, EClass clazz) {
		if (object.eClass() == clazz) {
			return true;
		}
		
		List<EClass> acceptableTypes = clazz.getEAllSuperTypes();
		return acceptableTypes.contains(object.eClass());
	}
	
	static private List<EObject> getReferencedTargets(EObject source, EReference reference) {
		if (!reference.isMany()) {
			EObject target = (EObject) source.eGet(reference);
			if (target == null) {
				return Collections.emptyList();
			}
			
			return Collections.singletonList(target);		
		}
		
		return (List<EObject>) source.eGet(reference);		
	}
	
	public static int iterationCounter = 0;
	
	static private Stream<Map<Vertex, EObject>> generateMappings(Collection<EObject> host, List<Vertex> query, Map<Vertex, Collection<Edge>> edges, Map<Vertex, EObject> currentMapping) {
		if (query.isEmpty()) { 
			return Stream.of(currentMapping);
		}
		
		Vertex queryVertex = head(query);
		return host.stream().flatMap(hostVertex -> {
			if (!isInstanceOfClass(hostVertex, queryVertex.getType())) {
				return Stream.empty();
			}
			
			Map<Vertex, EObject> extendedMapping = union(currentMapping, queryVertex, hostVertex);
			
			
			Collection<Edge> edgesConcernedByThisMapping = edges.get(queryVertex);
			boolean someEdgeHasBeenMadeImpossible = edgesConcernedByThisMapping.stream().anyMatch(edge -> {
				EObject mappedSource = extendedMapping.get(edge.getSource());
				EObject mappedTarget = extendedMapping.get(edge.getTarget());
				
				boolean edgeIsFullyMapped = mappedSource != null && mappedTarget != null;
				if (!edgeIsFullyMapped) {
					return false;
				}
				
				boolean edgeExistsInHost = getReferencedTargets(mappedSource, edge.getType()).contains(mappedTarget);
				boolean edgeHasBeenMadeImpossible = !edgeExistsInHost;
				return edgeHasBeenMadeImpossible;
			});
			
			if (someEdgeHasBeenMadeImpossible) {
				return Stream.empty();
			}
			
			return generateMappings(without(host, hostVertex), tail(query), edges, extendedMapping);
		});
	}
	
	static private Stream<Map<Vertex, EObject>> generateMappings(Collection<EObject> host, List<Vertex> query, Map<Vertex, Collection<Edge>> edges) {
		return generateMappings(host, query, edges, new HashMap<>());
	}
	
	static Map<Vertex, Collection<Edge>> collectConcernedEdgesByVertex(Collection<Edge> edges) {
		Map<Vertex, Collection<Edge>> result = new HashMap<>();
		for (Edge edge : edges) {
			result.putIfAbsent(edge.getSource(), new ArrayList<>());
			Collection<Edge> list = result.get(edge.getSource());
			list.add(edge);
			
			result.putIfAbsent(edge.getTarget(), new ArrayList<>());
			Collection<Edge> listTarget = result.get(edge.getTarget());
			listTarget.add(edge);
		}
		return result;
	}
	
	static Stream<Map<Vertex, EObject>> match(Collection<EObject> host, GraphQuery query) {
		return generateMappings(host, query.getContainedVertices(), collectConcernedEdgesByVertex(query.getContainedEdges()));
	}
	
	static Stream<Map<Vertex, EObject>> match(EObject host, GraphQuery query) {
		Collection<EObject> hostObjects = collectIterator(host.eAllContents());
		return match(hostObjects, query);
	}
	
}
