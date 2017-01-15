package datastructures.tree;

public class BinarySearchTree<T> {
  TreeNode<T> root = null;

  public BinarySearchTree() {

  }

  public TreeNode<T> insertRoot(T data) {
    this.root = new TreeNode<T>(data);
    return this.root;
  }

  public TreeNode<T> insert(TreeNode<T> root, T data) {
    if (root == null) {
      root = new TreeNode<T>(data);
    } else {
      if (root.compareTo(data) >= 0) {
        root.left = insert(root.left, data);
      } else {
        root.right = insert(root.right, data);
      }
    }
    return root;
  }

  public TreeNode<T> delete(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }

    if (root.data.equals(data)) {
      // Leaf node
      if (root.left == null && root.right == null) {
        root = null;
      } else if (root.left == null) {
        root = root.right; // Node with only right child
      } else if (root.right == null) {
        root = root.left; // Node with only left child
      } else {
        // Node with two children
        T minVal = findRightMin(root.right); // Find min of right subTree
        root.data = minVal; // Set minVal to current node data
        root.right = delete(root.right, minVal); // Delete the minVal
      }
    } else {
      if (root.compareTo(data) >= 0) {
        root.left = delete(root.left, data);
      } else {
        root.right = delete(root.right, data);
      }
    }

    return root;
  }

  private T findRightMin(TreeNode<T> root) {
    if (root.left == null) {
      T data = root.data;
      return data;
    } else {
      return findRightMin(root.left);
    }
  }

  public String breadthFirstTraversal(TreeNode<T> root) {
    Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
    int level = 0, numElementsAtDepth = 0;
    boolean shouldIncreaseDepth = false;
    StringBuilder builder = new StringBuilder();

    queue.add(root);
    builder.append("Level: ").append(level).append(" => [ ");
    numElementsAtDepth = queue.size();

    while (!queue.isEmpty()) {
      TreeNode<T> node = queue.poll();
      numElementsAtDepth--;
      if (node != null) {
        builder.append(node.data).append(" ");
        if (numElementsAtDepth == 0) {
          level++;
          shouldIncreaseDepth = true;
          builder.append("]").append("\n");
          builder.append("Level: ").append(level).append(" => [ ");
        }

        queue.add(node.left);
        queue.add(node.right);

        if (shouldIncreaseDepth) {
          numElementsAtDepth = queue.size();
          shouldIncreaseDepth = false;
        }
      }
    }
    builder.append("]").append("\n\n");
    builder.append("Number of Levels: " + level);

    return builder.toString();
  }

  public String depthFirstTraversal(TreeNode<T> root) {
    Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
    StringBuilder builder = new StringBuilder();
    stack.push(root);

    builder.append("[ ");

    while (!stack.isEmpty()) {
      TreeNode<T> top = stack.peek();

      if (!top.visited) {
        builder.append(top.data).append(" ");
        top.visited = true;
      }
      TreeNode<T> child = null;
      if (top.left != null && !top.left.visited) {
        child = top.left;
      } else if (top.right != null && !top.right.visited) {
        child = top.right;
      }

      if (child == null) {
        stack.pop();
      } else {
        stack.push(child);
      }
    }

    builder.append("]");
    resetVisited(treeRoot);
    return builder.toString();
  }

  public T find(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }

    if (root.data.equals(data)) {
      return data;
    } else {
      if (root.compareTo(data) >= 0) {
        return find(root.left, data);
      } else {
        return find(root.right, data);
      }
    }
  }

  public String findPath(TreeNode<T> root, T data) {
    if (root == null) {
      return null;
    }
    StringBuilder builder = new StringBuilder();
    if (root.data.equals(data)) {
      return root.data.toString();
    } else {
      if (root.compareTo(data) >= 0) {
        String nextElement = findPath(root.left, data);
        if (nextElement != null) {
          builder.append(root.data).append("->left->").append(nextElement);
        } else {
          builder = null;
        }
      } else {
        String nextElement = findPath(root.right, data);
        if (nextElement != null) {
          builder.append(root.data).append("->right->").append(nextElement);
        } else {
          builder = null;
        }
      }
    }

    return (builder == null) ? null : builder.toString();
  }

  public void inOrder(TreeNode<T> root) {
    if (root != null) {
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
    }
  }

  public void preOrder(TreeNode<T> root) {
    if (root != null) {
      System.out.print(root.data + " ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  public void postOrder(TreeNode<T> root) {
    if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.data + " ");
    }
  }

  public TreeNode<T> getRoot() {
    return this.root;
  }
}
