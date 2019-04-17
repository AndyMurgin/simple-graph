package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Edge;

class CustomEdgeContainer<V, E> extends AbstractEdgeVerticesContainer<V, E> {

    public CustomEdgeContainer(V source, V target, E edgeEntity) {
        this.source = source;
        this.target = target;
        this.edgeEntity = edgeEntity;
    }

    @Override
    public Edge<V> revert() {
        return new CustomEdgeContainer<>(target, source, edgeEntity);
    }
}
