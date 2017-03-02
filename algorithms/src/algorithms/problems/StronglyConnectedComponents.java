/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import algorithms.util.InputUtil;
import datastructures.graph.DirectedGraph;
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
        List<Vertex<String>> component = dfsVisit(graph2, vertex, visited);
        connectedComponents.add(component);
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
        dfsVisit(graph, vertex, visited, stack, new ArrayList<Vertex<String>>());
      }
    }

    return stack;
  }

  private List<Vertex<String>> dfsVisit(DirectedGraph<String> graph, Vertex<String> sourceVertex,
      Set<Vertex<String>> visited) {
    List<Vertex<String>> vertices = new ArrayList<Vertex<String>>();
    dfsVisit(graph, sourceVertex, visited, null, vertices);
    return vertices;
  }

  private void dfsVisit(DirectedGraph<String> graph, Vertex<String> sourceVertex, Set<Vertex<String>> visited,
      Stack<Vertex<String>> stack, List<Vertex<String>> vertices) {
    if (sourceVertex == null)
      return;

    visited.add(sourceVertex);
    vertices.add(sourceVertex);
    List<Vertex<String>> neighbours = graph.neighboursOf(sourceVertex);
    for (Vertex<String> vertex : neighbours) {
      if (!visited.contains(vertex)) {
        dfsVisit(graph, vertex, visited, stack, vertices);
      }
    }

    if (stack != null) {
      stack.push(sourceVertex);
    }
  }

  private DirectedGraph<String> reverseGraph(DirectedGraph<String> graph) {
    Set<Vertex<String>> vertices = graph.verticesSet();
    DirectedGraph<String> graph2 = new DirectedGraph<String>();
    for (Vertex<String> vertex : vertices) {
      graph2.createVertex(vertex.label);
    }

    for (Vertex<String> vertex : vertices) {
      List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
      for (Vertex<String> neighbour : neighbours) {
        graph2.addEdge(graph2.getVertex(neighbour.label), graph2.getVertex(vertex.label));
      }
    }

    return graph2;
  }
}
