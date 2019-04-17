package com.amurgin.graphs.api;

public interface Edge<V> {
    V getSource();
    V getTarget();
    Edge<V> revert();
}
