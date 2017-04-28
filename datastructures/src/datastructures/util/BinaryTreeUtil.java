package datastructures.util;

import java.util.HashMap;
import java.util.Map;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class BinaryTreeUtil {

  public static BinaryTree<Integer> constructTree(String[] input) {
    BinaryTree<Integer> tree = new BinaryTree<Integer>();
    Map<Integer, TreeNode<Integer>> nodesMap = new HashMap<Integer, TreeNode<Integer>>();
    for (String line : input) {
      String[] values = line.split(" ");
      int val = 0;
      switch (values[0]) {
      case "insertRoot":
        val = Integer.parseInt(values[1]);
        TreeNode<Integer> root = tree.insertRoot(val);
        if (root != null) {
          nodesMap.put(val, root);
        }
        break;
      case "insertLeft":
        insert(nodesMap, tree, values[1], values[2], true);
        break;
      case "insertRight":
        insert(nodesMap, tree, values[1], values[2], false);
        break;
      }
    }

    return tree;
  }

  private static void insert(Map<Integer, TreeNode<Integer>> nodesMap, BinaryTree<Integer> tree, String parentStr,
      String nodeStr, boolean isLeft) {
    int parentVal = Integer.parseInt(parentStr);
    int nodeVal = Integer.parseInt(nodeStr);
    TreeNode<Integer> parentNode = nodesMap.get(parentVal);
    if (parentNode == null) {
      return;
    }

    TreeNode<Integer> node = new TreeNode<Integer>(nodeVal);
    nodesMap.put(nodeVal, tree.insert(parentNode, node, isLeft));
  }
}
