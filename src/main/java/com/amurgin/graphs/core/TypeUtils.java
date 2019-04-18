package com.amurgin.graphs.core;

class TypeUtils {

    /**
     * Casts an object to a type.
     *
     * @param o object to be cast
     * @param <T> the type of the result
     *
     * @return the result of the cast
     */
    @SuppressWarnings("unchecked")
    static <T> T uncheckedCast(Object o) {
        return (T) o;
    }
}
