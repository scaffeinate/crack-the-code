/**
 *
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question 4.2: Given a sorted(increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 *
 * @author Sudharsanan Muralidharan
 */
public class MinimalTree {
    BinarySearchTree<Integer> tree;

    public MinimalTree() {
        tree = new BinarySearchTree<Integer>();
    }

    private void constructBST(Integer[] values) {
        TreeNode<Integer> root = addNode(null, values, 0, values.length);
        tree.setRoot(root);
    }

    private TreeNode<Integer> addNode(TreeNode<Integer> root, Integer[] values, int start, int end) {
        if (start == end) {
            return null;
        }

        int center = (start + end) / 2;
        int data = values[center];
        TreeNode<Integer> node = new TreeNode<Integer>(data);
        if (root == null) {
            root = node;
        } else {
            if (data < root.data) {
                root.left = node;
            } else {
                root.right = node;
            }
        }

        addNode(node, values, start, center);
        addNode(node, values, center + 1, end);

        return root;
    }

    private void print() {
        System.out.println(tree.breadthFirstTraversal(tree.getRoot()));
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(4, "minimal_tree");
        MinimalTree minimalTree = new MinimalTree();

        for (String line : input) {
            String[] values = line.split(" ");
            Integer[] valuesArr = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                valuesArr[i] = Integer.parseInt(values[i]);
            }

            minimalTree.print();
            minimalTree.constructBST(valuesArr);
            minimalTree.print();
        }
    }
}
