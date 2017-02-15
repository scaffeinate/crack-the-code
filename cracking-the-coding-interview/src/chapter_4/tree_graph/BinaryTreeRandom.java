/**
 * 
 */
package chapter_4.tree_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

import datastructures.tree.TreeNode;

/**
 * @author Sudharsanan Muralidharan
 */
public class BinaryTreeRandom<T> {
  private TreeNode<T> root = null;
  private Map<TreeNode<T>, Integer> subtreeCountMap = null;

  public BinaryTreeRandom() {
    subtreeCountMap = new HashMap<TreeNode<T>, Integer>();
  }

  public TreeNode<T> insertRoot(T data) {
    this.root = new TreeNode<T>(data);
    subtreeCountMap.put(this.root, 1);
    return this.root;
  }

  public TreeNode<T> insert(TreeNode<T> root, T data, boolean isLeft) {
    if (root == null) {
      return null;
    }

    TreeNode<T> node = new TreeNode<T>(data);
    if (isLeft) {
      root.left = node;
    } else {
      root.right = node;
    }

    updateSubTreeMap(this.root, subtreeCountMap);

    return node;
  }

  public TreeNode<T> delete(T data) {
    TreeNode<T> node = delete(this.root, data);
    updateSubTreeMap(root, subtreeCountMap);
    return node;
  }

  private TreeNode<T> delete(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }

    if (root.data.equals(data)) {
      return findReplacement(root);
    } else {
      root.left = delete(root.left, data);
      root.right = delete(root.right, data);
    }

    return root;
  }

  private TreeNode<T> findReplacement(TreeNode<T> root) {
    if (root.left != null && root.right != null) {
      TreeNode<T> leaf = findLeaf(root);
      delete(leaf.data);
      root.data = leaf.data;
      subtreeCountMap.remove(leaf);
      return root;
    } else {
      subtreeCountMap.remove(root);
      if (root.left != null && root.right == null) {
        return root.left;
      } else if (root.right != null && root.left == null) {
        return root.right;
      } else {
        return null;
      }
    }
  }

  private TreeNode<T> findLeaf(TreeNode<T> root) {
    if (root == null) {
      return null;
    } else if (root.left == null && root.right == null) {
      return root;
    } else {
      TreeNode<T> leftLeaf = findLeaf(root.left);
      TreeNode<T> rightLeaf = findLeaf(root.right);
      return (leftLeaf != null) ? leftLeaf : rightLeaf;
    }
  }

  public TreeNode<T> find(T data) {
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    queue.add(this.root);

    while (!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();

      if (current.data.equals(data)) {
        return current;
      }

      if (current.left != null) {
        queue.add(current.left);
      }

      if (current.right != null) {
        queue.add(current.right);
      }
    }

    return null;
  }

  public void inOrder(TreeNode<T> root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root + " ");
      inOrder(root.right);
    }
  }
  
  public TreeNode<T> getRandom() {
    int random = new Random().nextInt(subtreeCountMap.get(this.root));
    return getRandom(this.root, random);
  }
  
  private TreeNode<T> getRandom(TreeNode<T> root, int random) {
    int leftSubTreeCount = 0;
    if(root.left != null) {
      leftSubTreeCount = subtreeCountMap.get(root.left);
    }
    
    if(random < leftSubTreeCount) {
      return getRandom(root.left, random);
    } else if(random == leftSubTreeCount) {
      return root;
    } else {
      random -= (leftSubTreeCount + 1);
      return getRandom(root.right, random);
    }
  }
  
  public TreeNode<T> getRandom2() {
    return getRandom2(this.root);
  }
  
  private TreeNode<T> getRandom2(TreeNode<T> root) {
    int random = new Random().nextInt(subtreeCountMap.get(root));
    int leftSubTreeCount = 0;
    if(root.left != null) {
      leftSubTreeCount = subtreeCountMap.get(root.left);
    }
    
    if(random < leftSubTreeCount) {
      return getRandom2(root.left);
    } else if(random == leftSubTreeCount) {
      return root;
    } else {
      return getRandom2(root.right);
    }
  }

  public Map<TreeNode<T>, Integer> getSubTreeCountMap() {
    return subtreeCountMap;
  }

  private Integer updateSubTreeMap(TreeNode<T> root, Map<TreeNode<T>, Integer> subtreeCountMap) {
    if (root == null) {
      return 0;
    }

    int leftCount = updateSubTreeMap(root.left, subtreeCountMap);
    int rightCount = updateSubTreeMap(root.right, subtreeCountMap);

    subtreeCountMap.put(root, (leftCount + rightCount + 1));
    return (leftCount + rightCount + 1);
  }
}
