package binarytree;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;

/**
 * Question:
 * http://www.geeksforgeeks.org/check-if-given-sorted-sub-sequence-exists-in-binary-search-tree/
 * 
 * @author Sudharsanan Muralidharan
 */
public class CheckSortedSubSequenceBST {
  private BinarySearchTree<Integer> tree = null;
  private TreeNode<Integer> root = null;

  public void constructTree(String[] input) {
    tree = new BinarySearchTree<Integer>();
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "insertRoot":
        tree = new BinarySearchTree<Integer>();
        root = tree.insertRoot(Integer.parseInt(values[1]));
        break;
      case "insert":
        tree.insert(root, Integer.parseInt(values[1]));
        break;
      }
    }
  }

  public boolean checkIfSeqExists(int[] sequence) {
    int index = inOrder(root, sequence, 0);
    return (index == sequence.length);
  }

  private int inOrder(TreeNode<Integer> root, int[] sequence, int index) {
    if (root == null) {
      return index;
    }

    index = inOrder(root.left, sequence, index);
    if (root.data == sequence[index]) {
      index += 1;
    }
    index = inOrder(root.right, sequence, index);
    return index;
  }
}
