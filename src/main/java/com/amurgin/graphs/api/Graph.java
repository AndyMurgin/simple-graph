package com.amurgin.graphs.api;

import java.util.List;
import java.util.Set;

public interface Graph<V, E> {
    void addVertex(V vertex);
    void addEdge(E edge);
    Set<V> getAllVertices();
    List<E> getPath(V vertexA, V vertexB);
}
