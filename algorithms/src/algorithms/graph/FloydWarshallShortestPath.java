package algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.graph.AbstractGraph;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Edge;
import datastructures.graph.Vertex;
import datastructures.util.GraphUtil;

public class FloydWarshallShortestPath {
    private AbstractGraph<String> graph = null;
    private Integer[][] distancesMatrix = null;
    private Vertex<String>[][] pathMatrix = null;
    private Map<Vertex<String>, Integer> indexesMap = null;
    private int numVertices = 0;

    public FloydWarshallShortestPath() {
        graph = new DirectedGraph<String>();
        indexesMap = new HashMap<Vertex<String>, Integer>();
    }

    @SuppressWarnings("unchecked")
    public void constructGraph(String[] input) {
        GraphUtil.constructGraph(graph, input);

        numVertices = graph.numVertices();
        Set<Vertex<String>> vertices = graph.verticesSet();
        Set<Edge<String>> edges = graph.edgesSet();
        distancesMatrix = new Integer[numVertices][numVertices];
        pathMatrix = new Vertex[numVertices][numVertices];
        int index = 0;

        for (Vertex<String> vertex : vertices) {
            indexesMap.put(vertex, index++);
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    distancesMatrix[i][j] = 0;
                } else {
                    distancesMatrix[i][j] = Integer.MAX_VALUE;
                }
                pathMatrix[i][j] = null;
            }
        }

        for (Edge<String> edge : edges) {
            int i = indexesMap.get(edge.sourceVertex);
            int j = indexesMap.get(edge.destVertex);

            distancesMatrix[i][j] = edge.weight;
            pathMatrix[i][j] = edge.sourceVertex;
        }
    }

    public void computeShortestPath() {
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    int distanceIJ = distancesMatrix[i][j];
                    int distanceIK = distancesMatrix[i][k];
                    int distanceKJ = distancesMatrix[k][j];

                    int distancesSum = (distanceIK == Integer.MAX_VALUE || distanceKJ == Integer.MAX_VALUE) ? Integer.MAX_VALUE
                            : (distanceIK + distanceKJ);

                    if (distanceIJ > distancesSum) {
                        distancesMatrix[i][j] = distancesSum;
                        pathMatrix[i][j] = pathMatrix[k][j];
                    }
                }
            }
        }
    }

    public Integer getShortestDistanceTo(String sourceLabel, String destLabel) {
        Vertex<String> sourceVertex = graph.getVertex(sourceLabel);
        Vertex<String> destVertex = graph.getVertex(destLabel);

        if (sourceVertex == null || destVertex == null) {
            return Integer.MAX_VALUE;
        }

        if (containsNegativeWeightCycle()) {
            return Integer.MIN_VALUE;
        }

        int i = indexesMap.get(sourceVertex);
        int j = indexesMap.get(destVertex);

        return distancesMatrix[i][j];
    }

    public List<String> getShortestPathTo(String sourceLabel, String destLabel) {
        List<String> shortestPath = new ArrayList<String>();
        if (containsNegativeWeightCycle()) {
            return Arrays.asList(new String[]{"negative_cycle"});
        }
        Vertex<String> sourceVertex = graph.getVertex(sourceLabel);
        Vertex<String> destVertex = graph.getVertex(destLabel);

        if (sourceVertex != null && destVertex != null) {
            getShortestPathTo(sourceVertex, destVertex, shortestPath);
        }

        return shortestPath;
    }

    private void getShortestPathTo(Vertex<String> sourceVertex, Vertex<String> destVertex, List<String> shortestPath) {
        if (destVertex == null) {
            shortestPath.clear();
        } else if (destVertex.equals(sourceVertex)) {
            shortestPath.add(sourceVertex.label);
        } else {
            int i = indexesMap.get(sourceVertex);
            int j = indexesMap.get(destVertex);
            shortestPath.add(destVertex.label);
            getShortestPathTo(sourceVertex, pathMatrix[i][j], shortestPath);
        }
    }

    private boolean containsNegativeWeightCycle() {
        int i = 0, j = 0;
        while (i < numVertices && j < numVertices) {
            if (distancesMatrix[i][j] < 0) {
                return true;
            }
            i++;
            j++;
        }

        return false;
    }
}