package binarytree;

import datastructures.lists.LinkedListNode;
import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import datastructures.util.BinaryTreeUtil;

/**
 * Question: http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 */
public class ConvertBinaryTreeDoublyLinkedList {
  private BinaryTree<Integer> tree = null;
  private TreeNode<Integer> root = null;

  public ConvertBinaryTreeDoublyLinkedList() {
    tree = new BinaryTree<Integer>();
  }

  public void constructTree(String[] input) {
    tree = BinaryTreeUtil.constructTree(input);
    root = tree.getRoot();
  }

  public Wrapper convert() {
    Wrapper wrapper = new Wrapper();
    convert(this.root, wrapper);
    return wrapper;
  }

  private void convert(TreeNode<Integer> root, Wrapper wrapper) {
    if (root != null) {
      convert(root.left, wrapper);
      addToLinkedList(root, wrapper);
      convert(root.right, wrapper);
    }
  }

  private void addToLinkedList(TreeNode<Integer> root, Wrapper wrapper) {
    LinkedListNode<Integer> node = new LinkedListNode<Integer>(root.data);
    if (wrapper.head == null) {
      wrapper.head = node;
      wrapper.tail = node;
    } else {
      wrapper.tail.next = node;
      node.prev = wrapper.tail;
      wrapper.tail = node;
    }
  }

  class Wrapper {
    LinkedListNode<Integer> head = null;
    LinkedListNode<Integer> tail = null;
  }
}
