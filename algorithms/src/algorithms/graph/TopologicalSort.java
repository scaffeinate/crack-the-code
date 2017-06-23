package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructures.graph.AbstractGraph;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class TopologicalSort {
    private AbstractGraph<String> graph = null;

    public TopologicalSort() {
        graph = new DirectedGraph<String>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public List<String> topologicalSort() {
        Set<Vertex<String>> vertices = graph.verticesSet();
        Set<Vertex<String>> visited = new HashSet<Vertex<String>>();
        Stack<Vertex<String>> stack = new Stack<Vertex<String>>();

        for (Vertex<String> vertex : vertices) {
            if (!visited.contains(vertex)) {
                doDfs(vertex, visited, stack);
            }
        }

        List<String> resultList = new ArrayList<String>();
        while (!stack.isEmpty()) {
            resultList.add(stack.pop().label);
        }

        return resultList;
    }

    private void doDfs(Vertex<String> vertex, Set<Vertex<String>> visited, Stack<Vertex<String>> stack) {
        if (vertex == null) {
            return;
        }

        List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
        for (Vertex<String> neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                doDfs(neighbour, visited, stack);
            }
        }

        visited.add(vertex);
        stack.push(vertex);
    }
}
