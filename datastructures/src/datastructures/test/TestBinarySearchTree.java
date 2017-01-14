package datastructures.test;

import datastructures.tree.BinarySearchTree;

public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    tree.insertRoot(5);
    
    tree.insert(tree.getRoot(), 4);
    tree.insert(tree.getRoot(), 6);
    tree.insert(tree.getRoot(), 5);
    tree.insert(tree.getRoot(), 3);
    tree.insert(tree.getRoot(), 4);
    tree.insert(tree.getRoot(), 2);
    tree.insert(tree.getRoot(), 1);
    tree.insert(tree.getRoot(), 6);
    tree.insert(tree.getRoot(), 7);
    tree.insert(tree.getRoot(), 8);
    tree.insert(tree.getRoot(), 10);
    tree.insert(tree.getRoot(), 9);
    
    System.out.print("Tree preOrder: ");
    tree.preOrder(tree.getRoot());
    System.out.print("\nTree inOrder: ");
    tree.inOrder(tree.getRoot());
    System.out.print("\nTree postOrder: ");
    tree.postOrder(tree.getRoot());
    
    System.out.println();
    
    System.out.println("Find 1: " + tree.findPath(tree.getRoot(), 1));
    System.out.println("Find 10: " + tree.findPath(tree.getRoot(), 10));
    System.out.println("Find 11: " + tree.findPath(tree.getRoot(), 11));
  }
}
