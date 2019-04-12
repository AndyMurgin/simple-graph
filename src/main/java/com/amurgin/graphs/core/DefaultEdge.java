package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Edge;

class DefaultEdge<V> implements Edge<V> {

    private V start;
    private V end;

    DefaultEdge(V start, V end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public V getStart() {
        return null;
    }

    @Override
    public V getEnd() {
        return null;
    }
}
