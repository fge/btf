package com.github.fge;

import javax.annotation.concurrent.Immutable;

/**
 * Interface for a frozen object
 *
 * <p>This interface is closely coupled with {@link Thawed}. The principle is
 * simple: you can obtain a thawed object from a frozen one, and a thawed object
 * can generate a frozen one.</p>
 *
 * <p>By contract, implementations of this interface must be immutable.</p>
 *
 * @param <T> the type of the thawed counterpart
 */
@Immutable
public interface Frozen<T extends Thawed<? extends Frozen<T>>>
{
    /**
     * Return a thawed representation of this frozen object.
     *
     * @return a thawed object
     */
    T thaw();
}

