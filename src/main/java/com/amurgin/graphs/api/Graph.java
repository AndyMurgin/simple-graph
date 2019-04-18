package com.amurgin.graphs.api;

import java.util.List;
import java.util.Set;

/**
 * General API for all possible graphs.
 * Clients can use any user-defined classes as graph's vertices and edges.
 * However, it's mandatory required to have properly defined {@code equals(Object o)}
 * and {@code hashcode()} methods for user-defined vertices and edges.
 * 'Properly defined' means following of {@link Object} class documentation.
 *
 * @param <V> vertex class
 * @param <E> edge class
 */
public interface Graph<V, E> {

    /**
     * Adds new vertex to the graph. If such vertex is already included into the graph
     * then the passed vertex won't replace the existing one.
     * Vertex's class should contain properly overridden {@link Object#equals(Object)}
     * and {@link Object#hashCode()} methods for correct graph operations results.
     *
     * @param vertex - new vertex for the graph
     * @return {@code true} in case when the passed vertex has been successfully added
     * to the graph and {@code false} otherwise
     */
    boolean addVertex(V vertex);

    /**
     * Adds new edge for a couple of existing graph's vertices.
     * If any of {@code source} and {@code target} is not contained by the graph
     * then the new edge won't be added.
     *
     * For undirected graphs implementations an order of {@code source} and {@code target}
     * vertices doesn't matter. In other words, {@code addEdge(source, target, entity)} and
     * {@code addEdge(target, source, entity)} are the same for undirected graphs cases.
     *
     * Vertices' and edge entity's classes should contain properly overriden
     * {@link Object#equals(Object)} and {@link Object#hashCode()} methods for correct
     * graph operations results.
     *
     * @param source - source edge's vertex; the vertices order doesn't matter in undirected
     *               graphs.
     * @param target - target edge's vertex; the vertices order doesn't matter in undirected
     *               graphs.
     * @param edgeEntity - user-defined object associated with the adding edge
     * @return {@code true} in case when the new edge has been successfully added
     * to the graph and {@code false} otherwise
     * @throws NullPointerException if the passed edgeEntity is null
     */
    boolean addEdge(V source, V target, E edgeEntity);

    /**
     * @return {@link Set} of all vertices contained be the graph
     */
    Set<V> getAllVertices();

    /**
     * Returns a list of edges between 2 existing vertices.
     * The search algorithm depends on a graph implementation - that also means
     * the result path may be not optimal.
     *
     * @param source - vertex to find s path in graph from
     * @param target - vertex to find s path in graph to
     * @return {@link List<EdgeContainer>} - list of edge wrappers containing
     * vertices and associated entity object for each edge in the found path.
     *
     * @see EdgeContainer
     */
    List<EdgeContainer<V, E>> getPath(V source, V target);
}
