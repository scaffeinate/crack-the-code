package datastructures.graph;

import java.util.List;

public class DirectedGraph<T> extends AbstractGraph<T> {

  @Override
  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    if (sourceVertex != null && destVertex != null) {
      Edge<T> edge = new Edge<T>(sourceVertex, destVertex);
      ((DirectedVertex<T>) sourceVertex).outGoingEdges.add(edge);
      ((DirectedVertex<T>) destVertex).incomingEdges.add(edge);
      return true;
    }
    return false;
  }

  @Override
  public Edge<T> getEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    List<Edge<T>> outGoingEdges = ((DirectedVertex<T>) sourceVertex).outGoingEdges;
    for (Edge<T> edge : outGoingEdges) {
      if (edge.destVertex.equals(destVertex)) {
        return edge;
      }
    }

    return null;
  }

  @Override
  public void print() {

  }
}
