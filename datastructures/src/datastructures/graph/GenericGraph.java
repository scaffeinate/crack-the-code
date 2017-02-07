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
  
  public boolean depthFirstSearch(Vertex<T> rootVertex, Vertex<T> resultVertex);
  
  public boolean breadthFirstSearch(Vertex<T> rootVertex, Vertex<T> resultVertex);
  
  public void depthFirstTraversal(Vertex<T> rootVertex);
  
  public void breadthFirstTraversal(Vertex<T> rootVertex);
  
  public String depthFirstPath(Vertex<T> rootVertex, Vertex<T> resultVertex);
  
  public int numVertices();
  
  public void print();
}
