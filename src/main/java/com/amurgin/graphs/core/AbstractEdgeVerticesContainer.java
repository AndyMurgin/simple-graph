package com.amurgin.graphs.core;

abstract class AbstractEdgeVerticesContainer<V, E> extends AbstractEdgeEntityContainer<V, E> {

    protected V source;
    protected V target;

    @Override
    public V getSource() {
        return source;
    }

    @Override
    public V getTarget() {
        return target;
    }
}
