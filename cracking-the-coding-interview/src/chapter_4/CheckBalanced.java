/**
 *
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question: Implement a function to check if a binary tree is balanced. For the
 * purpose of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 *
 * @author Sudharsanan Muralidharan
 */
public class CheckBalanced {

    private BinarySearchTree<Integer> tree;

    public CheckBalanced() {
        tree = new BinarySearchTree<Integer>();
    }

    private void constructTree(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];
            Integer data = null;
            switch (action) {
                case "insertRoot":
                    data = Integer.parseInt(values[1]);
                    tree.insertRoot(data);
                    break;
                case "insert":
                    data = Integer.parseInt(values[1]);
                    tree.insert(tree.getRoot(), data);
                    break;
            }
        }
    }

    private boolean isBalanced() {
        return height(tree.getRoot()) != -1;
    }

    private int height(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        } else {
            leftHeight = leftHeight + 1;
            rightHeight = rightHeight + 1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(4, "check_balanced");
        CheckBalanced check = new CheckBalanced();
        check.constructTree(input);
        System.out.println("Is Tree Balanced? " + check.isBalanced());
    }
}
