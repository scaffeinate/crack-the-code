/**
 *
 */
package datastructures.util;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.tree.TreeNode;

/**
 * @author Sudharsanan Muralidharan
 */
public class TreeUtil {

    @SuppressWarnings("rawtypes")
    public static String breadthFirstTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0, numElementsAtDepth = 0;
        StringBuilder builder = new StringBuilder();

        queue.add(root);
        builder.append("Level: ").append(depth).append(" => [ ");
        numElementsAtDepth = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
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
        builder.append("Height of the Tree: " + depth);

        return builder.toString();
    }

    @SuppressWarnings("rawtypes")
    public static String inOrder(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(inOrder(root.left));
            builder.append(root.data).append(" ");
            builder.append(inOrder(root.right));
        }

        return builder.toString();
    }

    @SuppressWarnings("rawtypes")
    public static String preOrder(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(root.data).append(" ");
            builder.append(preOrder(root.left));
            builder.append(preOrder(root.right));
        }

        return builder.toString();
    }

    @SuppressWarnings("rawtypes")
    public static String postOrder(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(postOrder(root.left));
            builder.append(postOrder(root.right));
            builder.append(root.data).append(" ");
        }

        return builder.toString();
    }
}
