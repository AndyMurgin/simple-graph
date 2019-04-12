package com.amurgin.graphs.core;

public class CustomEdgeContainer<V, E> extends EdgeVerticesContainerMixin<V, E> {

    public CustomEdgeContainer(V start, V end, E edgeEntity) {
        this.start = start;
        this.end = end;
        this.edgeEntity = edgeEntity;
    }
}
