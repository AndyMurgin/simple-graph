package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

abstract class EdgeEntityContainerMixin<V, E> implements EdgeContainer<V, E> {

    protected E edgeEntity;

    @Override
    public E getEdgeEntity() {
        return edgeEntity;
    }
}
