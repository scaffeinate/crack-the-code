package algorithms.problems;

import java.util.HashSet;
import java.util.Set;

import datastructures.disjointsets.DisjointSetWithPathCompression;
import datastructures.graph.AbstractGraph;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;

public class ConnectedComponents {

  private DisjointSetWithPathCompression<Vertex<Integer>> disjointSet = null;
  private AbstractGraph<Integer> graph = null;

  public ConnectedComponents() {
    disjointSet = new DisjointSetWithPathCompression<Vertex<Integer>>();
    graph = new UndirectedGraph<Integer>();
  }

  public void constructGraph(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Vertex<Integer> sourceVertex = null, destVertex = null;
      switch (action) {
      case "vertex":
        Vertex<Integer> vertex = graph.createVertex(Integer.parseInt(values[1]));
        if (vertex != null) {
          disjointSet.makeSet(vertex);
          System.out.println("Created Vertex with label: " + values[1]);
        } else {
          System.out.println("Vertex creation failed for label: " + values[1]);
        }
        break;
      case "edge":
        sourceVertex = graph.getVertex(Integer.parseInt(values[1]));
        destVertex = graph.getVertex(Integer.parseInt(values[2]));
        if (graph.addEdge(sourceVertex, destVertex)) {
          disjointSet.union(sourceVertex, destVertex);
          System.out.println("Edge created between: " + values[1] + " and " + values[2]);
        } else {
          System.out.println("Either of the vertices dont exist");
        }
        break;
      }
    }
  }

  public Set<Integer> connectedComponents() {
    Set<Integer> componentSet = new HashSet<Integer>();
    Set<Vertex<Integer>> vertices = graph.verticesSet();

    for (Vertex<Integer> vertex : vertices) {
      componentSet.add(disjointSet.findSet(vertex).label);
    }

    return componentSet;
  }

  public boolean sameComponent(String value1, String value2) {
    Vertex<Integer> vertex1 = graph.getVertex(Integer.parseInt(value1));
    Vertex<Integer> vertex2 = graph.getVertex(Integer.parseInt(value2));

    return disjointSet.findSet(vertex1).equals(disjointSet.findSet(vertex2));
  }
}
