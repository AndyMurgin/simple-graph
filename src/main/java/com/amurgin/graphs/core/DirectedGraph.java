package com.amurgin.graphs.core;

public class DirectedGraph<V, E> extends AbstractGraph<V, E> {

    public DirectedGraph(Class<E> edgeType) {
        super(vertex -> new DirectedVertexContainer<>(vertex, edgeType), CustomEdgeContainer::new);
    }
}
