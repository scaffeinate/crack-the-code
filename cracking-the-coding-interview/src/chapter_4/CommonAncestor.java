/**
 * 
 */
package chapter_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class CommonAncestor {

  private BinaryTree<Integer> tree = null;
  private Map<Integer, TreeNode<Integer>> nodesMap = null;

  public CommonAncestor() {
    tree = new BinaryTree<Integer>(true);
    nodesMap = new HashMap<Integer, TreeNode<Integer>>();
  }

  private void constructTree(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "insert":
        List<TreeNode<Integer>> treeElements = new ArrayList<TreeNode<Integer>>();
        for (int i = 1; i < values.length; i++) {
          treeElements.add(new TreeNode<Integer>(Integer.parseInt(values[i])));
        }

        TreeNode<Integer> root = treeElements.get(0);
        nodesMap.put(root.data, root);
        tree.setRoot(root);

        int n = treeElements.size();

        for (int i = 0; i < (n / 2); i++) {
          TreeNode<Integer> node = null;
          root = treeElements.get(i);
          int leftIndex = (2 * i) + 1;
          int rightIndex = (2 * i) + 2;
          if (leftIndex < n) {
            node = tree.insert(root, treeElements.get(leftIndex), true);
            nodesMap.put(node.data, node);
          }

          if (rightIndex < n) {
            node = tree.insert(root, treeElements.get(rightIndex), false);
            nodesMap.put(node.data, node);
          }
        }

        break;
      case "print":
        System.out.println(tree.breadthFirstTraversal(tree.getRoot()));
        break;
      case "findAncestor":
        TreeNode<Integer> nodeA = nodesMap.get(Integer.parseInt(values[1]));
        TreeNode<Integer> nodeB = nodesMap.get(Integer.parseInt(values[2]));
        TreeNode<Integer> ancestor = findCommonAncestor(tree.getRoot(), nodeA, nodeB);
        System.out.println(ancestor.data);
        System.out.println(findCommonAncestor2(tree.getRoot(), nodeA, nodeB));
        break;
      }
    }
  }

  private TreeNode<Integer> findCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> nodeA,
      TreeNode<Integer> nodeB) {
    if (root != null) {
      TreeNode<Integer> leftNode = findCommonAncestor(root.left, nodeA, nodeB);
      TreeNode<Integer> rightNode = findCommonAncestor(root.right, nodeA, nodeB);

      if ((leftNode != null && rightNode != null) || (root.equals(nodeA) || root.equals(nodeB))) {
        return root;
      } else if (leftNode != null || rightNode != null) {
        return (leftNode != null) ? leftNode : rightNode;
      }
    }
    return null;
  }

  private TreeNode<Integer> findCommonAncestor2(TreeNode<Integer> root, TreeNode<Integer> nodeA,
      TreeNode<Integer> nodeB) {
    int nodeADepth = depth(root, nodeA);
    int nodeBDepth = depth(root, nodeB);

    TreeNode<Integer> longerNode = (nodeADepth > nodeBDepth) ? nodeA : nodeB;
    TreeNode<Integer> shorterNode = (nodeADepth > nodeBDepth) ? nodeB : nodeA;
    int diff = Math.abs(nodeADepth - nodeBDepth);

    for (int i = 0; i < diff; i++) {
      longerNode = longerNode.parent;
    }

    while (!longerNode.equals(shorterNode)) {
      longerNode = longerNode.parent;
      shorterNode = shorterNode.parent;
    }

    return longerNode;
  }

  private int depth(TreeNode<Integer> root, TreeNode<Integer> node) {
    if (root == null) {
      return -1;
    }

    int depth = 0;

    if (root.equals(node)) {
      return depth;
    } else {
      int leftDepth = depth(root.left, node);
      int rightDepth = depth(root.right, node);

      if (leftDepth == -1 && rightDepth == -1) {
        depth = -1;
      } else if (leftDepth == -1) {
        depth = rightDepth + 1;
      } else if (rightDepth == -1) {
        depth = leftDepth + 1;
      }
    }

    return depth;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(4, "common_ancestor");
    CommonAncestor commonAncestor = new CommonAncestor();
    commonAncestor.constructTree(input);
  }
}
