package com.amurgin.graphs.api;

import com.amurgin.graphs.core.DefaultEdge;

public interface DefaultEdgeGraph<V> extends Graph<V, DefaultEdge> {
    boolean addEdge(V vertexA, V vertexB);
}