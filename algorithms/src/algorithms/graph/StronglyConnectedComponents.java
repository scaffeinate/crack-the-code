/**
 * 
 */
package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructures.graph.DirectedGraph;
import datastructures.graph.Edge;
import datastructures.graph.Vertex;

/**
 * Problem: http://www.geeksforgeeks.org/strongly-connected-components/
 * Problem Explanation: https://www.youtube.com/watch?v=RpgcYiky7uw
 * 
 * @author Sudharsanan Muralidharan
 */
public class StronglyConnectedComponents {

  public StronglyConnectedComponents() {}

  public DirectedGraph<String> constructGraph(String[] input) {
    DirectedGraph<String> graph = new DirectedGraph<String>();
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Vertex<String> sourceVertex = null, destVertex = null;
      switch (action) {
      case "vertex":
        if (graph.createVertex(values[1]) != null) {
          System.out.println("Created Vertex with label: " + values[1]);
        } else {
          System.out.println("Vertex creation failed for label: " + values[1]);
        }
        break;
      case "edge":
        sourceVertex = graph.getVertex(values[1]);
        destVertex = graph.getVertex(values[2]);
        if (graph.addEdge(sourceVertex, destVertex)) {
          System.out.println("Edge created between: " + values[1] + " and " + values[2]);
        } else {
          System.out.println("Either of the vertices dont exist");
        }
        break;
      }
    }

    return graph;
  }

  public List<List<Vertex<String>>> getConnectedComponents(DirectedGraph<String> graph) {
    List<List<Vertex<String>>> connectedComponents = new ArrayList<List<Vertex<String>>>();
    Stack<Vertex<String>> stack = doDfs(graph);
    DirectedGraph<String> graph2 = reverseGraph(graph);
    Set<Vertex<String>> visited = new HashSet<Vertex<String>>();
    while (!stack.isEmpty()) {
      Vertex<String> top = stack.pop();
      Vertex<String> vertex = graph2.getVertex(top.label);
      if (!visited.contains(vertex)) {
        connectedComponents.add(dfsVisit(graph2, vertex, visited));
      }
    }

    return connectedComponents;
  }

  private Stack<Vertex<String>> doDfs(DirectedGraph<String> graph) {
    Set<Vertex<String>> vertices = graph.verticesSet();
    Stack<Vertex<String>> stack = new Stack<Vertex<String>>();
    Set<Vertex<String>> visited = new HashSet<Vertex<String>>();
    for (Vertex<String> vertex : vertices) {
      if (!visited.contains(vertex)) {
        dfsVisit(graph, vertex, visited, stack);
      }
    }

    return stack;
  }

  private List<Vertex<String>> dfsVisit(DirectedGraph<String> graph, Vertex<String> sourceVertex,
      Set<Vertex<String>> visited) {
    Stack<Vertex<String>> stack = new Stack<Vertex<String>>();
    dfsVisit(graph, sourceVertex, visited, stack);
    return stack;
  }

  private void dfsVisit(DirectedGraph<String> graph, Vertex<String> sourceVertex, Set<Vertex<String>> visited,
      Stack<Vertex<String>> stack) {
    if (sourceVertex == null)
      return;

    visited.add(sourceVertex);
    List<Vertex<String>> neighbours = graph.neighboursOf(sourceVertex);
    for (Vertex<String> vertex : neighbours) {
      if (!visited.contains(vertex)) {
        dfsVisit(graph, vertex, visited, stack);
      }
    }
    
    stack.push(sourceVertex);
  }

  private DirectedGraph<String> reverseGraph(DirectedGraph<String> graph) {
    Set<Vertex<String>> vertices = graph.verticesSet();
    Set<Edge<String>> edges = graph.edgesSet();
    DirectedGraph<String> graph2 = new DirectedGraph<String>();
    for (Vertex<String> vertex : vertices) {
      graph2.createVertex(vertex.label);
    }

    for (Edge<String> edge : edges) {
      graph2.addEdge(graph2.getVertex(edge.destVertex.label), graph2.getVertex(edge.sourceVertex.label));
    }

    return graph2;
  }
}
