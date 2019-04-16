package com.amurgin.graphs.core;

class CustomEdgeContainer<V, E> extends AbstractEdgeVerticesContainer<V, E> {

    public CustomEdgeContainer(V start, V end, E edgeEntity) {
        this.start = start;
        this.end = end;
        this.edgeEntity = edgeEntity;
    }
}
