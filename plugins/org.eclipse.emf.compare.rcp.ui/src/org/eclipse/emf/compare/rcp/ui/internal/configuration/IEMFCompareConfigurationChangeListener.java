/*******************************************************************************
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.rcp.ui.internal.configuration;

import com.google.common.base.Predicate;

import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.domain.ICompareEditingDomain;
import org.eclipse.emf.compare.internal.merge.MergeMode;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.filters.IDifferenceFilter;
import org.eclipse.emf.compare.rcp.ui.internal.structuremergeviewer.groups.IDifferenceGroupProvider;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public interface IEMFCompareConfigurationChangeListener {

	void comparisonChange(Comparison oldValue, Comparison newValue);

	void editingDomainChange(ICompareEditingDomain oldValue, ICompareEditingDomain newValue);

	void selectedDifferenceGroupProviderChange(IDifferenceGroupProvider oldValue,
			IDifferenceGroupProvider newValue);

	void selectedDifferenceFiltersChange(Set<IDifferenceFilter> oldValue, Set<IDifferenceFilter> newValue);

	void aggregatedViewerPredicateChange(Predicate<? super EObject> oldValue,
			Predicate<? super EObject> newValue);

	void adapterFactoryChange(AdapterFactory oldValue, AdapterFactory newValue);

	/**
	 * @param oldValue
	 * @param newValue
	 */
	void comparatorChange(EMFCompare oldValue, EMFCompare newValue);

	/**
	 * @param oldValue
	 * @param newValue
	 */
	void mergePreviewModeChange(MergeMode oldValue, MergeMode newValue);

	void comparisonScopeChange(IComparisonScope oldValue, IComparisonScope newValue);

}