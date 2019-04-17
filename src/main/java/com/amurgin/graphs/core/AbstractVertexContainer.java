package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.VertexContainer;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractVertexContainer<V, E> implements VertexContainer<V, E> {

    private V vertex;
    private Class<E> edgeType;
    protected Set<EdgeContainer<V, E>> incomings;
    protected Set<EdgeContainer<V, E>> outcomings;

    public AbstractVertexContainer(V vertex, Class<E> edgeType) {
        this.vertex = vertex;
        this.edgeType = edgeType;
        incomings = new HashSet<>();
        outcomings = new HashSet<>();
    }

    @Override
    public V getVertex() {
        return vertex;
    }

    @Override
    public Class<E> getEdgeType() {
        return edgeType;
    }
}
