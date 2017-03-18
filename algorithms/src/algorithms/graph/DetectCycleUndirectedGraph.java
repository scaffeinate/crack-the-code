package algorithms.graph;

import java.util.List;
import java.util.Set;

import datastructures.disjointsets.DisjointSetWithPathCompression;
import datastructures.graph.AbstractGraph;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class DetectCycleUndirectedGraph {
  private AbstractGraph<String> graph = null;
  private DisjointSetWithPathCompression<Vertex<String>> disjointSet = null;
  private Set<Vertex<String>> vertices = null;

  public DetectCycleUndirectedGraph() {
    graph = new UndirectedGraph<String>();
    disjointSet = new DisjointSetWithPathCompression<Vertex<String>>();
  }

  public void constructGraph(String[] input) {
    GraphUtil.constructGraph(graph, input);
    vertices = graph.verticesSet();
    for (Vertex<String> vertex : vertices) {
      disjointSet.makeSet(vertex);
    }
  }

  public boolean detectCycle() {
    for (Vertex<String> vertex : vertices) {
      List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
      for (Vertex<String> neighbour : neighbours) {
        if (!disjointSet.findSet(vertex).equals(disjointSet.findSet(neighbour))) {
          disjointSet.union(vertex, neighbour);
          // If we create a union of the vertices then remove the reverse edge
          graph.removeEdge(neighbour, vertex);
        } else {
          return true;
        }
      }
    }
    return false;
  }
}
