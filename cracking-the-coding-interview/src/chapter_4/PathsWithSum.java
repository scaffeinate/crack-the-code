/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class PathsWithSum {
  private BinarySearchTree<Integer> tree = null;
  private TreeNode<Integer> root = null;

  public PathsWithSum() {
    tree = new BinarySearchTree<Integer>();
  }

  private void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "insertRoot":
        root = tree.insertRoot(Integer.parseInt(values[1]));
        break;
      case "insert":
        tree.insert(root, Integer.parseInt(values[1]));
        break;
      case "print":
        System.out.println(tree.breadthFirstTraversal(root));
        break;
      case "pathsSum":
        System.out.println(calculatePathsWithSum(root, Integer.parseInt(values[1])));
        break;
      }
    }
  }

  private int calculatePathsWithSum(TreeNode<Integer> root, Integer sum) {
    if (root == null) {
      return 0;
    }
    return calculateNumPaths(root, sum) + calculatePathsWithSum(root.left, sum)
        + calculatePathsWithSum(root.right, sum);
  }

  private int calculateNumPaths(TreeNode<Integer> root, Integer sum) {
    if (root != null) {
      int count = 0;
      sum -= root.data;
      if (sum == 0) {
        count++;
      }
      return count + calculateNumPaths(root.left, sum) + calculateNumPaths(root.right, sum);
    }
    return 0;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "paths_with_sum");
    PathsWithSum pathsWithSum = new PathsWithSum();
    pathsWithSum.constructTree(input);
  }
}
