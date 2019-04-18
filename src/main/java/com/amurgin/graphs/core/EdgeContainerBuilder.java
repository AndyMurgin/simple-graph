package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

@FunctionalInterface
interface EdgeContainerBuilder<V, E> {

    /**
     * Creates new instance of {@link EdgeContainer} by two vertices and
     * edge entity
     * @param source - source vertex of the creating edge
     * @param target - target vertex of the creating edge
     * @param edge - entity associated with the creating edge
     * @return {@link EdgeContainer}
     */
    EdgeContainer<V, E> create(V source, V target, E edge);
}
