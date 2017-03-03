/**
 * 
 */
package algorithms.problems;

import java.util.HashMap;
import java.util.Map;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSets {

  private Map<Integer, Node> nodesMap = null;

  public DisjointSets() {
    nodesMap = new HashMap<Integer, Node>();
  }

  public void constructDisjointSet(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "make":
        int val = Integer.parseInt(values[1]);
        Node node = new Node(val);
        nodesMap.put(val, node);
        break;
      case "union":
        int node1 = Integer.parseInt(values[1]);
        int node2 = Integer.parseInt(values[2]);
        if(nodesMap.containsKey(node1) && nodesMap.containsKey(node2)) {
          union(nodesMap.get(node1), nodesMap.get(node2));
        }
        break;
      case "find":
        node = nodesMap.get(Integer.parseInt(values[1]));
        System.out.println(find(node).data);
        break;
      }
    }
  }
  
  private void union(Node node1, Node node2) {
    Node parent1 = parent(node1);
    Node parent2 = parent(node2);
    
    if(parent1.rank == parent2.rank) {
      parent2.parent = parent1;
      parent1.rank++;
    } else {
      Node greater = (parent1.rank > parent2.rank) ? parent1 : parent2;
      Node smaller = (parent1.rank > parent2.rank) ? parent2 : parent1;
      
      smaller.parent = greater;
    }
  }
  
  private Node find(Node node) {
    Node parent = parent(node);
    node.parent = parent;
    return parent;
  }
  
  private Node parent(Node node) {
    while(!node.parent.equals(node)) {
      node = node.parent;
    }
    
    return node;
  }

  public static void main(String[] args) {
    String[] input = InputUtil.readContents("input_files/problems/disjoint_sets/test_case_1");
    DisjointSets disjointSets = new DisjointSets();
    disjointSets.constructDisjointSet(input);
  }

  private class Node {
    private int data;
    private int rank = 0;
    private Node parent = this;

    public Node(int data) {
      this.data = data;
    }
  }
}
