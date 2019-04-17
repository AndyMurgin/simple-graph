package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DirectedVertexContainer<V, E> extends AbstractVertexContainer<V, E> {

    DirectedVertexContainer(V vertex, Class<E> edgeType) {
        super(vertex, edgeType);
    }

    @Override
    public boolean addEdge(EdgeContainer<V, E> edgeContainer) {
        if (getVertex().equals(edgeContainer.getSource()) && !outcomings.contains(edgeContainer)) {
            outcomings.add(edgeContainer);
            return true;
        } else if (getVertex().equals(edgeContainer.getTarget()) && !incomings.contains(edgeContainer)) {
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
