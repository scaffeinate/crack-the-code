/**
 *
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.graph.DirectedGraph;
import datastructures.graph.GenericGraph;
import datastructures.graph.Vertex;
import util.InputUtil;

/**
 * Question 4.1: Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 *
 * @author Sudharsanan Muralidharan
 */
public class RouteBetweenNodes {
    GenericGraph<Integer> graph = null;

    public RouteBetweenNodes() {
        graph = new DirectedGraph<Integer>();
    }

    private void addVertex(Integer data) {
        graph.createVertex(data);
    }

    private void addEdge(Integer source, Integer dest) {
        Vertex<Integer> sourceVertex = graph.getVertex(source);
        Vertex<Integer> destVertex = graph.getVertex(dest);
        graph.addEdge(sourceVertex, destVertex);
    }

    private boolean routeBetween(Integer root, Integer result) {
        Vertex<Integer> rootVertex = graph.getVertex(root);
        Vertex<Integer> resultVertex = graph.getVertex(result);
        if (rootVertex == null || resultVertex == null) {
            return false;
        }

        return graph.breadthFirstSearch(rootVertex, resultVertex);
    }

    private void print() {
        graph.print();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(4, "route_between_nodes");
        RouteBetweenNodes route = new RouteBetweenNodes();

        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];
            switch (action) {
                case "vertex":
                    System.out.println("Adding vertex " + values[1]);
                    route.addVertex(Integer.parseInt(values[1]));
                    break;
                case "edge":
                    System.out.println("Adding edge between " + values[1] + " and " + values[2]);
                    route.addEdge(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                    break;
                case "print":
                    route.print();
                    break;
                case "route":
                    boolean routeExisits = route.routeBetween(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                    System.out.println("Route Exists between " + values[1] + " and " + values[2] + " => " + routeExisits);
                    break;
            }
        }
    }
}
