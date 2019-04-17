package com.amurgin.graphs.core;

public class UndirectedDefaultEdgeGraph<V> extends AbstractDefaultEdgeGraph<V> {

    public UndirectedDefaultEdgeGraph() {
        super(vertex -> new UndirectedVertexContainer<>(vertex, DefaultEdge.class));
    }
}
