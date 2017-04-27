package binarytree;

import java.util.HashMap;
import java.util.Map;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class CheckCousinsBinaryTree {
  private BinaryTree<Integer> tree = null;
  private Map<Integer, TreeNode<Integer>> nodesMap = null;
  private TreeNode<Integer> root = null;

  public CheckCousinsBinaryTree() {
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

  public boolean checkCousins(int node1Val, int node2Val) {
    return this.checkCousins(this.root, null, 0, node1Val, node2Val).cousins;
  }

  private TreeNodeWrapper<Integer> checkCousins(TreeNode<Integer> root, TreeNode<Integer> parent, int level,
      int node1Val, int node2Val) {
    if (root == null) {
      return null;
    }

    if (root.data == node1Val || root.data == node2Val) {
      return new TreeNodeWrapper<Integer>(parent, level);
    }

    TreeNodeWrapper<Integer> leftWrapper = checkCousins(root.left, root, level + 1, node1Val, node2Val);
    TreeNodeWrapper<Integer> rightWrapper = checkCousins(root.right, root, level + 1, node1Val, node2Val);

    if (leftWrapper != null && rightWrapper != null) {
      return new TreeNodeWrapper<Integer>(
          !(leftWrapper.parent).equals(rightWrapper.parent) && leftWrapper.level == rightWrapper.level);
    } else if (leftWrapper != null || rightWrapper != null) {
      return (leftWrapper == null) ? rightWrapper : leftWrapper;
    }

    return null;
  }

  @SuppressWarnings("hiding")
  class TreeNodeWrapper<Integer> {
    TreeNode<Integer> parent;
    int level = 0;
    boolean cousins = false;

    TreeNodeWrapper(boolean cousins) {
      this.cousins = cousins;
    }

    TreeNodeWrapper(TreeNode<Integer> parent, int level) {
      this.parent = parent;
      this.level = level;
    }
  }
}
