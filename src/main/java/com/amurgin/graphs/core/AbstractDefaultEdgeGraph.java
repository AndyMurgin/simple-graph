package com.amurgin.graphs.core;

import com.amurgin.graphs.api.DefaultEdgeGraph;
import com.amurgin.graphs.api.VertexContainer;

import java.util.function.Function;

abstract class AbstractDefaultEdgeGraph<V> extends AbstractGraph<V, DefaultEdge> implements DefaultEdgeGraph<V> {

    public AbstractDefaultEdgeGraph(Function<V, VertexContainer<V, DefaultEdge>> vertexContainerBuilder) {
        super(vertexContainerBuilder, ((source, target, edge) -> new DefaultEdgeContainer<>(source, target)));
    }
}
