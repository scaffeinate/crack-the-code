package algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.heap.HeapType;
import datastructures.heap.PriorityQueue;

public class DijkstraShortestPath {
  private AbstractGraph<String> graph = null;
  private PriorityQueue<Integer, Vertex<String>> priorityQueue = null;
  private Map<Vertex<String>, Vertex<String>> parentVerticesMap = null;
  private Map<Vertex<String>, Integer> distancesMap = null;
  private Vertex<String> sourceVertex = null;

  public DijkstraShortestPath() {
    graph = new UndirectedGraph<String>();
    priorityQueue = new PriorityQueue<Integer, Vertex<String>>(HeapType.MIN_HEAP);
    parentVerticesMap = new HashMap<Vertex<String>, Vertex<String>>();
    distancesMap = new HashMap<Vertex<String>, Integer>();
  }

  public void constructGraph(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Vertex<String> sourceVertex = null, destVertex = null;
      switch (action) {
      case "vertex":
        Vertex<String> vertex = graph.createVertex(values[1]);
        if (vertex != null) {
          System.out.println("Created Vertex with label: " + values[1]);
        } else {
          System.out.println("Vertex creation failed for label: " + values[1]);
        }
        break;
      case "edge":
        sourceVertex = graph.getVertex(values[1]);
        destVertex = graph.getVertex(values[2]);
        if (graph.addEdge(sourceVertex, destVertex, Integer.parseInt(values[3]))) {
          System.out.println("Edge created between: " + values[1] + " and " + values[2] + " with weight: " + values[3]);
        } else {
          System.out.println("Either of the vertices dont exist");
        }
        break;
      }
    }
  }

  public void computeShortestPath(String sourceLabel) {
    Vertex<String> sourceVertex = graph.getVertex(sourceLabel);
    if(sourceVertex == null) {
      return;
    }
    
    this.sourceVertex = sourceVertex;
    Set<Vertex<String>> vertices = graph.verticesSet();
    int defaultDistance = Integer.MAX_VALUE;
    for (Vertex<String> vertex : vertices) {
      if (vertex.equals(sourceVertex)) {
        priorityQueue.insert(0, vertex);
        distancesMap.put(vertex, 0);
        parentVerticesMap.put(vertex, null);
      } else {
        priorityQueue.insert(defaultDistance, vertex);
      }
    }

    while (!priorityQueue.isEmpty()) {
      Vertex<String> vertex = priorityQueue.extractValue();

      List<Edge<String>> outgoingEdges = vertex.outgoingEdges;
      for (Edge<String> edge : outgoingEdges) {
        Vertex<String> neighbor = edge.destVertex;
        int distance = distancesMap.get(vertex) + edge.weight;
        if (priorityQueue.contains(neighbor) && priorityQueue.decreaseKey(neighbor, (distance))) {
          parentVerticesMap.put(neighbor, vertex);
          distancesMap.put(neighbor, distance);
        }
      }
    }
  }

  public List<String> getShortestPathTo(String label) {
    List<String> resultList = new ArrayList<String>();
    Vertex<String> vertex = graph.getVertex(label);
    Vertex<String> parent = parentVerticesMap.get(vertex);
    resultList.add(vertex.label);
    
    while(!parent.equals(sourceVertex)) {
      resultList.add(parent.label);
      parent = parentVerticesMap.get(parent);
      if(parent == null) {
        return null;
      }
    }
    
    resultList.add(parent.label);
    return resultList;
  }
  
  public Integer getShortestDistanceTo(String label) {
    Vertex<String> vertex = graph.getVertex(label);
    if(vertex != null) {
      return distancesMap.get(vertex);
    } else {
      return Integer.MAX_VALUE;
    }
  }
}
