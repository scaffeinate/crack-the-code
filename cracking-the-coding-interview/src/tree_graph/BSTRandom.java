/**
 * 
 */
package tree_graph;

import java.util.LinkedHashMap;
import java.util.Map;

import datastructures.tree.TreeNode;

/**
 * @author Sudharsanan Muralidharan
 */
public class BSTRandom<T> {
  private TreeNode<T> root = null;
  private Map<TreeNode<T>, Integer> treeCount = null;

  public BSTRandom() {
    treeCount = new LinkedHashMap<TreeNode<T>, Integer>();
  }

  public TreeNode<T> insertRoot(T data) {
    root = new TreeNode<T>(data);
    treeCount.put(root, 1);
    return root;
  }

  public TreeNode<T> insert(TreeNode<T> root, T data) {
    TreeNode<T> node = null;
    if (root == null) {
      node = new TreeNode<T>(data);
      treeCount.put(node, 1);
      return node;
    }

    if (root.compareTo(data) > 0) {
      node = insert(root.left, data);
      root.left = node;
    } else {
      node = insert(root.right, data);
      root.right = node;
    }

    treeCount.put(root, treeCount.get(root) + 1);
    return root;
  }

  public TreeNode<T> find(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }

    if (root.data.equals(data)) {
      return root;
    } else if (root.compareTo(data) > 0) {
      return find(root.left, data);
    } else {
      return find(root.right, data);
    }
  }

  public void inOrder(TreeNode<T> root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }
}
