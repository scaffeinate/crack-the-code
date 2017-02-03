/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  List<Vertex<Character>> projects = new ArrayList<Vertex<Character>>();

  public BuildOrder() {
    graph = new DirectedGraph<Character>();
  }

  private void constructGraph(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "vertex":
        char c = values[1].charAt(0);
        projects.add(graph.createVertex(c));
        break;
      case "edge":
        Vertex<Character> sourceVertex = graph.getVertex(values[1].charAt(0));
        Vertex<Character> destVertex = graph.getVertex(values[2].charAt(0));
        if (sourceVertex != null && destVertex != null) {
          graph.addEdge(sourceVertex, destVertex);
        }
        break;
      case "print":
        graph.print();
        break;
      }
    }
  }

  private String fetchBuildOrder() {
    Collections.sort(projects, new Comparator<Vertex<Character>>() {
      @Override
      public int compare(Vertex<Character> o1, Vertex<Character> o2) {
        return Integer.valueOf(o1.outgoingEdges.size()).compareTo(Integer.valueOf(o2.outgoingEdges.size()));
      }
    });
    
    Set<Vertex<Character>> visitedSet = new HashSet<Vertex<Character>>();
    StringBuilder builder = new StringBuilder();
    for(Vertex<Character> project:projects) {
      if(project.outgoingEdges.size() == 0) {
        visitedSet.add(project);
        builder.append(project.label).append(" ");
      } else {
        if(!visitedSet.contains(project)) {
          depthFirstTraversal(project, builder, visitedSet);
        }
      }
    }
    
    return builder.toString();
  }
  
  private void depthFirstTraversal(Vertex<Character> sourceVertex, StringBuilder builder, Set<Vertex<Character>> visitedSet) {
    if(sourceVertex == null) {
      return;
    }
    
    visitedSet.add(sourceVertex);
    
    List<Vertex<Character>> neighbours = graph.neighboursOf(sourceVertex);
    for(Vertex<Character> vertex : neighbours) {
      if(!visitedSet.contains(vertex)) {
        depthFirstTraversal(vertex, builder, visitedSet);
      }
    }
    
    builder.append(sourceVertex.label).append(" ");
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "build_order");
    BuildOrder buildOrder = new BuildOrder();
    buildOrder.constructGraph(input);
    System.out.println(buildOrder.fetchBuildOrder());
  }
  
  class Project {
    char label;
    int numDependencies = 0;
    
    public Project(char label, int numDependencies) {
      this.label = label;
      this.numDependencies = numDependencies;
    }
  }
}
