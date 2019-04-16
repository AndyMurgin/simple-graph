package com.amurgin.graphs.api;

import java.util.List;
import java.util.Set;

public interface Graph<V, E> {
    boolean addVertex(V vertex);
    boolean addEdge(V vertexA, V vertexB, E edgeEntity);
    Set<V> getAllVertices();
    List<E> getPath(V vertexA, V vertexB);
}
