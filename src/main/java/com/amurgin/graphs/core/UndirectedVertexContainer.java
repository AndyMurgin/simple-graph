package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.HashSet;
import java.util.Set;

public class UndirectedVertexContainer<V, E> extends AbstractVertexContainer<V, E> {

    private Set<EdgeContainer<V, E>> edgeContainers;

    public UndirectedVertexContainer(V vertex, Class<E> edgeType) {
        super(vertex, edgeType);
        edgeContainers = new HashSet<>();
    }

    @Override
    public boolean addEdge(EdgeContainer<V, E> edgeContainer) {
        if ((getVertex().equals(edgeContainer.getStart()) || getVertex().equals(edgeContainer.getEnd()))
                && !edgeContainers.contains(edgeContainer)) {
            edgeContainers.add(edgeContainer);
            return true;
        }
        return false;
    }

    @Override
    public Set<EdgeContainer<V, E>> getAllEdges() {
        return edgeContainers;
    }

    @Override
    public Set<EdgeContainer<V, E>> getIncomingEdges() {
        return edgeContainers;
    }

    @Override
    public Set<EdgeContainer<V, E>> getOutcomingEdges() {
        return edgeContainers;
    }
}
