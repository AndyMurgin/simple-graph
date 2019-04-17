package com.amurgin.graphs.core;

import com.amurgin.graphs.api.EdgeContainer;
import com.amurgin.graphs.api.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectedGraphTest {

    @Test
    public void simpleStringGraphContainersTest() {
        Graph<String, Integer> graph = new DirectedGraph<>(Integer.class);
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("One", "Two", 1);
        graph.addEdge("Two", "Three", 2);
        List<EdgeContainer<String, Integer>> edgeContainers = graph.getPath("One", "Three");
        assertEquals(edgeContainers.size(), 2);
        assertEquals(edgeContainers.get(0).getEdgeEntity(), 1);
        assertEquals(edgeContainers.get(0).getSource(), "One");
        assertEquals(edgeContainers.get(0).getTarget(), "Two");
        assertEquals(edgeContainers.get(1).getEdgeEntity(), 2);
        assertEquals(edgeContainers.get(1).getSource(), "Two");
        assertEquals(edgeContainers.get(1).getTarget(), "Three");
    }
}
