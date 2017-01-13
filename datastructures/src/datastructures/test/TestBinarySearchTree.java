package datastructures.test;

import datastructures.tree.BinarySearchTree;

public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(tree.getRoot(), 5);
    tree.insert(tree.getRoot(), 4);
    tree.insert(tree.getRoot(), 6);
    tree.insert(tree.getRoot(), 1);
    tree.insert(tree.getRoot(), 3);
    tree.insert(tree.getRoot(), 2);
    tree.insert(tree.getRoot(), 5);
    tree.insert(tree.getRoot(), 8);
    tree.insert(tree.getRoot(), 7);
    
    tree.preOrder(tree.getRoot());
    tree.inOrder(tree.getRoot());
    tree.postOrder(tree.getRoot());
    
    System.out.println(tree.findPath(tree.getRoot(), 13));
  }
}
