/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.ide.ui.tests.framework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.emf.compare.diff.DefaultDiffEngine;

/**
 * Annotation used to select the difference engines used for the test class. For each diff engine, the test
 * methods will be run once.
 * 
 * @author <a href="mailto:mathieu.cartaud@obeo.fr">Mathieu Cartaud</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DiffEngines {

	/**
	 * The list of diff engines to test. If the annotation is used empty, the default array will be returned.
	 * If the annotation is not used the diff engines defined in a default array in the class
	 * EMFCompareGitTestRunner will be used.
	 */
	Class<?>[] value() default {DefaultDiffEngine.class };

}
