package datastructures.tree;

public class BinarySearchTree {
  TreeNode<Integer> root = null;

  public BinarySearchTree() {

  }

  public TreeNode<Integer> insert(TreeNode<Integer> root, Integer data) {
    if (this.root == null) {
      return createRoot(data);
    }
    if (root == null) {
      root = new TreeNode<Integer>();
      root.data = data;
    } else {
      if (data.compareTo(root.data) <= 0) {
        root.children.set(0, insert(root.children.get(0), data));
      } else {
        root.children.set(1, insert(root.children.get(1), data));
      }
    }
    return root;
  }
  
  
  public String findPath(TreeNode<Integer> root, Integer data) {
    if(root == null) {
      return "not found";
    }
    String path = "";
    if(root.data.equals(data)) {
      return root.data.toString();
    } else {
      if(data.compareTo(root.data) <= 0) {
         path += (root.data) + "->left->" + findPath(root.children.get(0), data);
      } else {
        path += (root.data) + "->right->" + findPath(root.children.get(1), data);
      }
    }
    
    return path;
  }

  public void inOrder(TreeNode<Integer> root) {
    if (root != null) {
      System.out.println(root.data);
      inOrder(root.children.get(0));
      inOrder(root.children.get(1));
    }
  }
  
  public void preOrder(TreeNode<Integer> root) {
    if(root != null) {
      preOrder(root.children.get(0));
      System.out.println(root.data);
      preOrder(root.children.get(1));
    }
  }
  
  public void postOrder(TreeNode<Integer> root) {
    if(root != null) {
      preOrder(root.children.get(0));
      preOrder(root.children.get(1));
      System.out.println(root.data);
    }
  }

  public TreeNode<Integer> createRoot(Integer data) {
    this.root = new TreeNode<Integer>();
    this.root.data = data;
    return this.root;
  }

  public TreeNode<Integer> getRoot() {
    return this.root;
  }
}
