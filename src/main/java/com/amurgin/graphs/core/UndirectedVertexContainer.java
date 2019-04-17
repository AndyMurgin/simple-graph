package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

class UndirectedVertexContainer<V, E> extends AbstractVertexContainer<V, E> {

    UndirectedVertexContainer(V vertex, Class<E> edgeType) {
        super(vertex, edgeType);
    }

    @Override
    public boolean addEdge(EdgeContainer<V, E> edgeContainer) {
        if (getVertex().equals(edgeContainer.getSource())) {
            outcomings.add(edgeContainer);
            incomings.add(edgeContainer.revert());
            return true;
        } else if (getVertex().equals(edgeContainer.getTarget())) {
            incomings.add(edgeContainer);
            outcomings.add(edgeContainer.revert());
            return true;
        } else {
            return false;
        }
    }
}
