package datastructures.tree;

public class TreeNode<T> implements Comparable<T> {
  T data;
  TreeNode<T> left = null;
  TreeNode<T> right = null;
  boolean visited = false;
  
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
      return ((Integer) data).compareTo((Integer) o);
    } else if (o instanceof Float) {
      return ((Float) data).compareTo((Float) o);
    } else if (o instanceof Double) {
      return ((Double) data).compareTo((Double) o);
    } else if (o instanceof Character) {
      return ((Character) data).compareTo((Character) o);
    } else if (o instanceof String) {
      return ((String) data).compareTo((String) o);
    }

    return -1;
  }
}
