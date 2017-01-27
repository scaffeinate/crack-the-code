package datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public abstract class AbstractGraph<T> implements GenericGraph<T> {
  protected Map<T, Vertex<T>> vertices;
  private GraphType graphType;

  public AbstractGraph(GraphType graphType) {
    vertices = new HashMap<T, Vertex<T>>();
    this.graphType = graphType;
  }
  
  @Override
  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    return addEdge(sourceVertex, destVertex, 0);
  }

  @Override
  public boolean addEdge(Vertex<T> sourceVertex, Vertex<T> destVertex, int weight) {
    if (sourceVertex != null && destVertex != null) {
      Edge<T> edge = new Edge<T>(sourceVertex, destVertex, weight);
      sourceVertex.outgoingEdges.add(edge);
      destVertex.incomingEdges.add(edge);
      if (graphType.equals(GraphType.UNDIRECTED)) {
        Edge<T> reverseEdge = new Edge<T>(destVertex, sourceVertex, weight);
        destVertex.outgoingEdges.add(reverseEdge);
        sourceVertex.incomingEdges.add(reverseEdge);
      }
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
      return v.outgoingEdges;
    }
    return null;
  }

  @Override
  public List<Vertex<T>> neighboursOf(Vertex<T> v) {
    List<Vertex<T>> neighbours = null;
    if (v != null) {
      neighbours = new LinkedList<Vertex<T>>();
      List<Edge<T>> outgoingEdges = v.outgoingEdges;
      for (Edge<T> edge : outgoingEdges) {
        neighbours.add(edge.destVertex);
      }
    }
    return neighbours;
  }

  @Override
  public Edge<T> getEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    List<Edge<T>> outGoingEdges = sourceVertex.outgoingEdges;
    for (Edge<T> edge : outGoingEdges) {
      if (edge.destVertex.equals(destVertex)) {
        return edge;
      }
    }

    return null;
  }

  @Override
  public boolean depthFirstSearch(Vertex<T> rootVertex, Vertex<T> resultVertex) {
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    return depthFirstSearch(rootVertex, resultVertex, visitedSet);
  }

  @Override
  public boolean breadthFirstSearch(Vertex<T> rootVertex, Vertex<T> resultVertex) {
    if (rootVertex.equals(resultVertex)) {
      return true;
    }
    
    Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    queue.add(rootVertex);
    
    while(!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      visitedSet.add(current);
      List<Vertex<T>> neighbours = neighboursOf(current);
      
      for(Vertex<T> vertex:neighbours) {
        if(!visitedSet.contains(vertex)) {
          if(vertex.equals(resultVertex)) {
            return true;
          } else {
            queue.add(vertex);
          }
        }
      }
    }
    
    return false;
  }

  private boolean depthFirstSearch(Vertex<T> rootVertex, Vertex<T> resultVertex, Set<Vertex<T>> visitedSet) {
    if (rootVertex.equals(resultVertex)) {
      return true;
    }

    visitedSet.add(rootVertex);

    List<Vertex<T>> neighbours = neighboursOf(rootVertex);
    for (Vertex<T> vertex : neighbours) {
      if (!visitedSet.contains(vertex)) {
        if (depthFirstSearch(vertex, resultVertex, visitedSet)) {
          return true;
        }
      }
    }

    return false;
  }

  @Override
  public void print() {
    Set<Entry<T, Vertex<T>>> entrySet = vertices.entrySet();
    for (Entry<T, Vertex<T>> entry : entrySet) {
      System.out.println("Vertex: " + entry.getKey() + " | Neighbours=[" + neighboursOf(entry.getValue()) + "]");
    }
  }

  @Override
  public int numVertices() {
    return vertices.size();
  }
}
