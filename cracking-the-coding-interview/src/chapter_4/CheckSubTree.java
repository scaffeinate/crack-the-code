/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class CheckSubTree {
  BinaryTree<Integer> tree = null;
  BinaryTree<Integer> subTree = null;
  BinaryTree<Integer> currentTree = null;
  Map<Integer, TreeNode<Integer>> treeNodes = null;

  public CheckSubTree() {
    tree = new BinaryTree<Integer>();
    subTree = new BinaryTree<Integer>();
    treeNodes = new HashMap<Integer, TreeNode<Integer>>();
  }

  private void constructTrees(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "tree":
        currentTree = tree;
        treeNodes.clear();
        break;
      case "subTree":
        currentTree = subTree;
        treeNodes.clear();
        break;
      case "insertRoot":
        TreeNode<Integer> root = currentTree.insertRoot(Integer.parseInt(values[1]));
        treeNodes.put(root.data, root);
        break;
      case "insertLeft":
        insertChild(values, true);
        break;
      case "insertRight":
        insertChild(values, false);
        break;
      case "print":
        System.out.println(currentTree.breadthFirstTraversal(currentTree.getRoot()) + "\n");
        break;
      case "checkSubTree":
        System.out.println(checkSubTree(tree, subTree));
        System.out.println(checkSubTree2(tree, subTree));
        break;
      }
    }
  }

  private void insertChild(String[] values, boolean isLeft) {
    String[] nodes = values[1].split("->");
    Integer parentVal = Integer.parseInt(nodes[0]);
    Integer nodeVal = Integer.parseInt(nodes[1]);
    TreeNode<Integer> parent = null;
    if ((parent = treeNodes.get(parentVal)) != null) {
      TreeNode<Integer> node = currentTree.insert(parent, new TreeNode<Integer>(nodeVal), isLeft);
      treeNodes.put(nodeVal, node);
    }
  }

  private boolean checkSubTree(BinaryTree<Integer> tree, BinaryTree<Integer> subTree) {
    List<Integer> treeList = preOrder(tree.getRoot());
    List<Integer> subTreeList = preOrder(subTree.getRoot());

    int delta = treeList.size() - subTreeList.size();
    int i = 0, j = 0;

    while (i < delta) {
      boolean matches = true;
      while (j < subTreeList.size()) {
        Integer treeListVal = treeList.get(i + j);
        Integer subTreeListVal = subTreeList.get(j);
        if (!treeListVal.equals(subTreeListVal)) {
          i++;
          matches = false;
          break;
        }
        j++;
      }

      if (matches) {
        return true;
      }
    }

    return false;
  }

  private boolean checkSubTree2(BinaryTree<Integer> tree, BinaryTree<Integer> subTree) {
    return preOrder2(tree.getRoot(), subTree.getRoot());
  }

  private boolean preOrder2(TreeNode<Integer> root, TreeNode<Integer> subRoot) {
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode<Integer> current = queue.poll();
      if (compareSubTrees(current, subRoot)) {
        return true;
      }
      if (current.left != null) {
        queue.add(current.left);
      }

      if (current.right != null) {
        queue.add(current.right);
      }
    }

    return false;
  }

  private boolean compareSubTrees(TreeNode<Integer> root, TreeNode<Integer> subRoot) {
    if (root != null && subRoot != null) {
      return root.data.equals(subRoot.data) && compareSubTrees(root.left, subRoot.left)
          && compareSubTrees(root.right, subRoot.right);
    } else if ((root == null && subRoot == null) || (root != null && subRoot == null)) {
      return true;
    }

    return false;
  }

  private List<Integer> preOrder(TreeNode<Integer> root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root != null) {
      result.add(root.data);
      result.addAll(preOrder(root.left));
      result.addAll(preOrder(root.right));
    } else {
      result.add(Integer.MIN_VALUE);
    }

    return result;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "check_subtree");
    CheckSubTree checkSubTree = new CheckSubTree();
    checkSubTree.constructTrees(input);
  }
}
