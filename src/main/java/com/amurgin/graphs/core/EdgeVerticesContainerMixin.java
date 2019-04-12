package com.amurgin.graphs.core;

abstract class EdgeVerticesContainerMixin<V, E> extends EdgeEntityContainerMixin<V, E> {

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
