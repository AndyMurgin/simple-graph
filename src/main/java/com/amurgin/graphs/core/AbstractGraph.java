package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.EdgeContainerBuilder;
import com.amurgin.graphs.api.Graph;
import com.amurgin.graphs.api.VertexContainer;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

abstract class AbstractGraph<V, E> implements Graph<V, E> {

    private GraphItems<V, E> graphItems;

    public AbstractGraph(Function<V, VertexContainer<V, E>> vertexContainerBuilder,
                         EdgeContainerBuilder<V, E> edgeContainerBuilder) {
        this.graphItems = new GraphItems<>(vertexContainerBuilder, edgeContainerBuilder);
    }

    @Override
    public boolean addVertex(V vertex) {
        return graphItems.addVertex(vertex);
    }

    @Override
    public boolean addEdge(V vertexA, V vertexB, E edgeEntity) {
        return graphItems.addEdge(vertexA, vertexB, edgeEntity);
    }

    @Override
    public Set<V> getAllVertices() {
        return graphItems.getAllVertices();
    }

    @Override
    public List<E> getPath(V vertexA, V vertexB) {
        List<EdgeContainer<V, E>> edgeContainersPath = graphItems.bfsPathFinder(vertexA, vertexB).getPath();
        return edgeContainersPath.stream().map(EdgeContainer::getEdgeEntity).collect(Collectors.toList());
    }
}