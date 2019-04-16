package com.amurgin.graphs.api;

import java.util.Set;

public interface VertexContainer<V, E> {
    V getVertex();
    Class<E> getEdgeType();
    boolean addEdge(EdgeContainer<V, E> edge);
    Set<EdgeContainer<V, E>> getAllEdges();
    Set<EdgeContainer<V, E>> getIncomingEdges();
    Set<EdgeContainer<V, E>> getOutcomingEdges();
}
