package binarytree;

import java.util.HashMap;
import java.util.Map;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class MaxDifferenceNodeAncestor {
  private BinaryTree<Integer> tree = null;
  private Map<Integer, TreeNode<Integer>> nodesMap = null;
  private TreeNode<Integer> root = null;

  public MaxDifferenceNodeAncestor() {
    tree = new BinaryTree<Integer>();
    nodesMap = new HashMap<Integer, TreeNode<Integer>>();
  }

  public void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      int val = 0;
      switch (values[0]) {
      case "insertRoot":
        val = Integer.parseInt(values[1]);
        TreeNode<Integer> root = tree.insertRoot(val);
        if (root != null) {
          nodesMap.put(val, root);
          this.root = root;
        }
        break;
      case "insertLeft":
        insert(values[1], values[2], true);
        break;
      case "insertRight":
        insert(values[1], values[2], false);
        break;
      }
    }
  }

  private void insert(String parentStr, String nodeStr, boolean isLeft) {
    int parentVal = Integer.parseInt(parentStr);
    int nodeVal = Integer.parseInt(nodeStr);
    TreeNode<Integer> parentNode = nodesMap.get(parentVal);
    if (parentNode == null) {
      return;
    }

    TreeNode<Integer> node = new TreeNode<Integer>(nodeVal);
    nodesMap.put(nodeVal, tree.insert(parentNode, node, isLeft));
  }

  public int maximumDifference() {
    return maximumDifference(root, root.data, Integer.MIN_VALUE);
  }

  private int maximumDifference(TreeNode<Integer> root, int maxAncestor, int maxDiff) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }

    maxDiff = Math.max((maxAncestor - root.data), maxDiff);

    maxAncestor = Math.max(root.data, maxAncestor);
    maxDiff = Math.max(maximumDifference(root.left, maxAncestor, maxDiff), maxDiff);
    maxDiff = Math.max(maximumDifference(root.right, maxAncestor, maxDiff), maxDiff);

    return maxDiff;
  }
}
