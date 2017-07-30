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

public class PrimMST {
    private AbstractGraph<String> graph = null;
    private PriorityQueue<Integer, Vertex<String>> priorityQueue = null;
    private Map<Vertex<String>, Edge<String>> parentEdgesMap = null;

    public PrimMST() {
        graph = new UndirectedGraph<String>();
        parentEdgesMap = new HashMap<Vertex<String>, Edge<String>>();
        priorityQueue = new PriorityQueue<Integer, Vertex<String>>(HeapType.MIN_HEAP);
    }

    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);
    }

    public List<Edge<String>> minimumSpanningTree() {
        List<Edge<String>> resultList = new ArrayList<Edge<String>>();
        Set<Vertex<String>> vertices = graph.verticesSet();
        int i = 0;

        for (Vertex<String> vertex : vertices) {
            if (i == 0) {
                priorityQueue.insert(0, vertex);
                i++;
            } else {
                priorityQueue.insert(Integer.MAX_VALUE, vertex);
            }
        }

        while (!priorityQueue.isEmpty()) {
            Vertex<String> minVertex = priorityQueue.extract().getValue();
            if (parentEdgesMap.containsKey(minVertex)) {
                resultList.add(parentEdgesMap.get(minVertex));
            }

            List<Edge<String>> outgoingEdges = minVertex.outgoingEdges;
            for (Edge<String> edge : outgoingEdges) {
                if (priorityQueue.contains(edge.destVertex) && priorityQueue.decreaseKey(edge.destVertex, edge.weight)) {
                    parentEdgesMap.put(edge.destVertex, edge);
                }
            }
        }

        return resultList;
    }
}
