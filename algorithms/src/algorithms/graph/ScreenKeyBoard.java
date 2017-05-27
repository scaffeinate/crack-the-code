package algorithms.graph;

import datastructures.graph.AbstractGraph;
import datastructures.graph.UndirectedGraph;
import datastructures.util.GraphUtil;

/**
 * Write a program to select a text using screen keyboard with minimal traversal.
 * <p>
 * We have five buttons in remote: UP, DOWN, LEFT, RIGHT, OK
 * <p>
 * Keyboard: Input remote could be like this (as it buttons could be in any order)
 * A B C D E
 * F G H I J
 * K L M N O
 * P Q R S T
 * U V W X Y
 * Z
 * <p>
 * Example: BHE
 */
public class ScreenKeyBoard {
  private AbstractGraph<String> graph = null;

  public ScreenKeyBoard() {
    graph = new UndirectedGraph<String>();
  }

  public void constructGraph(String[] input) {
    GraphUtil.constructGraph(graph, input);
  }
}
