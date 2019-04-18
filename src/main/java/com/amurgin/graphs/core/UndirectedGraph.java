package com.amurgin.graphs.core;

/**
 * Represents implementation of undirected graph with custom
 * vertices and edge entities classes
 * @param <V> graph vertices class
 * @param <E> graph edge entities class
 */
public class UndirectedGraph<V, E> extends AbstractGraph<V, E> {

    public UndirectedGraph(Class<E> edgeType) {
        super(vertex -> new UndirectedVertexContainer<>(vertex, edgeType), CustomEdgeContainer::new);
    }
}
