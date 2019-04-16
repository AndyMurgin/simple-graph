package com.amurgin.graphs.api;

public interface EdgeContainerBuilder<V, E> {
    EdgeContainer<V, E> create(V source, V target, E edge);
}
