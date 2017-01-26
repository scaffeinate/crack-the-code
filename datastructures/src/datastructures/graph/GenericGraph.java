package datastructures.graph;

import java.util.List;

public interface GenericGraph<T> {

  public Vertex<T> createVertex(T label);

  public boolean addVertex(Vertex<T> v, T label);

  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex);
  
  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex, int weight);
  
  public boolean containsVertex(T label);
  
  public Vertex<T> getVertex(T label);
  
  public List<Edge<T>> edgesOf(Vertex<T> v);
  
  public List<Vertex<T>> neighboursOf(Vertex<T> v);
  
  public Edge<T> getEdge(Vertex<T> sourceVertex, Vertex<T> destVertex);
  
  public int numVertices();
  
  public void print();
}
