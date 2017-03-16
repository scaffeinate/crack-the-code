package algorithms.graph;

import java.util.HashSet;
import java.util.Set;

import datastructures.disjointsets.DisjointSetWithPathCompression;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class ConnectedComponents {

  private DisjointSetWithPathCompression<Vertex<String>> disjointSet = null;
  private UndirectedGraph<String> graph = null;

  public ConnectedComponents() {
    disjointSet = new DisjointSetWithPathCompression<Vertex<String>>();
    graph = new UndirectedGraph<String>();
  }

  public void constructGraph(String[] input) {
    GraphUtil.constructGraph(graph, input);

    Set<Vertex<String>> vertices = graph.verticesSet();
    for (Vertex<String> vertex : vertices) {
      disjointSet.makeSet(vertex);
    }

    Set<Edge<String>> edges = graph.edgesSet();
    for (Edge<String> edge : edges) {
      disjointSet.union(edge.sourceVertex, edge.destVertex);
    }
  }

  public Set<String> connectedComponents() {
    Set<String> componentSet = new HashSet<String>();
    Set<Vertex<String>> disjointSets = disjointSet.disjointSets();

    for (Vertex<String> vertex : disjointSets) {
      componentSet.add(disjointSet.findSet(vertex).label);
    }
    
    System.out.println(componentSet);

    return componentSet;
  }

  public boolean sameComponent(String value1, String value2) {
    Vertex<String> vertex1 = graph.getVertex(value1);
    Vertex<String> vertex2 = graph.getVertex(value2);

    return disjointSet.findSet(vertex1).equals(disjointSet.findSet(vertex2));
  }
}
