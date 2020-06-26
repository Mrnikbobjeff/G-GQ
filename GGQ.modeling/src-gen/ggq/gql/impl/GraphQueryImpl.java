/**
 */
package ggq.gql.impl;

import ggq.gql.Edge;
import ggq.gql.GraphQuery;
import ggq.gql.ModelingPackage;
import ggq.gql.Vertex;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ggq.gql.impl.GraphQueryImpl#getContainedVertices <em>Contained Vertices</em>}</li>
 *   <li>{@link ggq.gql.impl.GraphQueryImpl#getContainedEdges <em>Contained Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphQueryImpl extends MinimalEObjectImpl.Container implements GraphQuery {
	/**
	 * The cached value of the '{@link #getContainedVertices() <em>Contained Vertices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedVertices()
	 * @generated
	 * @ordered
	 */
	protected EList<Vertex> containedVertices;

	/**
	 * The cached value of the '{@link #getContainedEdges() <em>Contained Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> containedEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelingPackage.Literals.GRAPH_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Vertex> getContainedVertices() {
		if (containedVertices == null) {
			containedVertices = new EObjectContainmentEList<Vertex>(Vertex.class, this,
					ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES);
		}
		return containedVertices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Edge> getContainedEdges() {
		if (containedEdges == null) {
			containedEdges = new EObjectContainmentEList<Edge>(Edge.class, this,
					ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES);
		}
		return containedEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES:
			return ((InternalEList<?>) getContainedVertices()).basicRemove(otherEnd, msgs);
		case ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES:
			return ((InternalEList<?>) getContainedEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES:
			return getContainedVertices();
		case ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES:
			return getContainedEdges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES:
			getContainedVertices().clear();
			getContainedVertices().addAll((Collection<? extends Vertex>) newValue);
			return;
		case ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES:
			getContainedEdges().clear();
			getContainedEdges().addAll((Collection<? extends Edge>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES:
			getContainedVertices().clear();
			return;
		case ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES:
			getContainedEdges().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ModelingPackage.GRAPH_QUERY__CONTAINED_VERTICES:
			return containedVertices != null && !containedVertices.isEmpty();
		case ModelingPackage.GRAPH_QUERY__CONTAINED_EDGES:
			return containedEdges != null && !containedEdges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphQueryImpl
