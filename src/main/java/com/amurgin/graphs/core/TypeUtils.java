package com.amurgin.graphs.core;

public class TypeUtils {

    /**
     * Casts an object to a type.
     *
     * @param o object to be cast
     * @param <T> the type of the result
     *
     * @return the result of the cast
     */
    @SuppressWarnings("unchecked")
    public static <T> T uncheckedCast(Object o)
    {
        return (T) o;
    }
}
