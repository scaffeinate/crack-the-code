package tree;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;

/**
 * Question:
 * http://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/
 *
 * @author Sudharsanan Muralidharan
 */
public class CheckBSTHasDeadEnd {
    private BinarySearchTree<Integer> tree = null;
    private TreeNode<Integer> root = null;

    public CheckBSTHasDeadEnd() {
        tree = new BinarySearchTree<Integer>();
    }

    public void constructTree(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            String action = values[0];

            switch (action) {
                case "insertRoot":
                    tree = new BinarySearchTree<Integer>();
                    root = tree.insertRoot(Integer.parseInt(values[1]));
                    break;
                case "insert":
                    tree.insert(root, Integer.parseInt(values[1]));
                    break;
            }
        }
    }

    public boolean hasDeadEnd() {
        return hasDeadEnd(root, new Range(0, Integer.MAX_VALUE));
    }

    private boolean hasDeadEnd(TreeNode<Integer> root, Range range) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return Math.abs(root.data - range.min) <= 1 && Math.abs(range.max - root.data) <= 1;
        } else {
            return hasDeadEnd(root.left, new Range(range.min, root.data))
                    || hasDeadEnd(root.right, new Range(root.data, range.max));
        }
    }

    private class Range {
        private int min;
        private int max;

        Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
