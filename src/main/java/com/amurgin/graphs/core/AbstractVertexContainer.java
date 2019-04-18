package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class AbstractVertexContainer<V, E> implements VertexContainer<V, E> {

    private V vertex;
    private Class<E> edgeType;
    protected Set<EdgeContainer<V, E>> incomings;
    protected Set<EdgeContainer<V, E>> outcomings;

    public AbstractVertexContainer(V vertex, Class<E> edgeType) {
        this.vertex = vertex;
        this.edgeType = edgeType;
        incomings = new HashSet<>();
        outcomings = new HashSet<>();
    }

    @Override
    public V getVertex() {
        return vertex;
    }

    @Override
    public Class<E> getEdgeType() {
        return edgeType;
    }

    @Override
    public Set<EdgeContainer<V, E>> getAllEdges() {
        return Stream.of(incomings, outcomings)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<EdgeContainer<V, E>> getIncomingEdges() {
        return incomings;
    }

    @Override
    public Set<EdgeContainer<V, E>> getOutcomingEdges() {
        return outcomings;
    }
}
