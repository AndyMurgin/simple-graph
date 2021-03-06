package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.Graph;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * Supposed to be used as parent class for all graphs implementations.
 * @param <V> graph vertex class
 * @param <E> graph edge class
 */
abstract class AbstractGraph<V, E> implements Graph<V, E> {

    private GraphItems<V, E> graphItems;

    public AbstractGraph(Function<V, VertexContainer<V, E>> vertexContainerBuilder,
                         EdgeContainerBuilder<V, E> edgeContainerBuilder) {
        this.graphItems = new GraphItems<>(vertexContainerBuilder, edgeContainerBuilder);
    }

    @Override
    public boolean addVertex(final V vertex) {
        return graphItems.addVertex(vertex);
    }

    @Override
    public boolean addEdge(final V source, final V target, final E edgeEntity) {
        return graphItems.addEdge(source, target, edgeEntity);
    }

    @Override
    public Set<V> getAllVertices() {
        return graphItems.getAllVertices();
    }

    @Override
    public List<EdgeContainer<V, E>> getPath(final V source, final V target) {
        return graphItems.bfsPathFinder(source, target).getPath();
    }
}