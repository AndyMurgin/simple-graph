package com.amurgin.graphs.core;

import com.amurgin.graphs.api.DefaultEdgeGraph;
import com.amurgin.graphs.api.EdgeContainer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectedDefaultEdgeGraphTest {

    @Test
    public void pathGraphTest() {
        DefaultEdgeGraph<String> graph = new DirectedDefaultEdgeGraph<>();
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("One", "Two");
        graph.addEdge("Two", "Three");
        List<EdgeContainer<String, DefaultEdge>> defaultEdgeContainers = graph.getPath("One", "Three");
        assertEquals(2, defaultEdgeContainers.size());
        assertEquals("One", defaultEdgeContainers.get(0).getSource());
        assertEquals("One", defaultEdgeContainers.get(0).getEdgeEntity().getSource());
        assertEquals("Two", defaultEdgeContainers.get(0).getTarget());
        assertEquals("Two", defaultEdgeContainers.get(0).getEdgeEntity().getTarget());
        assertEquals("Two", defaultEdgeContainers.get(1).getSource());
        assertEquals("Two", defaultEdgeContainers.get(1).getEdgeEntity().getSource());
        assertEquals("Three", defaultEdgeContainers.get(1).getTarget());
        assertEquals("Three", defaultEdgeContainers.get(1).getEdgeEntity().getTarget());
    }

    @Test
    public void cycleGraphTest() {
        DefaultEdgeGraph<Integer> graph = new DirectedDefaultEdgeGraph<>();
        Stream.of(1, 2, 3, 4, 5, 6).forEach(graph::addVertex);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        List<EdgeContainer<Integer, DefaultEdge>> defaultEdgeContainers = graph.getPath(1, 5);
        assertEquals(2, defaultEdgeContainers.size());
        assertEquals(1, defaultEdgeContainers.get(0).getSource());
        assertEquals(5, defaultEdgeContainers.get(1).getTarget());
    }

    @Test
    public void cycleGraphWithEqualSourceAndTargetTest() {
        DefaultEdgeGraph<Integer> graph = new DirectedDefaultEdgeGraph<>();
        Stream.of(1, 2, 3, 4, 5, 6).forEach(graph::addVertex);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 1);
        List<EdgeContainer<Integer, DefaultEdge>> defaultEdgeContainers = graph.getPath(1, 1);
        assertTrue(defaultEdgeContainers.isEmpty());
    }

    @Test
    public void disconnectedTest() {
        DefaultEdgeGraph<Integer> graph = new DirectedDefaultEdgeGraph<>();
        Stream.of(1, 2).forEach(graph::addVertex);
        List<EdgeContainer<Integer, DefaultEdge>> defaultEdgeContainers = graph.getPath(1, 2);
        assertTrue(defaultEdgeContainers.isEmpty());
    }
}
