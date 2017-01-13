package datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
  T data;
  List<TreeNode<T>> children;
  
  public TreeNode() {
    children = new ArrayList<TreeNode<T>>();
    children.add(null);
    children.add(null);
  }
}
