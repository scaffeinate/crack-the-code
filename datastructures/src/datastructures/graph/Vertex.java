package datastructures.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
  T label;
  public List<Edge<T>> edges;

  public Vertex() {
    this(null);
  }

  public Vertex(T label) {
    this.label = label;
    this.edges = new LinkedList<Edge<T>>();
  }

  @Override
  public String toString() {
    return "Vertex [label=" + label + "]";
  }
}
