package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.Set;

/**
 * Inner structure containing graph's vertex and all its edges.
 * @param <V> graph vertices class
 * @param <E> graph edges entity class
 */
interface VertexContainer<V, E> {

    /**
     * @return vertex which the container related to.
     */
    V getVertex();

    /**
     * @return class of an edge entity
     */
    Class<E> getEdgeType();

    /**
     * Adds new edge to the container's vertex adjacent
     * @param edge - {@link EdgeContainer} representing adding graph edge
     * @return {@code true} if the passed edge has been successfully added
     * to the container (and to the graph), and {@code false} otherwise
     */
    boolean addEdge(EdgeContainer<V, E> edge);

    /**
     * @return list of all the vertex's edges;
     * for directed graphs the result list is merged from
     * {@link this#getIncomingEdges()} and {@link this#getOutcomingEdges()};
     * for undirected graphs the method returns the same list as
     * {@link this#getIncomingEdges()} or {@link this#getOutcomingEdges()} do.
     */
    Set<EdgeContainer<V, E>> getAllEdges();

    /**
     * @return list of all edges which has the container's vertex as target
     * for directed graphs;
     * for undirected graphs - returns all the container's vertex edges
     * (as well as {@link this#getAllEdges()})
     */
    Set<EdgeContainer<V, E>> getIncomingEdges();

    /**
     * @return list of all edges which has the container's vertex as source
     * for directed graphs;
     * for undirected graphs - returns all the container's vertex edges
     * (as well as {@link this#getAllEdges()})
     */
    Set<EdgeContainer<V, E>> getOutcomingEdges();
}
