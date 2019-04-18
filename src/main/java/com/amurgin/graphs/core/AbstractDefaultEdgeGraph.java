package com.amurgin.graphs.core;

import com.amurgin.graphs.api.DefaultEdgeGraph;

import java.util.function.Function;

abstract class AbstractDefaultEdgeGraph<V> extends AbstractGraph<V, DefaultEdge> implements DefaultEdgeGraph<V> {

    public AbstractDefaultEdgeGraph(Function<V, VertexContainer<V, DefaultEdge>> vertexContainerBuilder) {
        super(vertexContainerBuilder, ((source, target, edge) -> new DefaultEdgeContainer<>(source, target)));
    }

    @Override
    public boolean addEdge(V source, V target) {
        return super.addEdge(source, target, DefaultEdge.empty()); //TODO avoid DefaultEdge mock
    }
}
