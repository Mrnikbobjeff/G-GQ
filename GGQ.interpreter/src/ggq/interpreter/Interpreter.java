package ggq.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Interpreter {
	
	private List<Iterable<Edge>> matches = new ArrayList<>();
	
	void emitMatch(Iterable<Edge> match) {
		matches.add(match);
	}
	
	boolean checkEdge(EReference type, Iterable<Edge> match, GraphQuery hostGraph) {
		return false;
	}
	
	List<Vertex> getCandidateNodes(EClass type, GraphQuery hostGraph) {
		return Collections.emptyList();
	}
	
	Iterable<Edge> addMapping(Iterable<Edge> m, Vertex n, Vertex v, GraphQuery h) {
		return Collections.emptyList();
	}
	
	void extendMatch(int i, Iterable<Edge> m, GraphQuery q, GraphQuery h) {
		if (i == q.getContainedVertices().size()) {
			boolean valid = true;
			for (Edge e : q.getContainedEdges()) {
				valid = valid && checkEdge(e.getType(), m, h);
			}
			
			if (valid) {
				emitMatch(m);
			}
		}
		
		Vertex n = q.getContainedVertices().get(i);
		Iterable<Vertex> V = getCandidateNodes(n.getType(), h);
		for (Vertex v : V) {
			Iterable<Edge> newM = addMapping(m, n, v, h);
			extendMatch(i + 1, newM, q, h);
		}
	}
	
	private Stream<Map<Vertex, EObject>> generatePossibleMappings(Collection<EObject> host, GraphQuery query) {
		return Stream.empty();
	}
	
	private boolean isMappingAMatch(Map<Vertex, EObject> mapping, Collection<EObject> host, GraphQuery query) {
		return false;
	}
	
	Stream<Map<Vertex, EObject>> match(Collection<EObject> host, GraphQuery query) {
		return generatePossibleMappings(host, query).filter(mapping -> isMappingAMatch(mapping, host, query));
	}
	
}
