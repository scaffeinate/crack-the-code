package datastructures.graph;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
  public T label;
  public List<Edge<T>> incomingEdges;
  public List<Edge<T>> outgoingEdges;

  public Vertex() {
    this(null);
  }

  public Vertex(T label) {
    this.label = label;
    this.incomingEdges = new LinkedList<Edge<T>>();
    this.outgoingEdges = new LinkedList<Edge<T>>();
  }

  @Override
  public String toString() {
    return "Vertex [" + label + "]";
  }
}
