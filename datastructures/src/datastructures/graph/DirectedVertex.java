package datastructures.graph;

import java.util.List;

public class DirectedVertex<T> extends Vertex<T> {
  public List<Edge<T>> incomingEdges;
  public List<Edge<T>> outGoingEdges;
}
