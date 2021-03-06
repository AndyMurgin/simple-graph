package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;

import java.util.*;
import java.util.function.Function;

/**
 * Encapsulates all graph inner structure and provides common operations
 * under graph items (vertices and edges).
 * @param <V> graph vertices class
 * @param <E> graph edges class
 */
class GraphItems<V, E> {
    private Map<V, VertexContainer<V, E>> verticesAdjacents;
    private final EdgeContainerBuilder<V, E> edgeContainerBuilder;
    private final Function<V, VertexContainer<V, E>> vertexContainerBuilder;

    GraphItems(Function<V, VertexContainer<V, E>> vertexContainerBuilder,
                      EdgeContainerBuilder<V, E> edgeContainerBuilder) {
        verticesAdjacents = new HashMap<>();
        this.edgeContainerBuilder = edgeContainerBuilder;
        this.vertexContainerBuilder = vertexContainerBuilder;
    }

    boolean addVertex(final V vertex) {
        if (vertex == null) {
            throw new NullPointerException("Unable to add null vertex");
        }
        if (!contains(vertex)) {
            verticesAdjacents.put(vertex, vertexContainerBuilder.apply(vertex));
            return true;
        }
        return false;
    }

    boolean addEdge(final V source, final V target, final E edgeEntity) {
        if (!contains(source) || !contains(target)) {
            return false;
        }
        VertexContainer<V, E> sourceContainer = verticesAdjacents.get(source);
        sourceContainer.addEdge(edgeContainerBuilder.create(source, target, edgeEntity));

        VertexContainer<V, E> targetContainer = verticesAdjacents.get(target);
        targetContainer.addEdge(edgeContainerBuilder.create(source, target, edgeEntity));
        return true;
    }

    Set<V> getAllVertices() {
        return verticesAdjacents.keySet();
    }

    private void throwOutOfGraphVertexException(V vertex) {
        throw new IllegalArgumentException(String.format("Unable to create GraphPathFinder: " +
                "vertex %s isn't included into the graph", vertex));
    }

    private boolean contains(V vertex) {
        return verticesAdjacents.containsKey(vertex);
    }

    BfsPathFinder bfsPathFinder(V source, V target) {
        if (!contains(source)) {
            throwOutOfGraphVertexException(source);
        } else if (!contains(target)) {
            throwOutOfGraphVertexException(target);
        }
        return new BfsPathFinder(source, target);
    }

    /**
     * Instances of the class are intended to find path using Breadth-first search algorithm
     * (<a href="https://en.wikipedia.org/wiki/Breadth-first_search">Wikipedia</a>).
     *
     * Each new search requires to create new BfsPathFinder instance.
     */
    public class BfsPathFinder {

        private Set<V> visited = new HashSet<>();
        private Map<V, Deque<EdgeContainer<V, E>>> pathsToVertices = new HashMap<>();
        private Queue<EdgeContainer<V, E>> traversalQueue = new LinkedList<>();
        private V source;
        private V target;
        private List<EdgeContainer<V, E>> resultPath = new ArrayList<>();

        private BfsPathFinder(V source, V target) {
            this.source = source;
            this.target = target;
        }

        List<EdgeContainer<V, E>> getPath() {
            if (source.equals(target)) {
                return resultPath; //empty ArrayList //TODO is there need to return not empty list?
            }
            traversalQueue.addAll(verticesAdjacents.get(source).getOutcomingEdges());
            while (traversalQueue.size() != 0 && resultPath.isEmpty()) {
                processCurrentVertex();
            }
            return resultPath;
        }

        private void processCurrentVertex() {
            EdgeContainer<V, E> currentEdge = traversalQueue.poll();
            if (currentEdge != null) {
                addPathToVertex(currentEdge);
                V current = currentEdge.getTarget();
                if (!visited.contains(current)) {
                    if (current.equals(target)) {
                        resultPath = new ArrayList<>(pathsToVertices.get(current));
                    } else {
                        visited.add(current);
                        traversalQueue.addAll(verticesAdjacents.get(current).getOutcomingEdges());
                    }
                } // else next step
            }
        }

        private void addPathToVertex(EdgeContainer<V, E> currentEdge) {
            if (pathsToVertices.get(currentEdge.getTarget()) == null) {
                Deque<EdgeContainer<V, E>> pathToPreviousVertex = pathsToVertices.computeIfAbsent(currentEdge.getSource(),
                        k -> new LinkedList<>());
                Deque<EdgeContainer<V, E>> pathToCurrentVertex = new LinkedList<>();
                pathToPreviousVertex.forEach(pathToCurrentVertex::addLast);
                pathToCurrentVertex.addLast(currentEdge);
                pathsToVertices.put(currentEdge.getTarget(), pathToCurrentVertex);
            }
        }
    }
}
