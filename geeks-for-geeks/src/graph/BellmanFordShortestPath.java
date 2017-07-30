package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class BellmanFordShortestPath {
    private AbstractGraph<String> graph = null;
    private Map<Vertex<String>, Vertex<String>> parentVerticesMap = null;
    private Map<Vertex<String>, Integer> distancesMap = null;
    private Vertex<String> sourceVertex = null;
    private boolean containsNegativeWeightCycle = false;

    public BellmanFordShortestPath() {
        graph = new UndirectedGraph<String>();
        parentVerticesMap = new HashMap<Vertex<String>, Vertex<String>>();
        distancesMap = new HashMap<Vertex<String>, Integer>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public void computeShortestPath(String label) {
        Vertex<String> sourceVertex = graph.getVertex(label);
        if (sourceVertex == null) {
            return;
        }

        this.sourceVertex = sourceVertex;
        containsNegativeWeightCycle = false;
        distancesMap = new HashMap<Vertex<String>, Integer>();
        parentVerticesMap = new HashMap<Vertex<String>, Vertex<String>>();
        distancesMap.put(sourceVertex, 0);

        Set<Edge<String>> edges = graph.edgesSet();
        for (int i = 0; i < graph.numVertices() - 1; i++) {
            relaxAllEdges(edges, false);
        }

        // Detect Negative Weight Cycle
        relaxAllEdges(edges, true);
    }

    public Integer getShortestDistanceTo(String label) {
        if (containsNegativeWeightCycle) {
            return Integer.MIN_VALUE;
        }

        Vertex<String> vertex = graph.getVertex(label);
        if (vertex == null || distancesMap.get(vertex) == null) {
            return Integer.MAX_VALUE;
        } else {
            return distancesMap.get(vertex);
        }
    }

    public List<String> getShortestPathTo(String label) {
        Vertex<String> vertex = graph.getVertex(label);
        if (vertex == null) {
            return new ArrayList<String>();
        }

        if (containsNegativeWeightCycle) {
            return Arrays.asList(new String[]{"negative_cycle"});
        }

        List<String> minimumPath = new ArrayList<String>();
        getShortestPath(vertex, this.sourceVertex, minimumPath);

        return minimumPath;
    }

    private void getShortestPath(Vertex<String> vertex, Vertex<String> sourceVertex, List<String> minimumPath) {
        if (vertex == null) {
            minimumPath.clear();
        } else if (vertex.equals(sourceVertex)) {
            minimumPath.add(sourceVertex.label);
        } else {
            minimumPath.add(vertex.label);
            getShortestPath(parentVerticesMap.get(vertex), sourceVertex, minimumPath);
        }
    }

    private void relaxAllEdges(Set<Edge<String>> edges, boolean detectNegativeCycle) {
        for (Edge<String> edge : edges) {
            relaxEdge(edge, detectNegativeCycle);
        }
    }

    private void relaxEdge(Edge<String> edge, boolean detectNegativeCycle) {
        Vertex<String> sourceVertex = edge.sourceVertex;
        Vertex<String> destVertex = edge.destVertex;
        int sourceDistance = distancesMap.getOrDefault(sourceVertex, Integer.MAX_VALUE);
        int destDistance = distancesMap.getOrDefault(destVertex, Integer.MAX_VALUE);
        int distance = (sourceDistance == Integer.MAX_VALUE) ? Integer.MAX_VALUE : (sourceDistance + edge.weight);
        if (destDistance > distance) {
            if (detectNegativeCycle) {
                containsNegativeWeightCycle = true;
            }
            distancesMap.put(destVertex, distance);
            parentVerticesMap.put(destVertex, sourceVertex);
        }
    }
}
