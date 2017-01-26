package datastructures.graph;

import java.util.Map.Entry;
import java.util.Set;

public class UndirectedGraph<T> extends AbstractGraph<T> {

  @Override
  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    if (sourceVertex != null && destVertex != null) {
      Edge<T> edge = new Edge<T>(sourceVertex, destVertex);
      Edge<T> reverseEdge = new Edge<T>(destVertex, sourceVertex);
      sourceVertex.edges.add(edge);
      destVertex.edges.add(reverseEdge);
      return true;
    }
    return false;
  }

  @Override
  public void print() {
    Set<Entry<T, Vertex<T>>> entrySet = vertices.entrySet();
    for (Entry<T, Vertex<T>> entry : entrySet) {
      System.out.println("Vertex: " + entry.getKey() + " | Negihbours=[" + neighboursOf(entry.getValue()) + "]");
    }
  }
}
