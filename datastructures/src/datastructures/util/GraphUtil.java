package datastructures.util;

import datastructures.graph.AbstractGraph;
import datastructures.graph.Vertex;

public class GraphUtil {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void constructGraph(AbstractGraph graph, String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];
            Vertex sourceVertex = null, destVertex = null;
            int weight = 0;
            switch (action) {
                case "vertex":
                    Vertex vertex = graph.createVertex(values[1]);
                    if (vertex != null) {
                        System.out.println("Created Vertex with label: " + values[1]);
                    } else {
                        System.out.println("Vertex creation failed for label: " + values[1]);
                    }
                    break;
                case "edge":
                    sourceVertex = graph.getVertex(values[1]);
                    destVertex = graph.getVertex(values[2]);
                    if (values.length > 3) {
                        weight = Integer.parseInt(values[3]);
                    }
                    if (graph.addEdge(sourceVertex, destVertex, weight)) {
                        System.out.println("Edge created between: " + values[1] + " and " + values[2] + " with weight: " + weight);
                    } else {
                        System.out.println("Either of the vertices doesnt exist");
                    }
                    break;
            }
        }
    }
}
