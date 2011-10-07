/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.compare.diagram.diagramdiff.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.diagram.diagramdiff.util.DiagramdiffAdapterFactory;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramdiffItemProviderAdapterFactory extends DiagramdiffAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramdiffItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramShowElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramShowElementItemProvider diagramShowElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramShowElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramShowElementAdapter() {
		if (diagramShowElementItemProvider == null) {
			diagramShowElementItemProvider = new DiagramShowElementItemProvider(this);
		}

		return diagramShowElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramHideElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramHideElementItemProvider diagramHideElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramHideElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramHideElementAdapter() {
		if (diagramHideElementItemProvider == null) {
			diagramHideElementItemProvider = new DiagramHideElementItemProvider(this);
		}

		return diagramHideElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramMoveNode} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramMoveNodeItemProvider diagramMoveNodeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramMoveNode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramMoveNodeAdapter() {
		if (diagramMoveNodeItemProvider == null) {
			diagramMoveNodeItemProvider = new DiagramMoveNodeItemProvider(this);
		}

		return diagramMoveNodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramEdgeChange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramEdgeChangeItemProvider diagramEdgeChangeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramEdgeChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramEdgeChangeAdapter() {
		if (diagramEdgeChangeItemProvider == null) {
			diagramEdgeChangeItemProvider = new DiagramEdgeChangeItemProvider(this);
		}

		return diagramEdgeChangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramLabelChange} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramLabelChangeItemProvider diagramLabelChangeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramLabelChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramLabelChangeAdapter() {
		if (diagramLabelChangeItemProvider == null) {
			diagramLabelChangeItemProvider = new DiagramLabelChangeItemProvider(this);
		}

		return diagramLabelChangeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChangeLeftTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramModelElementChangeLeftTargetItemProvider diagramModelElementChangeLeftTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChangeLeftTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramModelElementChangeLeftTargetAdapter() {
		if (diagramModelElementChangeLeftTargetItemProvider == null) {
			diagramModelElementChangeLeftTargetItemProvider = new DiagramModelElementChangeLeftTargetItemProvider(this);
		}

		return diagramModelElementChangeLeftTargetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChangeRightTarget} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramModelElementChangeRightTargetItemProvider diagramModelElementChangeRightTargetItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.emf.compare.diagram.diagramdiff.DiagramModelElementChangeRightTarget}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDiagramModelElementChangeRightTargetAdapter() {
		if (diagramModelElementChangeRightTargetItemProvider == null) {
			diagramModelElementChangeRightTargetItemProvider = new DiagramModelElementChangeRightTargetItemProvider(this);
		}

		return diagramModelElementChangeRightTargetItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (diagramShowElementItemProvider != null) diagramShowElementItemProvider.dispose();
		if (diagramHideElementItemProvider != null) diagramHideElementItemProvider.dispose();
		if (diagramMoveNodeItemProvider != null) diagramMoveNodeItemProvider.dispose();
		if (diagramEdgeChangeItemProvider != null) diagramEdgeChangeItemProvider.dispose();
		if (diagramLabelChangeItemProvider != null) diagramLabelChangeItemProvider.dispose();
		if (diagramModelElementChangeLeftTargetItemProvider != null) diagramModelElementChangeLeftTargetItemProvider.dispose();
		if (diagramModelElementChangeRightTargetItemProvider != null) diagramModelElementChangeRightTargetItemProvider.dispose();
	}

}