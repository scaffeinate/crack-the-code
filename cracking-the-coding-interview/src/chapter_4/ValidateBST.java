/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question 4.5: Implement a function to check if a binary tree is a binary search tree.
 * @author Sudharsanan Muralidharan
 */
public class ValidateBST {

  BinaryTree<Integer> tree = null;
  Queue<TreeNode<Integer>> queue = null;

  public ValidateBST() {
    tree = new BinaryTree<Integer>();
    queue = new LinkedList<TreeNode<Integer>>();
  }

  private void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "insert":
        List<TreeNode<Integer>> treeElements = new ArrayList<TreeNode<Integer>>();
        for (int i = 1; i < values.length; i++) {
          treeElements.add(new TreeNode<Integer>(Integer.parseInt(values[i])));
        }

        TreeNode<Integer> root = treeElements.get(0);
        tree.setRoot(root);

        int n = treeElements.size();

        for (int i = 0; i < (n / 2); i++) {
          root = treeElements.get(i);
          int leftIndex = (2 * i) + 1;
          int rightIndex = (2 * i) + 2;
          if (leftIndex < n) {
            tree.insert(root, treeElements.get(leftIndex), true);
          }

          if (rightIndex < n) {
            tree.insert(root, treeElements.get(rightIndex), false);
          }
        }

        System.out.println(tree.breadthFirstTraversal(tree.getRoot()));
        break;
      case "validate":
        System.out.println("Is valid BST? " + validate());
        System.out.println();
        break;
      }
    }
  }

  private boolean validate() {
    return validateBST(tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean validateBST(TreeNode<Integer> root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.data >= min && root.data < max) {
      return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
    }
    return false;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "validate_bst");
    ValidateBST validateBST = new ValidateBST();
    validateBST.constructTree(input);
  }
}
