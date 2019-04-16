package com.amurgin.graphs.core;

abstract class AbstractEdgeVerticesContainer<V, E> extends AbstractEdgeEntityContainer<V, E> {

    protected V start;
    protected V end;

    @Override
    public V getStart() {
        return start;
    }

    @Override
    public V getEnd() {
        return end;
    }
}
