/**
 * 
 */
package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.graph.DirectedGraph;
import datastructures.graph.GenericGraph;
import datastructures.graph.GraphType;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class TestGraph {

  private void testInput(String fileName) throws FileNotFoundException {
    String[] input = InputUtil.readContents(fileName);
    System.out.println("Test Set: " + fileName);
    System.out.println("-------------------------");
    System.out.println("\n[Testing Directed Graph]\n");
    createGraphAndExecute(input, GraphType.DIRECTED);
    
    System.out.println("\n[Testing UnDirected Graph]\n");
    createGraphAndExecute(input, GraphType.UNDIRECTED);
    
    System.out.println("\n======================================================================================================================\n");
   
  }
  
  private void createGraphAndExecute(String[] input, GraphType graphType) {
    GenericGraph<String> graph = null;
    if(graphType == GraphType.DIRECTED) {
      graph = new DirectedGraph<String>();
    } else {
      graph = new UndirectedGraph<String>();
    }
    
    executeActions(graph, input);
  }

  private void executeActions(GenericGraph<String> graph, String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Vertex<String> sourceVertex, destVertex, resultVertex;
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
      case "print":
        System.out.println("\n[Printing Graph]");
        graph.print();
        break;
      case "search":
        sourceVertex = graph.getVertex(values[1]);
        resultVertex = graph.getVertex(values[2]);
        System.out.println("\nSearching from " + sourceVertex.toString() + " to " + resultVertex.toString());
        System.out.println("DFS: " + graph.depthFirstSearch(sourceVertex, resultVertex));
        System.out.println("Depth First Path: " + graph.depthFirstPath(sourceVertex, resultVertex));
        System.out.println("BFS: " + graph.breadthFirstSearch(sourceVertex, resultVertex));
        System.out.println();
        break;
      case "traverse":
        System.out.println("[Traversing From " + values[1] + "]");
        System.out.println("\nDepth First Traversal: ");
        graph.depthFirstTraversal(graph.getVertex(values[1]));
        System.out.println("\nBreadth First Traversal: ");
        graph.breadthFirstTraversal(graph.getVertex(values[1]));
        System.out.println();
        break;
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    TestGraph testGraph = new TestGraph();
    testGraph.testInput("test_graph");
    testGraph.testInput("test_graph_set_2");
  }
}
