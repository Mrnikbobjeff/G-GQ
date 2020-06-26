package ggq.interpreter;

import ggq.gql.Edge;
import ggq.gql.GraphQuery;

public class Tester {
	private static GraphQuery createHostGraph() {
		
	}
	
	private static GraphQuery createQueryGraph() {
		
	}
	
	public static void main(String... args) {
		Interpreter i = new Interpreter();
		Iterable<Iterable<Edge>> matches = i.match(createHostGraph(), createQueryGraph());
		for (Iterable<Edge> match : matches) {
			System.out.print("{");
			
			for (Edge edge : match) {
				System.out.print("(" + edge.getSource().getId() + ", " + edge.getTarget().getId() + "), ");	
			}
			
			System.out.print("}\n");
		}
	}
}
