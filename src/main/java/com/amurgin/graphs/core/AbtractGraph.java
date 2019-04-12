package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.Graph;

import java.util.HashSet;
import java.util.Set;

public abstract class AbtractGraph<V, E> implements Graph<V, E> {
    private Set<V> vertices;
    private Set<EdgeContainer<V, E>> edgeContainers;

    public AbtractGraph(Set<V> vertices) {
        this.vertices = new HashSet<>(vertices);
        this.edgeContainers = new HashSet<>();
    }

    public AbtractGraph() {
        this.vertices = new HashSet<>();
        this.edgeContainers = new HashSet<>();
    }

    @Override
    public void addVertex(V vertex) {
        if (vertex == null) {
            throw new NullPointerException("Unable to add null vertex");
        }
        if (!contains(vertex)) {
            vertices.add(vertex);
        }
    }

    @Override
    public Set<V> getAllVertices() {
        return vertices;
    }

    private boolean contains(V vertex) {
        return vertices.contains(vertex);
    }
}
