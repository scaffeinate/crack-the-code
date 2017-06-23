/**
 *
 */
package datastructures.tree;

/**
 * @author Sudharsanan Muralidharan
 */
public class BinaryTree<T> extends AbstractBinaryTree<T> {

    public BinaryTree() {
        this(false);
    }

    public BinaryTree(boolean linkToParent) {
        super.linkToParent = linkToParent;
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

        if (linkToParent) {
            node.parent = root;
        }

        return node;
    }
}
