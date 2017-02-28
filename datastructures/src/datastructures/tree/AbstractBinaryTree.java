/**
 * 
 */
package datastructures.tree;

import datastructures.util.TreeUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public abstract class AbstractBinaryTree<T> implements GenericBinaryTree<T> {

  protected TreeNode<T> root = null;

  protected boolean linkToParent;

  @Override
  public TreeNode<T> insertRoot(T data) {
    root = new TreeNode<T>(data);
    return root;
  }

  @Override
  public String breadthFirstTraversal(TreeNode<T> root) {
    return TreeUtil.breadthFirstTraversal(root);
  }

  @Override
  public String depthFirstTraversal(TreeNode<T> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String preOrder(TreeNode<T> root) {
    return TreeUtil.preOrder(root);
  }

  @Override
  public String inOrder(TreeNode<T> root) {
    return TreeUtil.inOrder(root);
  }

  @Override
  public String postOrder(TreeNode<T> root) {
    return TreeUtil.postOrder(root);
  }

  public TreeNode<T> getRoot() {
    return this.root;
  }

  public void setRoot(TreeNode<T> root) {
    this.root = root;
  }
}
