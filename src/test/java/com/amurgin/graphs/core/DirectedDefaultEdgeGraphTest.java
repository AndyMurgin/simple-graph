package com.amurgin.graphs.core;

import com.amurgin.graphs.api.DefaultEdgeGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectedDefaultEdgeGraphTest {

    @Test
    public void simpleStringGraphTest() {
        DefaultEdgeGraph<String> graph = new DirectedDefaultEdgeGraph<>();
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("One", "Two");
        graph.addEdge("Two", "Three");
        List<DefaultEdge> defaultEdges = graph.getPath("One", "Three");
        assertEquals(defaultEdges.size(), 2);
        assertEquals(defaultEdges.get(0).getStart(), "One");
        assertEquals(defaultEdges.get(0).getEnd(), "Two");
        assertEquals(defaultEdges.get(1).getStart(), "Two");
        assertEquals(defaultEdges.get(1).getEnd(), "Three");
    }
}
