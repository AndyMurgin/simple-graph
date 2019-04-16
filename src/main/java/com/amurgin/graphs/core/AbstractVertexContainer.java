package com.amurgin.graphs.core;

import com.amurgin.graphs.api.VertexContainer;

abstract class AbstractVertexContainer<V, E> implements VertexContainer<V, E> {

    private V vertex;
    private Class<E> edgeType;

    public AbstractVertexContainer(V vertex, Class<E> edgeType) {
        this.vertex = vertex;
        this.edgeType = edgeType;
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
