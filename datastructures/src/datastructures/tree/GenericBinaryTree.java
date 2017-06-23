/**
 *
 */
package datastructures.tree;

/**
 * @author Sudharsanan Muralidharan
 */
public interface GenericBinaryTree<T> {

    public TreeNode<T> insertRoot(T data);

    public String breadthFirstTraversal(TreeNode<T> root);

    public String depthFirstTraversal(TreeNode<T> root);

    public String preOrder(TreeNode<T> root);

    public String inOrder(TreeNode<T> root);

    public String postOrder(TreeNode<T> root);

    public TreeNode<T> getRoot();

    public void setRoot(TreeNode<T> root);
}
