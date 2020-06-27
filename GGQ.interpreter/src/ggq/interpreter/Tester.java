package ggq.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.*;

import ggq.gql.*;

public class Tester {

	static EClass authorEClass;
	static EClass bookEClass;
	static EReference authoredEReference;
	static EAttribute bookName;
	static EAttribute authorName;

	static EPackage writingPackage;

	private static void setupMetaModel() {
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage theCorePackage = EcorePackage.eINSTANCE;

		authorEClass = theCoreFactory.createEClass();
		authorEClass.setName("Author");

		bookEClass = theCoreFactory.createEClass();
		bookEClass.setName("Book");

		bookName = theCoreFactory.createEAttribute();
		bookName.setName("name");
		bookName.setEType(theCorePackage.getEString());

		authorName = theCoreFactory.createEAttribute();
		authorName.setName("name");
		authorName.setEType(theCorePackage.getEString());

		authoredEReference = theCoreFactory.createEReference();
		authoredEReference.setName("authored");
		authoredEReference.setEType(bookEClass);
		authoredEReference.setLowerBound(0);
		authoredEReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		// authoredEReference.setContainment(true);

		authorEClass.getEStructuralFeatures().add(authoredEReference);
		authorEClass.getEStructuralFeatures().add(authorName);

		bookEClass.getEStructuralFeatures().add(bookName);

		writingPackage = theCoreFactory.createEPackage();
		writingPackage.getEClassifiers().add(authorEClass);
		writingPackage.getEClassifiers().add(bookEClass);
	}

	private static Collection<EObject> createHostGraph() {
		EFactory theFactory = writingPackage.getEFactoryInstance();

		EObject erichGamma = theFactory.create(authorEClass);
		erichGamma.eSet(authorName, "Erich Gamma");
		EObject richardHelm = theFactory.create(authorEClass);
		richardHelm.eSet(authorName, "Richard Helm");
		EObject ralphJohnson = theFactory.create(authorEClass);
		ralphJohnson.eSet(authorName, "Ralph Johnson");
		EObject johnVlissides = theFactory.create(authorEClass);
		johnVlissides.eSet(authorName, "John Vlissides");
		EObject kentBeck = theFactory.create(authorEClass);
		kentBeck.eSet(authorName, "Kent Beck");
		EObject martinFowler = theFactory.create(authorEClass);
		martinFowler.eSet(authorName, "Martin Fowler");

		EObject designPattners = theFactory.create(bookEClass);
		designPattners.eSet(bookName, "Design Patterns");
		EObject planningExtremeProgramming = theFactory.create(bookEClass);
		planningExtremeProgramming.eSet(bookName, "Planning Extreme Programming");
		EObject contributingToEclipse = theFactory.create(bookEClass);
		contributingToEclipse.eSet(bookName, "Contributing to Eclipse");

		((List<EObject>) erichGamma.eGet(authoredEReference)).add(designPattners);
		((List<EObject>) erichGamma.eGet(authoredEReference)).add(contributingToEclipse);

		((List<EObject>) richardHelm.eGet(authoredEReference)).add(designPattners);
		((List<EObject>) ralphJohnson.eGet(authoredEReference)).add(designPattners);
		((List<EObject>) johnVlissides.eGet(authoredEReference)).add(designPattners);

		((List<EObject>) kentBeck.eGet(authoredEReference)).add(planningExtremeProgramming);
		((List<EObject>) kentBeck.eGet(authoredEReference)).add(contributingToEclipse);

		((List<EObject>) martinFowler.eGet(authoredEReference)).add(planningExtremeProgramming);

		return Arrays.asList(erichGamma, richardHelm, ralphJohnson, johnVlissides, kentBeck, martinFowler,
				designPattners, planningExtremeProgramming, contributingToEclipse);
	}

	private static GraphQuery createGraphQuery1() {
		ModelingFactory factory = ModelingFactory.eINSTANCE;
		GraphQuery query = factory.createGraphQuery();

		Vertex author1 = factory.createVertex();
		author1.setType(authorEClass);
		author1.setId("a1");
		Vertex author2 = factory.createVertex();
		author2.setType(authorEClass);
		author2.setId("a2");

		Vertex commonBook = factory.createVertex();
		commonBook.setType(bookEClass);
		commonBook.setId("b");

		Edge e1 = factory.createEdge();
		e1.setType(authoredEReference);
		e1.setSource(author1);
		e1.setTarget(commonBook);

		Edge e2 = factory.createEdge();
		e2.setType(authoredEReference);
		e2.setSource(author2);
		e2.setTarget(commonBook);

		query.getContainedVertices().add(author1);
		query.getContainedVertices().add(author2);
		query.getContainedVertices().add(commonBook);
		query.getContainedEdges().add(e1);
		query.getContainedEdges().add(e2);

		return query;
	}

	private static GraphQuery createGraphQuery2() {
		ModelingFactory factory = ModelingFactory.eINSTANCE;

		GraphQuery gq = createGraphQuery1();

		Vertex commonBook = gq.getContainedVertices().stream().filter(v -> v.getId().equals("b")).findAny().get();

		Vertex author3 = factory.createVertex();
		author3.setType(authorEClass);
		author3.setId("a3");

		Edge e3 = factory.createEdge();
		e3.setType(authoredEReference);
		e3.setSource(author3);
		e3.setTarget(commonBook);

		gq.getContainedVertices().add(author3);
		gq.getContainedEdges().add(e3);

		return gq;
	}

	private static String prettifyMatch(Map<Vertex, EObject> match) {
		return
			match
			.entrySet()
			.stream()
			.map(entry -> {
				String queryNodeName = entry.getKey().getId();
				EObject hostNode = entry.getValue();
				String hostNodeName = (String) hostNode.eGet(hostNode.eClass() == authorEClass ? authorName : bookName);
	
				return "(" + queryNodeName + " -> " + hostNodeName + ")";
			})
			.sorted()
			.collect(Collectors.joining(", ", "{", "}"));
	}

	/**
	 * Expected results: all combinations of three of the gang of four.
	 */
	public static void main(String... args) {
		setupMetaModel();
		
		boolean useGQ1 = false;
		GraphQuery query = useGQ1 ? createGraphQuery1() : createGraphQuery2(); 

		Interpreter.match(createHostGraph(), query)
			.map(Tester::prettifyMatch)
			.forEach(System.out::println);
	}
}
