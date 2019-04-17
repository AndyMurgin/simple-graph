package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

class DefaultEdgeContainer<V> extends AbstractEdgeEntityContainer<V, DefaultEdge> {

    public DefaultEdgeContainer(V source, V target) {
        edgeEntity = new DefaultEdge(source, target);
    }

    @Override
    public DefaultEdge getEdgeEntity() {
        return edgeEntity;
    }

    @Override
    public V getSource() {
        return TypeUtils.uncheckedCast(edgeEntity.getSource());
    }

    @Override
    public V getTarget() {
        return TypeUtils.uncheckedCast(edgeEntity.getTarget());
    }

    @Override
    public EdgeContainer<V, DefaultEdge> revert() {
        return new DefaultEdgeContainer<>(getTarget(), getSource());
    }
}
