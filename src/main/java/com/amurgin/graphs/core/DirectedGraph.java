package com.amurgin.graphs.core;

/**
 * Represents implementation of directed graph with custom
 * vertices and edge entities classes
 * @param <V> graph vertices class
 * @param <E> graph edge entities class
 */
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
