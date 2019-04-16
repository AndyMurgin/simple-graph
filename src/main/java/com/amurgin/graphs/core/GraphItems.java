package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.EdgeContainerBuilder;
import com.amurgin.graphs.api.VertexContainer;

import java.util.*;
import java.util.function.Function;

public class GraphItems<V, E> {
    private Map<V, VertexContainer<V, E>> verticesAdjustments;
    private final EdgeContainerBuilder<V, E> edgeContainerBuilder;
    private final Function<V, VertexContainer<V, E>> vertexContainerBuilder;

    public GraphItems(Function<V, VertexContainer<V, E>> vertexContainerBuilder,
                      EdgeContainerBuilder<V, E> edgeContainerBuilder) {
        verticesAdjustments = new HashMap<>();
        this.edgeContainerBuilder = edgeContainerBuilder;
        this.vertexContainerBuilder = vertexContainerBuilder;
    }

    public boolean addVertex(V vertex) {
        if (vertex == null) {
            throw new NullPointerException("Unable to add null vertex");
        }
        if (!contains(vertex)) {
            verticesAdjustments.put(vertex, vertexContainerBuilder.apply(vertex));
            return true;
        }
        return false;
    }

    public boolean addEdge(V vertexA, V vertexB, E edgeEntity) {
        if (!contains(vertexA) || !contains(vertexB)) {
            return false;
        }
        VertexContainer<V, E> sourceContainerForA = verticesAdjustments.get(vertexA);
        sourceContainerForA.addEdge(edgeContainerBuilder.create(vertexA, vertexB, edgeEntity));

        VertexContainer<V, E> sourceContainerForB = verticesAdjustments.get(vertexB);
        sourceContainerForB.addEdge(edgeContainerBuilder.create(vertexA, vertexB, edgeEntity));
        return true;
    }

    public Set<V> getAllVertices() {
        return verticesAdjustments.keySet();
    }

    public GraphPathFinder bfsPathFinder(V source, V target) {
        return new GraphPathFinder(source, target);
    }

    private boolean contains(V vertex) {
        return verticesAdjustments.containsKey(vertex);
    }

    public class GraphPathFinder {

        private Set<V> visited = new HashSet<>();
        private Map<V, Deque<EdgeContainer<V, E>>> pathsToVertices = new HashMap<>();
        private Queue<EdgeContainer<V, E>> traversalQueue = new LinkedList<>();
        private V source; //TODO should be in graph!
        private V target; //TODO should be in graph!
        private List<EdgeContainer<V, E>> resultPath = new ArrayList<>();

        private GraphPathFinder(V source, V target) {
            this.source = source;
            this.target = target;
        }

        public List<EdgeContainer<V, E>> getPath() {
            traversalQueue.addAll(verticesAdjustments.get(source).getOutcomingEdges());
            boolean found = false;
            while (traversalQueue.size() != 0 && resultPath.isEmpty()) {
                processCurrentVertex();
            }
            return resultPath;
        }

        private void processCurrentVertex() {
            EdgeContainer<V, E> currentEdge = traversalQueue.poll();
            if (currentEdge != null) {
                addPathToVertex(currentEdge);
                V current = currentEdge.getEnd();
                if (!visited.contains(current)) {
                    if (current.equals(target)) {
                        resultPath = new ArrayList<>(pathsToVertices.get(current));
                    } else {
                        visited.add(current);
                        traversalQueue.addAll(verticesAdjustments.get(current).getOutcomingEdges());
                    }
                } // else next step
            }
        }

        private void addPathToVertex(EdgeContainer<V, E> currentEdge) {
            if (pathsToVertices.get(currentEdge.getEnd()) == null) {
                Deque<EdgeContainer<V, E>> pathToPreviousVertex = pathsToVertices.computeIfAbsent(currentEdge.getStart(),
                        k -> new LinkedList<>());
                Deque<EdgeContainer<V, E>> pathToCurrentVertex = new LinkedList<>();
                pathToPreviousVertex.forEach(pathToCurrentVertex::addLast);
                pathToCurrentVertex.addLast(currentEdge);
                pathsToVertices.put(currentEdge.getEnd(), pathToCurrentVertex);
            }
        }
    }
}
