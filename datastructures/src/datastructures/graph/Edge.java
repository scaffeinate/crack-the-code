package datastructures.graph;

public class Edge<T> {
  public int weight = 0;
  public Vertex<T> sourceVertex;
  public Vertex<T> destVertex;

  public Edge() {
    this(null, null);
  }

  public Edge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    this(sourceVertex, destVertex, 0);
  }

  public Edge(Vertex<T> sourceVertex, Vertex<T> destVertex, int weight) {
    this.sourceVertex = sourceVertex;
    this.destVertex = destVertex;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Edge [ sourceVertex=" + sourceVertex + ", destVertex=" + destVertex + ", weight=" + weight + " ]";
  }
}
