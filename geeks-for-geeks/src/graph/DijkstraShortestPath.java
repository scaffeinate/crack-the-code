package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.Edge;
import datastructures.graph.UndirectedGraph;
import datastructures.graph.Vertex;
import datastructures.heap.HeapType;
import datastructures.heap.PriorityQueue;
import datastructures.util.GraphUtil;

public class DijkstraShortestPath {
    private AbstractGraph<String> graph = null;
    private PriorityQueue<Integer, Vertex<String>> priorityQueue = null;
    private Map<Vertex<String>, Vertex<String>> parentVerticesMap = null;
    private Map<Vertex<String>, Integer> distancesMap = null;
    private Vertex<String> sourceVertex = null;

    public DijkstraShortestPath() {
        graph = new UndirectedGraph<String>();
        priorityQueue = new PriorityQueue<Integer, Vertex<String>>(HeapType.MIN_HEAP);
        parentVerticesMap = new HashMap<Vertex<String>, Vertex<String>>();
        distancesMap = new HashMap<Vertex<String>, Integer>();
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public void computeShortestPath(String sourceLabel) {
        Vertex<String> sourceVertex = graph.getVertex(sourceLabel);
        if (sourceVertex == null) {
            return;
        }

        this.sourceVertex = sourceVertex;
        Set<Vertex<String>> vertices = graph.verticesSet();
        int defaultDistance = Integer.MAX_VALUE;
        for (Vertex<String> vertex : vertices) {
            if (vertex.equals(sourceVertex)) {
                priorityQueue.insert(0, vertex);
                distancesMap.put(vertex, 0);
            } else {
                priorityQueue.insert(defaultDistance, vertex);
                distancesMap.put(vertex, defaultDistance);
            }
            parentVerticesMap.put(vertex, null);
        }

        while (!priorityQueue.isEmpty()) {
            Vertex<String> vertex = priorityQueue.extractValue();

            List<Edge<String>> outgoingEdges = vertex.outgoingEdges;
            for (Edge<String> edge : outgoingEdges) {
                Vertex<String> neighbor = edge.destVertex;
                int distance = (distancesMap.get(vertex) == Integer.MAX_VALUE) ? Integer.MAX_VALUE
                        : distancesMap.get(vertex) + edge.weight;
                if (priorityQueue.contains(neighbor) && priorityQueue.decreaseKey(neighbor, distance)) {
                    parentVerticesMap.put(neighbor, vertex);
                    distancesMap.put(neighbor, distance);
                }
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
}
