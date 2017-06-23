package binarytree;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import datastructures.util.BinaryTreeUtil;

/**
 * Question: http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */
public class ConvertBinaryTreeDoublyLinkedList2 {
    private BinaryTree<Integer> tree = null;
    private TreeNode<Integer> root = null;

    public ConvertBinaryTreeDoublyLinkedList2() {
        tree = new BinaryTree<Integer>();
    }

    public void constructTree(String[] input) {
        tree = BinaryTreeUtil.constructTree(input);
        root = tree.getRoot();
    }

    public Wrapper convert() {
        Wrapper wrapper = new Wrapper();
        convert(root, wrapper);
        return wrapper;
    }

    private void convert(TreeNode<Integer> root, Wrapper wrapper) {
        if (root != null) {
            convert(root.left, wrapper);
            makeLink(root, wrapper);
            convert(root.right, wrapper);
        }
    }

    private void makeLink(TreeNode<Integer> root, Wrapper wrapper) {
        if (wrapper.head == null) {
            wrapper.head = root;
            wrapper.tail = root;
        } else {
            wrapper.tail.right = root;
            root.left = wrapper.tail;
            wrapper.tail = root;
        }
    }

    class Wrapper {
        TreeNode<Integer> head, tail;
    }
}
