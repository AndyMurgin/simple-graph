package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DirectedVertexContainer<V, E> extends AbstractVertexContainer<V, E> {

    private Set<EdgeContainer<V, E>> incomings;
    private Set<EdgeContainer<V, E>> outcomings;

    public DirectedVertexContainer(V vertex, Class<E> edgeType) {
        super(vertex, edgeType);
        incomings = new HashSet<>();
        outcomings = new HashSet<>();
    }

    @Override
    public boolean addEdge(EdgeContainer<V, E> edgeContainer) {
        if (getVertex().equals(edgeContainer.getStart()) && !outcomings.contains(edgeContainer)) {
            outcomings.add(edgeContainer);
            return true;
        } else if (getVertex().equals(edgeContainer.getEnd()) && !incomings.contains(edgeContainer)) {
            incomings.add(edgeContainer);
            return true;
        }
        return false;
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
