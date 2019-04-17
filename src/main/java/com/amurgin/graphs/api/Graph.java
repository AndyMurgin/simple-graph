package com.amurgin.graphs.api;

import java.util.List;
import java.util.Set;

public interface Graph<V, E> {
    boolean addVertex(V vertex);
    boolean addEdge(V source, V target, E edgeEntity);
    Set<V> getAllVertices();
    List<EdgeContainer<V, E>> getPath(V source, V target);
}
