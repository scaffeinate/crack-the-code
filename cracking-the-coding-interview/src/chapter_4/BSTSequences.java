/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * Question 4.9: 
 * 
 * @author Sudharsanan Muralidharan
 */
public class BSTSequences {

  private BinarySearchTree<Integer> tree = null;
  private TreeNode<Integer> root = null;

  public BSTSequences() {
    tree = new BinarySearchTree<Integer>();
  }

  private void constructBST(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "insertRoot":
        tree = new BinarySearchTree<Integer>();
        root = tree.insertRoot(Integer.parseInt(values[1]));
        break;
      case "insert":
        for (int i = 1; i < values.length; i++) {
          tree.insert(root, Integer.parseInt(values[i]));
        }
        break;
      case "bstSeq":
        printBSTSequences(root);
        break;
      }
    }
  }

  private void printBSTSequences(TreeNode<Integer> root) {
    List<List<Integer>> sequences = new ArrayList<List<Integer>>();
    sequences = generateBSTSequences(root);

    for (List<Integer> sequence : sequences) {
      System.out.println(sequence);
    }
    System.out.println(sequences.size());

  }

  private List<List<Integer>> generateBSTSequences(TreeNode<Integer> root) {
    List<List<Integer>> sequences = new ArrayList<List<Integer>>();

    if (root == null) {
      sequences.add(new ArrayList<Integer>());
      return sequences;
    }

    Stack<Integer> prefix = new Stack<Integer>();
    prefix.push(root.data);

    List<List<Integer>> leftSequences = generateBSTSequences(root.left);
    List<List<Integer>> rightSequences = generateBSTSequences(root.right);

    for (List<Integer> leftSeq : leftSequences) {
      for (List<Integer> rightSeq : rightSequences) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        weave(leftSeq, rightSeq, prefix, result);
        sequences.addAll(result);
      }
    }

    return sequences;
  }

  private void weave(List<Integer> first, List<Integer> second, Stack<Integer> prefix, List<List<Integer>> result) {
    if (first.isEmpty() || second.isEmpty()) {
      List<Integer> temp = new ArrayList<Integer>();
      temp.addAll(prefix);
      if (!first.isEmpty()) {
        temp.addAll(first);
      }

      if (!second.isEmpty()) {
        temp.addAll(second);
      }

      result.add(temp);

      return;
    }

    prefix.push(first.remove(0));
    weave(first, second, prefix, result);
    first.add(0, prefix.pop());

    prefix.push(second.remove(0));
    weave(first, second, prefix, result);
    second.add(0, prefix.pop());
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "bst_sequences");
    BSTSequences bstSequences = new BSTSequences();
    bstSequences.constructBST(input);
  }
}
