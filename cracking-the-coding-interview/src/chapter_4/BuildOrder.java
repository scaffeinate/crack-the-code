/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructures.graph.AbstractGraph;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Vertex;
import util.InputUtil;

/**
 * Question 4.7
 * 
 * @author Sudharsanan Muralidharan
 */
public class BuildOrder {
  AbstractGraph<Character> graph = null;
  AbstractGraph<Character> graph2 = null;

  public BuildOrder() {
    graph = new DirectedGraph<Character>();
    graph2 = new DirectedGraph<Character>();
  }

  private void constructGraph(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "vertex":
        char c = values[1].charAt(0);
        graph.createVertex(c);
        graph2.createVertex(c);
        break;
      case "edge":
        char source = values[1].charAt(0);
        char dest = values[2].charAt(0);
        addEdge(graph, source, dest);
        addEdge(graph2, dest, source);
        break;
      case "print":
        graph.print();
        break;
      }
    }
  }

  private void addEdge(AbstractGraph<Character> graph, char source, char dest) {
    Vertex<Character> sourceVertex = graph.getVertex(source);
    Vertex<Character> destVertex = graph.getVertex(dest);
    if (sourceVertex != null && destVertex != null) {
      graph.addEdge(sourceVertex, destVertex);
    }
  }

  private String fetchBuildOrder() {
    Set<Vertex<Character>> visitedSet = new HashSet<Vertex<Character>>();
    StringBuilder builder = new StringBuilder();
    Set<Vertex<Character>> projects = graph.verticesSet();
    Iterator<Vertex<Character>> iterator = projects.iterator();

    while (iterator.hasNext()) {
      Vertex<Character> project = iterator.next();
      if (project.outgoingEdges.size() == 0) {
        visitedSet.add(project);
        builder.append(project.label).append(" ");
        iterator.remove();
      }
    }

    for (Vertex<Character> project : projects) {
      if (!visitedSet.contains(project)) {
        depthFirstTraversal(project, builder, visitedSet);
      }
    }

    return builder.toString();
  }

  private String fetchBuildOrder2() {
    StringBuilder builder = new StringBuilder();
    Set<Vertex<Character>> projects = graph2.verticesSet();
    Set<Vertex<Character>> visitedSet = new HashSet<Vertex<Character>>();
    Stack<Vertex<Character>> stack = new Stack<Vertex<Character>>();

    for (Vertex<Character> project : projects) {
      depthFirstTraversal(project, stack, visitedSet);
    }

    while (!stack.isEmpty()) {
      builder.append(stack.pop().label).append(" ");
    }

    return builder.toString();
  }

  private void depthFirstTraversal(Vertex<Character> sourceVertex, StringBuilder builder,
      Set<Vertex<Character>> visitedSet) {
    if (sourceVertex == null) {
      return;
    }

    List<Vertex<Character>> neighbours = graph.neighboursOf(sourceVertex);
    for (Vertex<Character> vertex : neighbours) {
      if (!visitedSet.contains(vertex)) {
        depthFirstTraversal(vertex, builder, visitedSet);
      }
    }

    visitedSet.add(sourceVertex);
    builder.append(sourceVertex.label).append(" ");
  }

  private void depthFirstTraversal(Vertex<Character> sourceVertex, Stack<Vertex<Character>> stack,
      Set<Vertex<Character>> visitedSet) {

    if (sourceVertex == null) {
      return;
    }

    List<Vertex<Character>> neighbours = graph2.neighboursOf(sourceVertex);
    for (Vertex<Character> neighbour : neighbours) {
      if (!visitedSet.contains(neighbour)) {
        depthFirstTraversal(neighbour, stack, visitedSet);
      }
    }

    if (!visitedSet.contains(sourceVertex)) {
      visitedSet.add(sourceVertex);
      stack.add(sourceVertex);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "build_order");
    BuildOrder buildOrder = new BuildOrder();
    buildOrder.constructGraph(input);
    System.out.println();
    System.out.println("Using A->B (denoting A is dependent on B): \n" + buildOrder.fetchBuildOrder());
    System.out.println();
    System.out.println("Using A->B (denoting A should be built before B) \n" + buildOrder.fetchBuildOrder2());
  }
}
