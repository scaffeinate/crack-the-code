/**
 * 
 */
package binarytree;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst
 * 
 * @author Sudharsanan Muralidharan
 */
public class LargestBST {

  private BinaryTree<Integer> tree = null;
  private TreeNode<Integer> root = null;
  private Map<Integer, TreeNode<Integer>> nodesMap = null;

  public LargestBST() {
    tree = new BinaryTree<Integer>();
    nodesMap = new HashMap<Integer, TreeNode<Integer>>();
  }

  public void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "insertRoot":
        Integer val = Integer.parseInt(values[1]);
        root = tree.insertRoot(val);
        nodesMap.put(val, root);
        break;
      case "insertLeft":
        insertNode(values[1], values[2], true);
        break;
      case "insertRight":
        insertNode(values[1], values[2], false);
        break;
      }
    }
  }

  private void insertNode(String parentStr, String nodeStr, boolean isLeft) {
    Integer parentVal = Integer.parseInt(parentStr);
    Integer nodeVal = Integer.parseInt(nodeStr);
    TreeNode<Integer> parent = nodesMap.get(parentVal);
    TreeNode<Integer> node = new TreeNode<Integer>(nodeVal);
    if (parent == null) {
      return;
    }
    tree.insert(parent, node, isLeft);
    nodesMap.put(nodeVal, node);
  }

  public int findLargestBST() {
    return largestBST(root).size;
  }

  private Wrapper largestBST(TreeNode<Integer> root) {
    if (root == null) {
      return new Wrapper(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
    }

    Wrapper leftWrapper = largestBST(root.left);
    Wrapper rightWrapper = largestBST(root.right);

    boolean leftBST = root.data >= leftWrapper.max;
    boolean rightBST = root.data < rightWrapper.min;

    boolean isBST = (leftWrapper.isBST && rightWrapper.isBST && leftBST && rightBST);
    int largest = 0;

    if (isBST) {
      largest = leftWrapper.size + rightWrapper.size + 1;
    } else {
      largest = Math.max(leftWrapper.size, rightWrapper.size);
    }

    return new Wrapper(minOf(root.data, leftWrapper.min, rightWrapper.min),
        maxOf(root.data, leftWrapper.max, rightWrapper.max), largest, isBST);
  }

  private int minOf(int... a) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; i++) {
      min = Math.min(a[i], min);
    }
    return min;
  }

  private int maxOf(int... a) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      max = Math.max(a[i], max);
    }
    return max;
  }

  private class Wrapper {
    int min;
    int max;
    int size;
    boolean isBST;

    public Wrapper(int min, int max, int size, boolean isBST) {
      this.min = min;
      this.max = max;
      this.size = size;
      this.isBST = isBST;
    }
  }
}
