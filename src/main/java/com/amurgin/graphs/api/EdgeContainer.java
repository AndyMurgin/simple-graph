package com.amurgin.graphs.api;

public interface EdgeContainer<V, E> extends Edge<V> {
    E getEdgeEntity();
}
