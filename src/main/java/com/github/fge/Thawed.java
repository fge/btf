/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of this file and of both licenses is available at the root of this
 * project or, if you have the jar distribution, in directory META-INF/, under
 * the names LGPL-3.0.txt and ASL-2.0.txt respectively.
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge;

import javax.annotation.concurrent.NotThreadSafe;

/**
 * Interface for a thawed object
 *
 * <p>This interface is closely coupled with {@link Frozen}. The principle is
 * simple: you can obtain a thawed object from a frozen one, and a thawed object
 * can generate a frozen one.</p>
 *
 * <p>Implementations of this interface are mutable and offer no guarantee of
 * thread safety.</p>
 *
 * @param <F> the type of the frozen representation
 */
@NotThreadSafe
public interface Thawed<F extends Frozen<? extends Thawed<F>>>
{
    /**
     * Obtain a frozen representation of this thawed object
     *
     * @return a frozen, immutable object
     */
    F freeze();
}

