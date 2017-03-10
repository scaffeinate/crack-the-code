package algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import datastructures.disjointsets.DisjointSetWithPathCompression;
import datastructures.graph.AbstractGraph;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;

public class KruskalMST {
  private AbstractGraph<String> graph = null;
  private DisjointSetWithPathCompression<Vertex<String>> disjointSet = null;

  public KruskalMST() {
    graph = new UndirectedGraph<String>();
    disjointSet = new DisjointSetWithPathCompression<Vertex<String>>();
  }

  public void constructGraph(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Vertex<String> sourceVertex = null, destVertex = null;
      switch (action) {
      case "vertex":
        Vertex<String> vertex = graph.createVertex(values[1]);
        if (vertex != null) {
          disjointSet.makeSet(vertex);
          System.out.println("Created Vertex with label: " + values[1]);
        } else {
          System.out.println("Vertex creation failed for label: " + values[1]);
        }
        break;
      case "edge":
        sourceVertex = graph.getVertex(values[1]);
        destVertex = graph.getVertex(values[2]);
        if (graph.addEdge(sourceVertex, destVertex, Integer.parseInt(values[3]))) {
          System.out.println("Edge created between: " + values[1] + " and " + values[2] + " with weight: " + values[3]);
        } else {
          System.out.println("Either of the vertices dont exist");
        }
        break;
      }
    }
  }

  public List<Edge<String>> minimumSpanningTree() {
    List<Edge<String>> result = new ArrayList<Edge<String>>();
    List<Edge<String>> edges = new ArrayList<Edge<String>>();
    edges.addAll(graph.edgesSet());
    sort(edges);

    for (Edge<String> edge : edges) {
      Vertex<String> sourceVertex = edge.sourceVertex;
      Vertex<String> destVertex = edge.destVertex;

      if (!disjointSet.findSet(sourceVertex).equals(disjointSet.findSet(destVertex))) {
        disjointSet.union(sourceVertex, destVertex);
        result.add(edge);
      }
    }

    return result;
  }

  private void sort(List<Edge<String>> edges) {
    Collections.sort(edges, new Comparator<Edge<String>>() {
      @Override
      public int compare(Edge<String> e1, Edge<String> e2) {
        return Integer.valueOf(e1.weight).compareTo(e2.weight);
      }
    });
  }
}
