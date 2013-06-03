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

