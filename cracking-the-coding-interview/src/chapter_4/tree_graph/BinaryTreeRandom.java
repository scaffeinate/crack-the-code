/**
 * 
 */
package chapter_4.tree_graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
    return this.root = new TreeNode<T>(data);
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

    return node;
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

  public Map<TreeNode<T>, Integer> getSubTreeCountMap() {
    updateSubTreeMap(this.root, subtreeCountMap);
    return subtreeCountMap;
  }
  
  private Integer updateSubTreeMap(TreeNode<T> root, Map<TreeNode<T>, Integer> subtreeCountMap) {
    if(root == null) {
      return 0;
    }
    
    int leftCount = updateSubTreeMap(root.left, subtreeCountMap);
    int rightCount = updateSubTreeMap(root.right, subtreeCountMap);
    
    subtreeCountMap.put(root, (leftCount + rightCount + 1));
    return (leftCount + rightCount + 1);
  }
}
