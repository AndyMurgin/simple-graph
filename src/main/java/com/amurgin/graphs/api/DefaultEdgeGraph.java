package com.amurgin.graphs.api;

import com.amurgin.graphs.core.DefaultEdge;

/**
 * Extension of {@link Graph} where {@link DefaultEdge} is used
 * as entity associated to graph edges.
 * Such graph allows clients to do not care about custom edge entity
 * if they don't need it.
 *
 * @param <V> - graphs' vertices class
 */
public interface DefaultEdgeGraph<V> extends Graph<V, DefaultEdge> {

    /**
     * Adds new edge for a couple of existing graph's vertices.
     * If any of {@code source} and {@code target} is not contained by the graph
     * then the new edge won't be added.
     *
     * This method is preferred to use for all {@link DefaultEdgeGraph} as
     * {@link Graph#addEdge(Object, Object, Object)} is not optimized and efficient for them.
     *
     * For undirected graphs implementations an order of {@code source} and {@code target}
     * vertices doesn't matter. In other words, {@code addEdge(source, target, entity)} and
     * {@code addEdge(target, source, entity)} are the same for undirected graphs cases.
     *
     * Vertex class should contain properly overriden
     * {@link Object#equals(Object)} and {@link Object#hashCode()} methods for correct
     * graph operations results.
     *
     * @param source - source edge's vertex; the vertices order doesn't matter in undirected
     *               graphs.
     * @param target - target edge's vertex; the vertices order doesn't matter in undirected
     *               graphs.
     * @return {@code true} in case when the new edge has been successfully added
     * to the graph and {@code false} otherwise
     */
    boolean addEdge(V source, V target); //TODO hide Graph#addEdge for the API clients

    //TODO override Graph#getPath to return List<Edge>
}
