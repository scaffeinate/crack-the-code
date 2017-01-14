package datastructures.tree;

public class TreeNode<T> implements Comparable<T> {
  T data;
  TreeNode<T> left = null;
  TreeNode<T> right = null;

  public TreeNode() {

  }

  public TreeNode(T data) {
    this(data, null, null);
  }

  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  @Override
  public int compareTo(T o) {
    if (o instanceof Integer) {
      return ((Integer) o).compareTo((Integer) data);
    } else if (o instanceof Float) {
      return ((Float) o).compareTo((Float) data);
    } else if (o instanceof Double) {
      return ((Double) o).compareTo((Double) data);
    } else if (o instanceof Character) {
      return ((Character) o).compareTo((Character) data);
    } else if (o instanceof String) {
      return ((String) o).compareTo((String) data);
    }

    return -1;
  }
}
