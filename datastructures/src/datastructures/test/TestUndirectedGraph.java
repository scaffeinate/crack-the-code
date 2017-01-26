package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.graph.GenericGraph;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.InputUtil;

public class TestUndirectedGraph {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_undirected_graph");
    GenericGraph<String> graph = new UndirectedGraph<String>();
    
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "vertex":
        if(graph.createVertex(values[1]) != null) {
          System.out.println("Created Vertex with label: " + values[1]);
        } else {
          System.out.println("Vertex creation failed for label: " + values[1]);
        }
        break;
      case "edge":
        Vertex<String> sourceVertex = graph.getVertex(values[1]);
        Vertex<String> destVertex = graph.getVertex(values[2]);
        if(graph.addEdge(sourceVertex, destVertex)) {
          System.out.println("Edge created between: " + values[1] + " and " + values[2]);
        } else {
          System.out.println("Either of the vertices dont exist");
        }
        break;
      case "print":
        System.out.println("Graph: ");
        graph.print();
        break;
      }
    }
  }
}
