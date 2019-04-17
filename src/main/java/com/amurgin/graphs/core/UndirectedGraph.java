package com.amurgin.graphs.core;

public class UndirectedGraph<V, E> extends AbstractGraph<V, E> {
    public UndirectedGraph(Class<E> edgeType) {
        super(vertex -> new UndirectedVertexContainer<>(vertex, edgeType), CustomEdgeContainer::new);
    }
}
