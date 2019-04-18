# simple-graph
Simple library for creating different types of graphs and finding the path between two vertices.   

Directed and undirected graphs are supported.   

# Examples
Use your own classes as graph vertices and edges:    
```
Graph<String, Integer> graph = new DirectedGraph<>(Integer.class);   
graph.addVertex("One");
graph.addVertex("Two");
graph.addVertex("Three");
graph.addEdge("One", "Two", 1);
graph.addEdge("Two", "Three", 2);
```
Or simply use predefined graphs with library default edge entity:
```
DefaultEdgeGraph<String> graph = new DirectedDefaultEdgeGraph<>();
graph.addVertex("One");
graph.addVertex("Two");
graph.addVertex("Three");
graph.addEdge("One", "Two");
graph.addEdge("Two", "Three");
```
**Please, note!** All user-defined vertices and edges classes using for graphs should contain properly implemented `hashcode()` and `equals(Object o)` methods - this is critical for stable library work!

Find a possible path between two vertices in a graph:
```
List<EdgeContainer<String, Integer>> edgeContainers = graph.getPath("One", "Three");
```
`EdgeContainer<V, E>` is an edge representation containing two edge vertices (source and target - in case of Directed graphs) and object associated with the edge (Integer instance in the example above).   
Current only Breadth-first search algorithm is used under the hood.

# Possible future features

1. More clear API for `DefaultEdgeGraph<V, E>`.
1. Add possibility to use different Graph path search algorithms.
1. Support for graph traverse using user-defined functions for applying it to graph vertices.
1. Support for weighted graphs.
1. Thread-safety.   

*Inspired by [jGrapht](https://github.com/jgrapht/jgrapht) - for more complex graph operations it is recommended to use it.*


