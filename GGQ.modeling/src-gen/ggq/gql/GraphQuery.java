/**
 */
package ggq.gql;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ggq.gql.GraphQuery#getContainedVertices <em>Contained Vertices</em>}</li>
 *   <li>{@link ggq.gql.GraphQuery#getContainedEdges <em>Contained Edges</em>}</li>
 * </ul>
 *
 * @see ggq.gql.ModelingPackage#getGraphQuery()
 * @model
 * @generated
 */
public interface GraphQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Contained Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link ggq.gql.Vertex}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Vertices</em>' containment reference list.
	 * @see ggq.gql.ModelingPackage#getGraphQuery_ContainedVertices()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Vertex> getContainedVertices();

	/**
	 * Returns the value of the '<em><b>Contained Edges</b></em>' containment reference list.
	 * The list contents are of type {@link ggq.gql.Edge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Edges</em>' containment reference list.
	 * @see ggq.gql.ModelingPackage#getGraphQuery_ContainedEdges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getContainedEdges();

} // GraphQuery
