package com.amurgin.graphs.core;

class DefaultEdgeContainer<V> extends AbstractEdgeEntityContainer<V, DefaultEdge> {

    public DefaultEdgeContainer(V start, V end) {
        edgeEntity = new DefaultEdge(start, end);
    }

    @Override
    public DefaultEdge getEdgeEntity() {
        return edgeEntity;
    }

    @Override
    public V getStart() {
        return TypeUtils.uncheckedCast(edgeEntity.getStart());
    }

    @Override
    public V getEnd() {
        return TypeUtils.uncheckedCast(edgeEntity.getEnd());
    }
}
