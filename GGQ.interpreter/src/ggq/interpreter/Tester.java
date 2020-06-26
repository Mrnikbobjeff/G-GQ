package ggq.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;

import ggq.gql.GraphQuery;
import ggq.gql.ModelingFactory;
import ggq.gql.Vertex;

public class Tester {
	
	private static Collection<EObject> createHostGraph() {
		return Collections.emptyList();
	}
	
	private static GraphQuery createQueryGraph() {
		ModelingFactory factory = ModelingFactory.eINSTANCE;
		return factory.createGraphQuery();
	}
	
	public static void main(String... args) {
		Interpreter i = new Interpreter();
		Stream<Map<Vertex, EObject>> matches = i.match(createHostGraph(), createQueryGraph());
		matches.forEach(match -> {
			System.out.print("{");
			
			for (Map.Entry<Vertex, EObject> entry : match.entrySet()) {
				
				System.out.print("(" + entry.getKey().getId() + ", " + entry.getValue() + "), ");	
			}
			
			System.out.print("}\n");
		});
	}
}
