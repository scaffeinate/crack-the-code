package leetcode.week_of_code_31;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.tree.TreeNode;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly
 * the same structure and node values with a subtree of s. A subtree of s is a
 * tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 * 
 * Example 1: 
 * Given tree s:
 *       3
        / \
       4   5
      / \
     1   2
     
 * Given tree t:
 *     4 
      / \
     1   2 
 * Return true, because t has the same structure and node values with a subtree
 * of s.
 * 
 * Example 2: 
 * Given tree s:
 *     3
      / \
     4   5
    / \
   1   2
      /
     0
 * Given tree t:
 *     4
      / \
     1   2
 * Return false.
 * 
 * LeetCode Week of Code 31
 * 
 * @author Sudharsanan Muralidharan
 */
public class SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode<Integer> s, TreeNode<Integer> t) {
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    queue.add(s);
    while (!queue.isEmpty()) {
      TreeNode<Integer> current = queue.poll();
      if (current.data == t.data) {
        boolean matches = treeMatches(current, t);
        if (matches) {
          return true;
        }
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

  private boolean treeMatches(TreeNode<Integer> s, TreeNode<Integer> t) {
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    } else {
      return s.data == t.data && treeMatches(s.left, t.left) && treeMatches(s.right, t.right);
    }
  }
}
