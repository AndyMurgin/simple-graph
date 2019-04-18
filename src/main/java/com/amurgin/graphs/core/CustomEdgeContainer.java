package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Objects;

class CustomEdgeContainer<V, E> extends AbstractEdgeVerticesContainer<V, E> {

    CustomEdgeContainer(V source, V target, E edgeEntity) {
        this.source = source;
        this.target = target;
        this.edgeEntity = edgeEntity;
    }

    @Override
    public EdgeContainer<V, E> revert() {
        return new CustomEdgeContainer<>(target, source, edgeEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target, edgeEntity);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomEdgeContainer<?, ?> container = (CustomEdgeContainer<?, ?>) obj;
        return Objects.equals(source, container.source) &&
                Objects.equals(target, container.target) &&
                Objects.equals(edgeEntity, container.edgeEntity);
    }
}
