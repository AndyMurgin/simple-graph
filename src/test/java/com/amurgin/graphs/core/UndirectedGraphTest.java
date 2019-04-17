package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UndirectedGraphTest {

    @Test
    public void pathGraphTest() {
        Graph<String, Integer> graph = new UndirectedGraph<>(Integer.class);
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("Two", "One", 1);
        graph.addEdge("Two", "Three", 2);
        List<EdgeContainer<String, Integer>> edgeContainers = graph.getPath("One", "Three");
        assertEquals(2, edgeContainers.size());
        assertEquals(1, edgeContainers.get(0).getEdgeEntity());
        assertEquals("One", edgeContainers.get(0).getSource());
        assertEquals("Two", edgeContainers.get(0).getTarget());
        assertEquals(2, edgeContainers.get(1).getEdgeEntity());
        assertEquals("Two", edgeContainers.get(1).getSource());
        assertEquals("Three", edgeContainers.get(1).getTarget());
    }

    @Test
    public void cycleGraphTest() {
        Graph<Integer, Integer> graph = new UndirectedGraph<>(Integer.class);
        Stream.of(1, 2, 3, 4, 5, 6).forEach(graph::addVertex);
        graph.addEdge(1, 2, 1);
        graph.addEdge(3, 1, 2);
        graph.addEdge(2, 4, 3);
        graph.addEdge(5, 3, 4);
        graph.addEdge(4, 6, 5);
        graph.addEdge(6, 5, 6);
        List<EdgeContainer<Integer, Integer>> edgeContainers = graph.getPath(1, 5);
        assertEquals(2, edgeContainers.size());
        assertEquals(1, edgeContainers.get(0).getSource());
        assertEquals(2, edgeContainers.get(0).getEdgeEntity());
        assertEquals(5, edgeContainers.get(1).getTarget());
        assertEquals(4, edgeContainers.get(1).getEdgeEntity());
    }

    @Test
    public void cycleGraphWithEqualSourceAndTargetTest() {
        Graph<Integer, Integer> graph = new UndirectedGraph<>(Integer.class);
        Stream.of(1, 2, 3, 4, 5, 6).forEach(graph::addVertex);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 3);
        graph.addEdge(4, 5, 4);
        graph.addEdge(5, 6, 5);
        graph.addEdge(6, 1, 6);
        List<EdgeContainer<Integer, Integer>> edgeContainers = graph.getPath(1, 1);
        assertTrue(edgeContainers.isEmpty());
    }

    @Test
    public void disconnectedTest() {
        Graph<Integer, Object> graph = new UndirectedGraph<>(Object.class);
        Stream.of(1, 2).forEach(graph::addVertex);
        List<EdgeContainer<Integer, Object>> edgeContainers = graph.getPath(1, 2);
        assertTrue(edgeContainers.isEmpty());
    }
}
