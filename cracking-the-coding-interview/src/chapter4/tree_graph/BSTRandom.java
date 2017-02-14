/**
 * 
 */
package chapter4.tree_graph;

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

  public boolean delete(TreeNode<T> root, T data) {
    TreeNodeWrapper<T> nodeWrapper = new TreeNodeWrapper<T>(root);
    TreeNodeWrapper<T> deletedNodeWrapper = delete(nodeWrapper, data);
    return deletedNodeWrapper.deleted;
  }

  public TreeNodeWrapper<T> delete(TreeNodeWrapper<T> rootWrapper, T data) {
    if (rootWrapper.root == null) {
      return new TreeNodeWrapper<T>(false);
    }

    TreeNode<T> root = rootWrapper.root;

    if (root.data.equals(data)) {
      if (root.left != null && root.right != null) {
        T val = findReplacement(root.left);
        root.left = delete(new TreeNodeWrapper<T>(root.left), val).root;
        root.data = val;
        treeCount.put(root, treeCount.get(root) - 1);
      } else if (root.left != null && root.right == null) {
        treeCount.remove(root);
        rootWrapper.root = root.left;
      } else if (root.right != null && root.left == null) {
        treeCount.remove(root);
        rootWrapper.root = root.right;
      } else {
        treeCount.remove(root);
        return new TreeNodeWrapper<T>(true);
      }
      rootWrapper.deleted = true;
    } else {
      TreeNodeWrapper<T> deletedNodeWrapper = null;
      if (root.compareTo(data) > 0) {
        deletedNodeWrapper = delete(new TreeNodeWrapper<T>(root.left), data);
        root.left = deletedNodeWrapper.root;
      } else {
        deletedNodeWrapper = delete(new TreeNodeWrapper<T>(root.right), data);
        root.right = deletedNodeWrapper.root;
      }

      rootWrapper.deleted = deletedNodeWrapper.deleted;
      if (deletedNodeWrapper.deleted) {
        treeCount.put(root, treeCount.getOrDefault(root, 1) - 1);
      }
    }

    return rootWrapper;
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
    int randomNum = new Random().nextInt(treeCount.get(root));
    return getRandom(root, randomNum);
  }

  private TreeNode<T> getRandom(TreeNode<T> root, int randomNum) {
    int leftTreeCount = getLeftTreeCount(root);
    if (randomNum < leftTreeCount) {
      return getRandom(root.left, randomNum);
    } else if (randomNum == leftTreeCount) {
      return root;
    } else {
      randomNum -= (leftTreeCount + 1);
      return getRandom(root.right, randomNum);
    }
  }

 
  private int getLeftTreeCount(TreeNode<T> root) {
    if (root.left == null) {
      return 0;
    } else {
      return treeCount.get(root.left);
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

  @SuppressWarnings("hiding")
  private class TreeNodeWrapper<T> {
    private TreeNode<T> root = null;
    private boolean deleted = false;

    public TreeNodeWrapper(TreeNode<T> root) {
      this.root = root;
    }

    public TreeNodeWrapper(boolean deleted) {
      this.deleted = deleted;
    }
  }
}
