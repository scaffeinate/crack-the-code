/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.tree.TreeNode;
import tree_graph.BSTRandom;
import util.InputUtil;

/**
 * Question 4.11:
 * 
 * @author Sudharsanan Muralidharan
 */
public class RandomNode {

  private BSTRandom<Integer> randomTree = null;
  private TreeNode<Integer> root = null;
  
  public RandomNode() {
    randomTree = new BSTRandom<Integer>();
  }
  
  private void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      
      switch(action) {
      case "insertRoot":
        root = randomTree.insertRoot(Integer.parseInt(values[1]));
        break;
      case "insert":
        randomTree.insert(root, Integer.parseInt(values[1]));
        break;
      case "print":
        randomTree.inOrder(root);
        System.out.println();
        System.out.println(randomTree.getTreeCount());
        break;
      case "delete":
        System.out.println(randomTree.delete(root, Integer.parseInt(values[1])));
        break;
      case "getRandom":
        System.out.print(randomTree.getRandom(root) + " ");
        break;
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "random_node");
    RandomNode randomNode = new RandomNode();
    randomNode.constructTree(input);
  }
}
