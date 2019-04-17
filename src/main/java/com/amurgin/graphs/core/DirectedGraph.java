package com.amurgin.graphs.core;

public class DirectedGraph<V, E> extends AbstractGraph<V, E> {

    public DirectedGraph(Class<E> edgeType) {
        super(vertex -> new DirectedVertexContainer<>(vertex, edgeType), CustomEdgeContainer::new);
    }

    @Override
    public boolean addEdge(V source, V target, E edgeEntity) {
        if (edgeEntity == null) {
            throw new IllegalArgumentException("Edge entity shouldn't be null!");
        }
        return super.addEdge(source, target, edgeEntity);
    }
}
