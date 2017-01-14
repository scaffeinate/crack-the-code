package datastructures.test;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;

public class TestBinarySearchTree {
  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    TreeNode<Integer> root = tree.insertRoot(5);
    
    tree.insert(root, 4);
    tree.insert(root, 6);
    tree.insert(root, 5);
    tree.insert(root, 3);
    tree.insert(root, 4);
    tree.insert(root, 2);
    tree.insert(root, 1);
    tree.insert(root, 6);
    tree.insert(root, 7);
    tree.insert(root, 8);
    tree.insert(root, 10);
    tree.insert(root, 9);
    
    System.out.println("Tree Traversal: ");
    System.out.print("Tree preOrder: ");
    tree.preOrder(root);
    System.out.print("\nTree inOrder: ");
    tree.inOrder(root);
    System.out.print("\nTree postOrder: ");
    tree.postOrder(root);
    
    System.out.println("\n");
    System.out.println("Finding values: ");
    System.out.println("Is 7 in BST: " + (tree.find(root, 7) != null));
    System.out.println("Is 1 in BST: " + (tree.find(root, 1) != null));
    System.out.println("Is 17 in BST: " + (tree.find(root, 17) != null));
    
    System.out.println();
    System.out.println("Printing exact paths: ");
    System.out.println("Path for 7: " + tree.findPath(root, 7));
    System.out.println("Path for 1: " + tree.findPath(root, 1));
    System.out.println("Path for 17: " + tree.findPath(root, 17));
  }
}
