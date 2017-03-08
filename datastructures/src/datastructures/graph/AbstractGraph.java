package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public abstract class AbstractGraph<T> implements GenericGraph<T> {
  protected Map<T, Vertex<T>> vertices = null;
  protected Set<Vertex<T>> verticesSet = null;
  protected Set<Edge<T>> edgesSet = null;
  private GraphType graphType = null;

  public AbstractGraph(GraphType graphType) {
    vertices = new HashMap<T, Vertex<T>>();
    verticesSet = new HashSet<Vertex<T>>();
    edgesSet = new HashSet<Edge<T>>();
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
      sourceVertex.numberOfOutgoingEdges++;
      destVertex.incomingEdges.add(edge);
      destVertex.numberOfIncomingEdges++;
      edgesSet.add(edge);
      
      if (graphType.equals(GraphType.UNDIRECTED)) {
        Edge<T> reverseEdge = new Edge<T>(destVertex, sourceVertex, weight);
        destVertex.outgoingEdges.add(reverseEdge);
        destVertex.numberOfOutgoingEdges++;
        sourceVertex.incomingEdges.add(reverseEdge);
        sourceVertex.numberOfIncomingEdges++;
        edgesSet.add(reverseEdge);
      }
      
      return true;
    }
    
    return false;
  }

  @Override
  public Vertex<T> createVertex(T label) {
    Vertex<T> v = new Vertex<T>(label);
    vertices.put(label, v);
    verticesSet.add(v);
    return v;
  }

  @Override
  public boolean addVertex(Vertex<T> v, T label) {
    vertices.put(label, v);
    return verticesSet.add(v);
  }

  @Override
  public boolean removeEdge(Vertex<T> sourceVertex, Vertex<T> destVertex) {
    Edge<T> edge = getEdge(sourceVertex, destVertex);
    
    sourceVertex.outgoingEdges.remove(edge);
    destVertex.incomingEdges.remove(edge);
    edgesSet.remove(edge);

    if(graphType == GraphType.UNDIRECTED) {
      Edge<T> reverseEdge = getEdge(destVertex, sourceVertex);
      sourceVertex.incomingEdges.remove(reverseEdge);
      destVertex.outgoingEdges.remove(reverseEdge);
      edgesSet.remove(reverseEdge);
    }
    
    return true;
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
  public boolean depthFirstSearch(Vertex<T> sourceVertex, Vertex<T> resultVertex) {
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    return depthFirstSearch(sourceVertex, resultVertex, visitedSet);
  }

  private boolean depthFirstSearch(Vertex<T> sourceVertex, Vertex<T> resultVertex, Set<Vertex<T>> visitedSet) {
    if (sourceVertex.equals(resultVertex)) {
      return true;
    }

    visitedSet.add(sourceVertex);

    List<Vertex<T>> neighbours = neighboursOf(sourceVertex);
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
  public boolean breadthFirstSearch(Vertex<T> sourceVertex, Vertex<T> resultVertex) {
    if (sourceVertex.equals(resultVertex)) {
      return true;
    }

    Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    queue.add(sourceVertex);
    visitedSet.add(sourceVertex);

    while (!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      List<Vertex<T>> neighbours = neighboursOf(current);

      for (Vertex<T> vertex : neighbours) {
        if (!visitedSet.contains(vertex)) {
          if (vertex.equals(resultVertex)) {
            return true;
          } else {
            queue.add(vertex);
            visitedSet.add(current);
          }
        }
      }
    }

    return false;
  }

  @Override
  public String depthFirstPath(Vertex<T> sourceVertex, Vertex<T> resultVertex) {
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    List<Vertex<T>> pathList = new ArrayList<Vertex<T>>();
    depthFirstPath(sourceVertex, resultVertex, visitedSet, pathList);
    StringBuilder builder = new StringBuilder();
    for (Vertex<T> vertex : pathList) {
      builder.append(vertex.label).append("->");
    }

    return builder.substring(0, builder.length() - 2).toString();
  }

  private boolean depthFirstPath(Vertex<T> sourceVertex, Vertex<T> resultVertex, Set<Vertex<T>> visitedSet,
      List<Vertex<T>> pathList) {
    if (sourceVertex.equals(resultVertex)) {
      pathList.add(sourceVertex);
      return true;
    }

    visitedSet.add(sourceVertex);
    pathList.add(sourceVertex);

    List<Vertex<T>> neighbours = neighboursOf(sourceVertex);
    for (Vertex<T> vertex : neighbours) {
      if (!visitedSet.contains(vertex)) {
        if (depthFirstPath(vertex, resultVertex, visitedSet, pathList)) {
          return true;
        }

        pathList.remove(vertex);
      }
    }

    return false;
  }

  @Override
  public void depthFirstTraversal(Vertex<T> sourceVertex) {
    Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    stack.push(sourceVertex);
    StringBuilder builder = new StringBuilder();

    while (!stack.isEmpty()) {
      Vertex<T> top = stack.peek();
      if (!visitedSet.contains(top)) {
        builder.append(top.label);
        visitedSet.add(top);
      }

      List<Vertex<T>> neighbours = neighboursOf(top);
      Vertex<T> vertex = null;
      for (Vertex<T> v : neighbours) {
        if (!visitedSet.contains(v)) {
          vertex = v;
          break;
        }
      }

      if (vertex == null) {
        stack.pop();
      } else {
        stack.push(vertex);
        builder.append("->");
      }
    }

    System.out.println(builder.toString());
  }

  @Override
  public void breadthFirstTraversal(Vertex<T> sourceVertex) {
    Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
    Set<Vertex<T>> visitedSet = new HashSet<Vertex<T>>();
    queue.add(sourceVertex);
    visitedSet.add(sourceVertex);
    StringBuilder builder = new StringBuilder();

    while (!queue.isEmpty()) {
      Vertex<T> current = queue.poll();
      builder.append(current.label).append("->");

      List<Vertex<T>> neighbours = neighboursOf(current);
      for (Vertex<T> v : neighbours) {
        if (!visitedSet.contains(v)) {
          queue.add(v);
          visitedSet.add(v);
        }
      }
    }

    builder.setLength(builder.length() - 2);
    System.out.println(builder.toString());
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

  public Set<Vertex<T>> verticesSet() {
    return this.verticesSet;
  }
  
  public Set<Edge<T>> edgesSet() {
    return this.edgesSet;
  }
}
