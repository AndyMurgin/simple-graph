package com.amurgin.graphs.core;

import com.amurgin.graphs.api.DefaultEdgeGraph;
import com.amurgin.graphs.api.EdgeContainer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndirectedDefaultEdgeGraphTest {

    @Test
    public void simpleStringGraphTest() {
        DefaultEdgeGraph<String> graph = new UndirectedDefaultEdgeGraph<>();
        graph.addVertex("One");
        graph.addVertex("Two");
        graph.addVertex("Three");
        graph.addEdge("Two", "One");
        graph.addEdge("Two", "Three");
        List<EdgeContainer<String, DefaultEdge>> defaultEdgeContainers = graph.getPath(
                "One", "Three");
        assertEquals(defaultEdgeContainers.size(), 2);
        assertEquals(defaultEdgeContainers.get(0).getSource(), "One");
        assertEquals(defaultEdgeContainers.get(0).getEdgeEntity().getSource(), "One");
        assertEquals(defaultEdgeContainers.get(0).getTarget(), "Two");
        assertEquals(defaultEdgeContainers.get(0).getEdgeEntity().getTarget(), "Two");
        assertEquals(defaultEdgeContainers.get(1).getSource(), "Two");
        assertEquals(defaultEdgeContainers.get(1).getEdgeEntity().getSource(), "Two");
        assertEquals(defaultEdgeContainers.get(1).getTarget(), "Three");
        assertEquals(defaultEdgeContainers.get(1).getEdgeEntity().getTarget(), "Three");
    }
}
