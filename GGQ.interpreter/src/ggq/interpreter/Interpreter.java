package ggq.interpreter;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Interpreter {
	
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
