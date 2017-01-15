package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import datastructures.util.InputUtil;

public class TestBinarySearchTree {

  private BinarySearchTree<Integer> tree = null;
  private TreeNode<Integer> root = null;

  public TestBinarySearchTree() {
    tree = new BinarySearchTree<Integer>();
  }

  private void insertRoot(Integer data) {
    System.out.println("Inserting root: " + data);
    root = tree.insertRoot(data);
  }

  private void insert(Integer data) {
    System.out.println("Inserting value: " + data);
    tree.insert(root, data);
  }

  private void delete(Integer data) {
    System.out.println("Deleting value: " + data);
    tree.delete(root, data);
  }

  private void traversal() {
    System.out.println("\nTree Traversal: \n");
    System.out.println("Depth First Traversal: ");
    System.out.println("1. Using stack: " + tree.depthFirstTraversal(root));
    System.out.println();
    System.out.println("2. Recursive: ");
    System.out.println("PreOrder: [ " + tree.preOrder(root) + "]");
    System.out.println("InOrder: [ " + tree.inOrder(root) + "]");
    System.out.print("PostOrder: [ " + tree.postOrder(root) + "]");

    System.out.println("\n\n");
    System.out.println("Breadth First Traversal: \n" + tree.breadthFirstTraversal(root));
    System.out.println();
  }

  private void search(Integer data) {
    System.out.println("Searching for: " + data);
    System.out.println("Is " + data + " in BST: " + (tree.find(root, data) != null));
    System.out.println("Search path for " + data + ":" + tree.findPath(root, data));
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    TestBinarySearchTree testBinarySearchTree = new TestBinarySearchTree();
    String[] input = InputUtil.readContents("test_binary_search_tree");

    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      Integer value = null;
      
      try {
        value = Integer.parseInt(values[1]);
      } catch (Exception e) {
        
      }
      
      if (action.equals("insertNodes")) {
        String[] nodes = values[1].split(",");
        for (String node : nodes) {
          testBinarySearchTree.insert(Integer.parseInt(node));
        }
      } else if (action.equals("insertRoot")) {
        testBinarySearchTree.insertRoot(value);
      } else if (action.equals("insert")) {
        testBinarySearchTree.insert(value);
      } else if (action.equals("traversal")) {
        testBinarySearchTree.traversal();
      } else if (action.equals("delete")) {
        testBinarySearchTree.delete(value);
      } else if (action.equals("search")) {
        testBinarySearchTree.search(value);
      }
    }
  }
}
