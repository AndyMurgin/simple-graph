package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Objects;

/**
 * Inner graph edge representation containing source and target edge's vertices.
 * Uses {@link DefaultEdge} as edge entity. Intended for cases when there is no
 * need in user-defined classes associated with graph edges.
 * @param <V> graph vertices class
 */
class DefaultEdgeContainer<V> extends AbstractEdgeEntityContainer<V, DefaultEdge> {

    DefaultEdgeContainer(V source, V target) {
        edgeEntity = new DefaultEdge(source, target);
    }

    @Override
    public DefaultEdge getEdgeEntity() {
        return edgeEntity;
    }

    @Override
    public V getSource() {
        return TypeUtils.uncheckedCast(edgeEntity.getSource());
    }

    @Override
    public V getTarget() {
        return TypeUtils.uncheckedCast(edgeEntity.getTarget());
    }

    @Override
    public EdgeContainer<V, DefaultEdge> revert() {
        return new DefaultEdgeContainer<>(getTarget(), getSource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeEntity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        DefaultEdgeContainer<?> container = (DefaultEdgeContainer<?>) obj;
        return Objects.equals(edgeEntity, container.edgeEntity);
    }
}
