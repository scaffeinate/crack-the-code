/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question 4.3: Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth(e,g,m if you have a tree with depth D,
 * you'll have D linked lists).
 * 
 * @author Sudharsanan Muralidharan
 */
public class ListOfDepths {
  private BinarySearchTree<Integer> tree;

  public ListOfDepths() {
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
      case "listOfDepths":
        ArrayList<LinkedList<TreeNode<Integer>>> listOfLists = constructList(tree.getRoot());
        StringBuilder builder = new StringBuilder();
        for (LinkedList<TreeNode<Integer>> list : listOfLists) {
          for (TreeNode<Integer> element : list) {
            builder.append(element.data).append(" -> ");
          }
          builder.setLength(builder.length() - 4);
          builder.append("\n");
        }

        System.out.println(builder.toString());
        break;
      }
    }
  }

  private ArrayList<LinkedList<TreeNode<Integer>>> constructList(TreeNode<Integer> root) {
    ArrayList<LinkedList<TreeNode<Integer>>> listOfLists = new ArrayList<LinkedList<TreeNode<Integer>>>();
    LinkedList<TreeNode<Integer>> resultList = new LinkedList<TreeNode<Integer>>();
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);
    int nodesAtLevel = 1;

    while (!queue.isEmpty()) {
      TreeNode<Integer> current = queue.poll();
      resultList.add(current);
      nodesAtLevel--;
      
      if (current.left != null) {
        queue.add(current.left);
      }

      if (current.right != null) {
        queue.add(current.right);
      }

      if (nodesAtLevel == 0) {
        listOfLists.add(resultList);
        resultList = new LinkedList<TreeNode<Integer>>();
        nodesAtLevel = queue.size();
      }
    }

    return listOfLists;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "list_of_depths");
    ListOfDepths listOfDepths = new ListOfDepths();
    listOfDepths.constructTree(input);
  }
}
