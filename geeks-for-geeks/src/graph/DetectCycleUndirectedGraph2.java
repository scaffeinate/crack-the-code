package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class DetectCycleUndirectedGraph2 {
    private AbstractGraph<String> graph = null;

    public DetectCycleUndirectedGraph2() {
        graph = new UndirectedGraph<String>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public boolean detectCycle() {
        Set<Vertex<String>> visited = new HashSet<Vertex<String>>();
        Set<Vertex<String>> vertices = graph.verticesSet();

        for (Vertex<String> vertex : vertices) {
            if (!visited.contains(vertex)) {
                boolean containsCycle = detectCycle(vertex, visited, vertex);
                if (containsCycle) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycle(Vertex<String> vertex, Set<Vertex<String>> visited, Vertex<String> source) {
        if (vertex == null) {
            return false;
        }

        visited.add(vertex);

        List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
        for (Vertex<String> neighbour : neighbours) {
            graph.removeEdge(vertex, source);
            if (!neighbour.equals(source)) {
                if (visited.contains(neighbour)) {
                    return true;
                } else {
                    if (detectCycle(neighbour, visited, vertex)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
