package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class DetectCycleDirectedGraph {
    private AbstractGraph<String> graph = null;
    private Set<Vertex<String>> vertices = null;
    private Set<Vertex<String>> whiteSet = null;
    private Set<Vertex<String>> greySet = null;
    private Set<Vertex<String>> blackSet = null;

    public DetectCycleDirectedGraph() {
        graph = new DirectedGraph<String>();
        whiteSet = new HashSet<Vertex<String>>();
        greySet = new HashSet<Vertex<String>>();
        blackSet = new HashSet<Vertex<String>>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
        vertices = graph.verticesSet();
    }

    public boolean detectCycle() {
        whiteSet.addAll(vertices);

        for (Vertex<String> vertex : vertices) {
            if (whiteSet.contains(vertex)) {
                if (detectCycleDFS(vertex)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean detectCycleDFS(Vertex<String> vertex) {
        if (vertex == null) {
            return false;
        }

        whiteSet.remove(vertex);
        greySet.add(vertex);

        List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
        for (Vertex<String> neighbour : neighbours) {
            if (whiteSet.contains(neighbour)) {
                if (detectCycleDFS(neighbour)) {
                    return true;
                }
            } else if (greySet.contains(neighbour)) {
                return true;
            }
        }

        greySet.remove(vertex);
        blackSet.add(vertex);

        return false;
    }
}
