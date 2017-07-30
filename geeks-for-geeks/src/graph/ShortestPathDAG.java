package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import datastructures.graph.AbstractGraph;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Edge;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class ShortestPathDAG {
    private AbstractGraph<String> graph = null;
    private Map<Vertex<String>, Integer> distancesMap = null;
    private Map<Vertex<String>, Vertex<String>> parentVerticesMap = null;
    private Vertex<String> sourceVertex = null;

    public ShortestPathDAG() {
        graph = new DirectedGraph<String>();
        distancesMap = new HashMap<Vertex<String>, Integer>();
        parentVerticesMap = new HashMap<Vertex<String>, Vertex<String>>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public void computeShortestPath(String label) {
        Vertex<String> sourceVertex = graph.getVertex(label);
        this.sourceVertex = sourceVertex;
        if (sourceVertex == null) {
            return;
        }

        Set<Vertex<String>> vertices = graph.verticesSet();
        for (Vertex<String> vertex : vertices) {
            if (vertex.equals(sourceVertex)) {
                distancesMap.put(vertex, 0);
            } else {
                distancesMap.put(vertex, Integer.MAX_VALUE);
            }
        }

        Set<Vertex<String>> visited = new HashSet<Vertex<String>>();
        Stack<Vertex<String>> stack = new Stack<Vertex<String>>();

        doDFS(sourceVertex, visited, stack);

        while (!stack.isEmpty()) {
            Vertex<String> vertex = stack.pop();
            List<Edge<String>> outgoingEdges = vertex.outgoingEdges;
            for (Edge<String> edge : outgoingEdges) {
                relaxEdge(edge);
            }
        }
    }

    public List<String> getShortestPathTo(String label) {
        Vertex<String> vertex = graph.getVertex(label);
        if (vertex == null) {
            return new ArrayList<String>();
        }

        List<String> resultList = new ArrayList<String>();
        getShortestPath(vertex, sourceVertex, resultList);
        return resultList;
    }

    private void getShortestPath(Vertex<String> vertex, Vertex<String> sourceVertex, List<String> shortestPathList) {
        if (vertex == null) {
            shortestPathList.clear();
        } else if (vertex.equals(sourceVertex)) {
            shortestPathList.add(vertex.label);
        } else {
            shortestPathList.add(vertex.label);
            getShortestPath(parentVerticesMap.get(vertex), sourceVertex, shortestPathList);
        }
    }

    public Integer getShortestDistanceTo(String label) {
        Vertex<String> vertex = graph.getVertex(label);
        if (vertex != null) {
            return distancesMap.get(vertex);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private void doDFS(Vertex<String> vertex, Set<Vertex<String>> visited, Stack<Vertex<String>> stack) {
        if (vertex == null) {
            return;
        }

        List<Vertex<String>> neighbours = graph.neighboursOf(vertex);
        for (Vertex<String> neighbour : neighbours) {
            if (!visited.contains(neighbour)) {
                doDFS(neighbour, visited, stack);
            }
        }

        visited.add(vertex);
        stack.push(vertex);
    }

    private void relaxEdge(Edge<String> edge) {
        int destDistance = distancesMap.get(edge.destVertex);
        int sourceDistance = distancesMap.get(edge.sourceVertex);

        if (destDistance > sourceDistance + edge.weight) {
            distancesMap.put(edge.destVertex, (sourceDistance + edge.weight));
            parentVerticesMap.put(edge.destVertex, edge.sourceVertex);
        }
    }
}
