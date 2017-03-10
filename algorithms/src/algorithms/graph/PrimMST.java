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

public class PrimMST {
  private AbstractGraph<String> graph = null;
  private PriorityQueue<Integer, Vertex<String>> priorityQueue = null;
  private Map<Vertex<String>, Edge<String>> edgesMap = null;

  public PrimMST() {
    graph = new UndirectedGraph<String>();
    edgesMap = new HashMap<Vertex<String>, Edge<String>>();
    priorityQueue = new PriorityQueue<Integer, Vertex<String>>(HeapType.MIN_HEAP);
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

  public List<Edge<String>> minimumSpanningTree() {
    List<Edge<String>> resultList = new ArrayList<Edge<String>>();
    Set<Vertex<String>> vertices = graph.verticesSet();
    int i = 0;

    for (Vertex<String> vertex : vertices) {
      priorityQueue.insert(Integer.MAX_VALUE, vertex);
    }

    while (!priorityQueue.isEmpty()) {
      if (i == 0) {
        priorityQueue.decreaseKey(priorityQueue.peek().getValue(), 0);
        i++;
        continue;
      }

      Vertex<String> minVertex = priorityQueue.extract().getValue();
      if (edgesMap.containsKey(minVertex)) {
        resultList.add(edgesMap.get(minVertex));
      }

      List<Edge<String>> outgoingEdges = minVertex.outgoingEdges;
      for (Edge<String> edge : outgoingEdges) {
        if (priorityQueue.decreaseKey(edge.destVertex, edge.weight)) {
          edgesMap.put(edge.destVertex, edge);
        }
      }
    }

    return resultList;
  }
}
