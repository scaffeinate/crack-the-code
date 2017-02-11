/**
 * 
 */
package datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sudharsanan Muralidharan
 */
public class BinaryTree<T> {
  private TreeNode<T> root = null;
  private boolean linkToParent;

  public BinaryTree() {
    this(false);
  }

  public BinaryTree(boolean linkToParent) {
    this.linkToParent = linkToParent;
  }

  public TreeNode<T> getRoot() {
    return this.root;
  }

  public void setRoot(TreeNode<T> root) {
    this.root = root;
  }
  
  public TreeNode<T> insertRoot(T data) {
    root = new TreeNode<T>(data);
    return root;
  }

  public TreeNode<T> insert(TreeNode<T> root, TreeNode<T> node, boolean left) {
    if (root == null) {
      return null;
    }

    if (left) {
      root.left = node;
    } else {
      root.right = node;
    }
    
    if(linkToParent) {
      node.parent = root;
    }

    return node;
  }

  public String breadthFirstTraversal(TreeNode<T> root) {
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    int depth = 0, numElementsAtDepth = 0;
    StringBuilder builder = new StringBuilder();

    queue.add(root);
    builder.append("Level: ").append(depth).append(" => [ ");
    numElementsAtDepth = queue.size();

    while (!queue.isEmpty()) {
      TreeNode<T> node = queue.poll();
      numElementsAtDepth--;
      builder.append(node.data).append(" ");

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }

      if (numElementsAtDepth == 0) {
        depth++;
        if (!queue.isEmpty()) {
          builder.append("]").append("\n");
          builder.append("Level: ").append(depth).append(" => [ ");
          numElementsAtDepth = queue.size();
        }
      }
    }
    builder.append("]").append("\n\n");
    builder.append("Height of the Tree: " + (depth - 1));

    return builder.toString();
  }
}
