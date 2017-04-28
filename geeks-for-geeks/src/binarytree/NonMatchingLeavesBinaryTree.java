package binarytree;

import java.util.ArrayList;
import java.util.List;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import datastructures.util.BinaryTreeUtil;

/**
 * Question: http://www.geeksforgeeks.org/?p=142071
 * 
 * @author Sudharsanan Muralidharan
 */
public class NonMatchingLeavesBinaryTree {

  public BinaryTree<Integer> constructTree(String[] input) {
    return BinaryTreeUtil.constructTree(input);
  }

  public int[] findNonMatchingLeaves(BinaryTree<Integer> tree, BinaryTree<Integer> tree2) {
    List<Integer> treeNodesList = new ArrayList<Integer>();
    List<Integer> treeNodesList2 = new ArrayList<Integer>();

    inOrder(tree.getRoot(), treeNodesList);
    inOrder(tree2.getRoot(), treeNodesList2);
    int i = 0, j = 0;

    while (i < treeNodesList.size() && j < treeNodesList2.size()) {
      if (treeNodesList.get(i) != treeNodesList2.get(j)) {
        return new int[] { treeNodesList.get(i), treeNodesList2.get(j) };
      }

      i++;
      j++;
    }

    return null;
  }

  private void inOrder(TreeNode<Integer> root, List<Integer> treeNodesList) {
    if (root != null) {
      inOrder(root.left, treeNodesList);
      if (root.left == null && root.right == null) {
        treeNodesList.add(root.data);
      }
      inOrder(root.right, treeNodesList);
    }
  }
}
