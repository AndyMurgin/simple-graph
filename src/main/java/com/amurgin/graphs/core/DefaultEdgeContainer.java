package com.amurgin.graphs.core;

class DefaultEdgeContainer<V> extends EdgeEntityContainerMixin<V, DefaultEdge<V>> {

    private DefaultEdge<V> defaultEdge;

    public DefaultEdgeContainer(V start, V end) {
        defaultEdge = new DefaultEdge<>(start, end);
    }

    @Override
    public DefaultEdge<V> getEdgeEntity() {
        return defaultEdge;
    }

    @Override
    public V getStart() {
        return defaultEdge.getStart();
    }

    @Override
    public V getEnd() {
        return defaultEdge.getEnd();
    }
}
