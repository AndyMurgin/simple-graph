package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

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
}
