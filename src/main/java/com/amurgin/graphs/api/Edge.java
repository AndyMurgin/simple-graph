package com.amurgin.graphs.api;

/**
 * Common interface for all graph edges. Represent some connection
 * between two graph's vertices.
 * The class is not intended to be used by the API clients and serves for
 * internal purposes. See {@link EdgeContainer} as the API clients
 * available graph edge representation.
 *
 * @param <V>
 */
public interface Edge<V> {

    /**
     * @return source vertex of the edge; for undirected graphs case it is
     * just one of 2 edge vertices
     */
    V getSource();

    /**
     * @return target vertex of the edge; for undirected graphs case it is
     * just one of 2 edge vertices
     */
    V getTarget();

    /**
     * @return new Edge whose source and target switched their places
     */
    Edge<V> revert();
}
