package algorithms.graph;

import java.util.HashMap;
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

  public Integer getShortestDistanceTo(String vertex1Label, String vertex2Label) {
    Vertex<String> vertex1 = graph.getVertex(vertex1Label);
    Vertex<String> vertex2 = graph.getVertex(vertex2Label);

    if (vertex1 == null || vertex2 == null) {
      return Integer.MAX_VALUE;
    }

    int i = indexesMap.get(vertex1);
    int j = indexesMap.get(vertex2);

    return distancesMatrix[i][j];
  }
}