/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import chapter_4.tree_graph.BinaryTreeRandom;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class RandomNodeBinaryTree {
  
  private BinaryTreeRandom<Integer> randomTree = null;
  private TreeNode<Integer> root = null;
  private Map<Integer, TreeNode<Integer>> nodesMap = null;
  
  public RandomNodeBinaryTree() {
    randomTree = new BinaryTreeRandom<Integer>();
    nodesMap = new HashMap<Integer, TreeNode<Integer>>();
  }
  
  private void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      
      switch(action) {
      case "insertRoot":
        Integer val = Integer.parseInt(values[1]);
        root = randomTree.insertRoot(val);
        nodesMap.put(val, root);
        break;
      case "insertLeft":
        insertNode(values[1], values[2], true);
        break;
      case "insertRight":
        insertNode(values[1], values[2], false);
      case "find":
        TreeNode<Integer> result = randomTree.find(Integer.parseInt(values[1]));
        System.out.println(result);
        break;
      case "print":
        System.out.println(randomTree.getSubTreeCountMap());
        randomTree.inOrder(root);
        System.out.println();
        break;
      case "delete":
        System.out.println(randomTree.delete(Integer.parseInt(values[1])));
        break;
      case "getRandom":
        System.out.print(randomTree.getRandom() + " ");
        System.out.print(randomTree.getRandom2());
        System.out.println();
        break;
      }
    }
  }
  
  private void insertNode(String parentValStr, String valStr, boolean isLeft) {
    Integer val = Integer.parseInt(valStr);
    Integer parentVal = Integer.parseInt(parentValStr);
    
    TreeNode<Integer> parentNode = nodesMap.get(parentVal);
    if(parentNode != null) {
      TreeNode<Integer> node = randomTree.insert(parentNode, val, isLeft);
      nodesMap.put(val, node);      
    }
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "random_node_binary_tree");
    RandomNodeBinaryTree randomNodeBinaryTree = new RandomNodeBinaryTree();
    randomNodeBinaryTree.constructTree(input);
  }
}
