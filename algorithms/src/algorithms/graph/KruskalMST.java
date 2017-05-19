package algorithms.graph;

import datastructures.disjointsets.DisjointSetWithPathCompression;
import datastructures.graph.AbstractGraph;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KruskalMST {
  private AbstractGraph<String> graph = null;
  private DisjointSetWithPathCompression<Vertex<String>> disjointSet = null;

  public KruskalMST() {
    graph = new UndirectedGraph<String>();
    disjointSet = new DisjointSetWithPathCompression<Vertex<String>>();
  }

  public void constructGraph(String[] input) {
    GraphUtil.constructGraph(graph, input);
    Set<Vertex<String>> vertices = graph.verticesSet();
    for (Vertex<String> vertex : vertices) {
      disjointSet.makeSet(vertex);
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

      if(disjointSet.union(sourceVertex, destVertex)) {
        result.add(edge);
      }
    }

    return result;
  }

  private void sort(List<Edge<String>> edges) {
    Collections.sort(edges, (Edge<String> e1, Edge<String> e2) -> (Integer.valueOf(e1.weight).compareTo(e2.weight) ));
  }
}
