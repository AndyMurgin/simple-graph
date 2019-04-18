package com.amurgin.graphs.core;

/**
 * Represents implementation of directed graph with custom
 * vertices class. {@link DefaultEdge} is used as the graph edge entity.
 * @param <V> graph vertices class
 */
public class DirectedDefaultEdgeGraph<V> extends AbstractDefaultEdgeGraph<V> {

    public DirectedDefaultEdgeGraph() {
        super(vertex -> new DirectedVertexContainer<>(vertex, DefaultEdge.class));
    }
}
