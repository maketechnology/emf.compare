/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ide.ui.internal.actions.group;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import org.eclipse.emf.compare.Diff;
import org.eclipse.swt.graphics.Image;

/**
 * This implementation of a {@link DifferenceGroup} uses a predicate to filter the whole list of differences.
 * <p>
 * This can be subclasses or used directly instead of {@link DifferenceGroup}.
 * </p>
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 */
public class DefaultDifferenceGroup implements DifferenceGroup {
	/** The whole unfiltered list of differences. */
	protected final Iterable<? extends Diff> candidates;

	/** The filter we'll use in order to filter the differences that are part of this group. */
	protected final Predicate<? super Diff> filter;

	/** The name that the EMF Compare UI will display for this group. */
	protected final String name;

	/** The icon that the EMF Compare UI will display for this group. */
	protected final Image image;

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences.
	 * <p>
	 * This will use the default name and icon for the group.
	 * </p>
	 * 
	 * @param unfiltered
	 *            The whole unfiltered list of differences.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 */
	public DefaultDifferenceGroup(Iterable<? extends Diff> unfiltered, Predicate<? super Diff> filter) {
		this(unfiltered, filter, "Group", null);
	}

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences. It will be displayed in the UI with the default icon and the given name.
	 * 
	 * @param unfiltered
	 *            The whole unfiltered list of differences.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 * @param name
	 *            The name that the EMF Compare UI will display for this group.
	 */
	public DefaultDifferenceGroup(Iterable<? extends Diff> unfiltered, Predicate<? super Diff> filter,
			String name) {
		this(unfiltered, filter, name, null);
	}

	/**
	 * Instantiates this group given the comparison and filter that should be used in order to determine its
	 * list of differences. It will be displayed in the UI with the given icon and name.
	 * 
	 * @param unfiltered
	 *            The whole unfiltered list of differences.
	 * @param filter
	 *            The filter we'll use in order to filter the differences that are part of this group.
	 * @param name
	 *            The name that the EMF Compare UI will display for this group.
	 * @param image
	 *            The icon that the EMF Compare UI will display for this group.
	 */
	public DefaultDifferenceGroup(Iterable<? extends Diff> unfiltered, Predicate<? super Diff> filter,
			String name, Image image) {
		this.candidates = unfiltered;
		this.filter = filter;
		this.name = name;
		this.image = image;
	}

	public Iterable<? extends Diff> getDifferences() {
		return Iterables.filter(candidates, filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.actions.group.DifferenceGroup#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.ide.ui.internal.actions.group.DifferenceGroup#getImage()
	 */
	public Image getImage() {
		return image;
	}
}