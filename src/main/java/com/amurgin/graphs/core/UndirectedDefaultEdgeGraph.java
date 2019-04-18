package com.amurgin.graphs.core;

/**
 * Represents implementation of undirected graph with custom
 * vertices class. {@link DefaultEdge} is used as the graph edge entity.
 * @param <V> graph vertices class
 */
public class UndirectedDefaultEdgeGraph<V> extends AbstractDefaultEdgeGraph<V> {

    public UndirectedDefaultEdgeGraph() {
        super(vertex -> new UndirectedVertexContainer<>(vertex, DefaultEdge.class));
    }
}
