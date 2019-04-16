package com.amurgin.graphs.core;

import com.amurgin.graphs.api.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectedGraphTest {

    @Test
    public void simpleStringGraphTest() {
        Graph<String, Integer> graph = new DirectedGraph<>(Integer.class);
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("One", "Two", 1);
        graph.addEdge("Two", "Three", 2);
        List<Integer> defaultEdges = graph.getPath("One", "Three");
        assertEquals(defaultEdges.size(), 2);
        assertEquals(defaultEdges.get(0), 1);
        assertEquals(defaultEdges.get(1), 2);
    }
}
