/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.compare.diagram.ide.ui.decoration.provider;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.diagram.DiagramDiff;
import org.eclipse.emf.compare.diagram.ide.ui.EMFCompareDiagramIDEUIMessages;
import org.eclipse.emf.compare.diagram.ide.ui.GMFCompareUIPlugin;
import org.eclipse.emf.compare.diagram.ide.ui.decoration.DiffEdgeDecorator;
import org.eclipse.emf.compare.diagram.ide.ui.decoration.DiffLabelDecorator;
import org.eclipse.emf.compare.diagram.ide.ui.decoration.DiffNodeDecorator;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The graphical decorator for comparison.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class DiffDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	/** The decorator marker for diff. used also to annotate the diagrams during comparison. */
	public static final String DIFF = "diff-marker"; //$NON-NLS-1$

	/** Constant for added element. */
	public static final String DIFF_ADDED = "diff-added"; //$NON-NLS-1$

	/** Constant for removed element. */
	public static final String DIFF_REMOVED = "diff-removed"; //$NON-NLS-1$

	/** Constant for moved element. */
	public static final String DIFF_MOVED = "diff-moved"; //$NON-NLS-1$

	/** Constant for hided element. */
	public static final String DIFF_HIDED = "diff-hided"; //$NON-NLS-1$

	/** Constant for showed element. */
	public static final String DIFF_SHOWED = "diff-showed"; //$NON-NLS-1$

	/** Constant for modified element. */
	public static final String DIFF_MODIFIED = "diff-modified"; //$NON-NLS-1$

	/** Constant for modified element. */
	public static final String DIFF_LABEL_MODIFIED = "diff-label-modified"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateDecoratorsOperation) {
			final IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation)
					.getDecoratorTarget();
			return shouldDecorate(decoratorTarget);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		final View view = (View)decoratorTarget.getAdapter(View.class);
		if (shouldDecorate(view)) {
			final ITextAwareEditPart label = (ITextAwareEditPart)decoratorTarget
					.getAdapter(ITextAwareEditPart.class);

			if (label != null && isNode(view)) {
				// a label = a node representation + a textholder
				decoratorTarget.installDecorator(DIFF, new DiffLabelDecorator(decoratorTarget));
			} else if (isEdge(view)) {
				decoratorTarget.installDecorator(DIFF, new DiffEdgeDecorator(decoratorTarget));
			} else if (isNode(view)) {
				decoratorTarget.installDecorator(DIFF, new DiffNodeDecorator(decoratorTarget));
			} else {
				final String errorMsg = EMFCompareDiagramIDEUIMessages.getString(
						"DiffDecoratorProvider.UnknownView", view); //$NON-NLS-1$
				final IStatus status = new Status(IStatus.WARNING, GMFCompareUIPlugin.PLUGIN_ID, errorMsg);
				GMFCompareUIPlugin.getDefault().getLog().log(status);
			}
		}
	}

	/**
	 * Check the EAnnotations list of the view to find the diff one.
	 * 
	 * @param decoratorTarget
	 *            the target to test
	 * @return true if target should be decorated ( diff EAnnotation is set )
	 */
	public static boolean shouldDecorate(IDecoratorTarget decoratorTarget) {
		return shouldDecorate((View)decoratorTarget.getAdapter(View.class));
	}

	/**
	 * Check the EAnnotations list of the view to find the diff one.
	 * 
	 * @param view
	 *            the view element to check
	 * @return true if view should be decorated ( diff EAnnotation is set )
	 */
	public static boolean shouldDecorate(final View view) {
		return !(view instanceof Diagram) && getRelatedSelectedDifference(view) != null;
	}

	/**
	 * Check if the view is a link representation.
	 * 
	 * @param view
	 *            the gmf view
	 * @return true if the view is an edge
	 */
	private static boolean isEdge(View view) {
		return view != null && (view instanceof Edge) && view.eContainer() instanceof Diagram;
	}

	/**
	 * Check if the view is a node representation.
	 * 
	 * @param view
	 *            the gmf view
	 * @return true if the view is a node
	 */
	private static boolean isNode(View view) {
		return view != null && (view instanceof Node);
	}

	public static DiagramDiff getRelatedSelectedDifference(View view) {
		SelectedDiffAdapter adapter = getSelectedDiffAdapter(view);
		if (adapter != null) {
			Notifier notifier = adapter.getTarget();
			if (notifier instanceof DiagramDiff) {
				return (DiagramDiff)notifier;
			}
		}
		return null;
	}

	private static SelectedDiffAdapter getSelectedDiffAdapter(View view) {
		Iterator<Adapter> adapters = view.eAdapters().iterator();
		while (adapters.hasNext()) {
			Adapter adapter = adapters.next();
			if (adapter.isAdapterForType(DiagramDiff.class)) {
				return (SelectedDiffAdapter)adapter;
			}
		}
		return null;
	}

}
