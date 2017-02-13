/**
 * 
 */
package tree_graph;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

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

  public TreeNode<T> delete(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }

    if (root.data.equals(data)) {
      if (root.left != null && root.right != null) {
        T val = null;
        // Immediate child is the maximum of the left subtree
        if (root.left.right == null) {
          val = root.left.data;
        } else {
          val = findReplacement(root.left);
        }
        delete(root, val);
        root.data = val;
        return root;
      } else if (root.left != null && root.right == null) {
        treeCount.remove(root);
        return root.left;
      } else if (root.left == null && root.right != null) {
        treeCount.remove(root);
        return root.right;
      } else {
        treeCount.remove(root);
        return null;
      }
    }

    if (root.compareTo(data) > 0) {
      root.left = delete(root.left, data);
      treeCount.put(root, treeCount.get(root) - 1);
    } else {
      root.right = delete(root.right, data);
      treeCount.put(root, treeCount.get(root) - 1);
    }

    return root;
  }

  private T findReplacement(TreeNode<T> root) {
    if (root.right == null) {
      return root.data;
    }

    return findReplacement(root.right);
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

  public TreeNode<T> getRandom(TreeNode<T> root) {
    TreeNode<T> randomNode = randomize(root);
    if (randomNode.equals(root)) {
      return root;
    } else {
      return getRandom(randomNode);
    }
  }

  private TreeNode<T> randomize(TreeNode<T> root) {
    int subTreeCount = treeCount.get(root);
    if (subTreeCount == 1) {
      return root;
    }

    int randomNum = new Random().nextInt(subTreeCount);
    if (randomNum == 0) {
      return root;
    } else {
      if (randomNum % 2 == 0) {
        return root.left == null ? root.right : root.left;
      } else {
        return root.right == null ? root.left : root.right;
      }
    }
  }

  public void inOrder(TreeNode<T> root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  public Map<TreeNode<T>, Integer> getTreeCount() {
    return this.treeCount;
  }
  
  private class TreeNodeWrapper<T> {
    private TreeNode<T> root = null;
    private TreeNode<T> deletedNode = null;
    private boolean deleted = false;
  }
}
