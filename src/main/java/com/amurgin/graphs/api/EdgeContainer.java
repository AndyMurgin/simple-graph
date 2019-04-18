package com.amurgin.graphs.api;

/**
 * Main the API graph edge representation.
 * Besides edge's vertices, also contains some user-defined entity object associated
 * with the graph entity.
 *
 * @param <V> graph vertices class
 * @param <E> graph edge class
 */
public interface EdgeContainer<V, E> extends Edge<V> {

    /**
     * @return user-defined entity object associated with the graph edge
     */
    E getEdgeEntity();

    /**
     * {@inheritDoc}
     */
    @Override
    EdgeContainer<V, E> revert();
}
