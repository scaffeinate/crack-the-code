package datastructures.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UndirectedGraph<T> implements GenericGraph<T> {
  private Map<T, Vertex<T>> vertices;

  public UndirectedGraph() {
    vertices = new HashMap<T, Vertex<T>>();
  }

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
  public Vertex<T> createVertex(T label) {
    Vertex<T> v = new Vertex<T>(label);
    vertices.put(label, v);
    return v;
  }

  @Override
  public boolean addVertex(Vertex<T> v, T label) {
    return (vertices.put(label, v)) != null;
  }

  @Override
  public boolean containsVertex(T label) {
    return vertices.containsKey(label);
  }

  @Override
  public Vertex<T> getVertex(T label) {
    return vertices.get(label);
  }

  @Override
  public List<Edge<T>> edgesOf(Vertex<T> v) {
    if (v != null) {
      return v.edges;
    }
    return null;
  }

  @Override
  public List<Vertex<T>> neighboursOf(Vertex<T> v) {
    List<Vertex<T>> neighboursList = new LinkedList<Vertex<T>>();
    if (v != null) {
      List<Edge<T>> edges = v.edges;
      for (Edge<T> edge : edges) {
        neighboursList.add(edge.destVertex);
      }
    }

    return neighboursList;
  }

  @Override
  public Edge<T> getEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    List<Edge<T>> edges = sourceVertex.edges;
    for (Edge<T> edge : edges) {
      if (edge.destVertex.equals(destVertex)) {
        return edge;
      }
    }
    return null;
  }

  @Override
  public int numVertices() {
    return vertices.size();
  }

  public void print() {
    Set<Entry<T, Vertex<T>>> entrySet = vertices.entrySet();
    for (Entry<T, Vertex<T>> entry : entrySet) {
      System.out.println("Vertex: " + entry.getKey() + " | Negihbours=[" + neighboursOf(entry.getValue()) + "]");
    }
  }
}
