package com.amurgin.graphs.core;

public class DirectedDefaultEdgeGraph<V> extends AbstractDefaultEdgeGraph<V> {

    public DirectedDefaultEdgeGraph() {
        super(vertex -> new DirectedVertexContainer<>(vertex, DefaultEdge.class));
    }

    @Override
    public boolean addEdge(V vertexA, V vertexB) {
        return super.addEdge(vertexA, vertexB, null); //not good!
    }
}
