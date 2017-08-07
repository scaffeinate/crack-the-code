package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;
import datastructures.util.BinaryTreeUtil;

/**
 * Question: http://www.geeksforgeeks.org/?p=142071
 *
 * @author Sudharsanan Muralidharan
 */
public class NonMatchingLeavesBinaryTree {

    public BinaryTree<Integer> constructTree(String[] input) {
        return BinaryTreeUtil.constructTree(input);
    }

    public int[] findNonMatchingLeaves(BinaryTree<Integer> tree, BinaryTree<Integer> tree2) {
        List<Integer> treeNodesList = new ArrayList<Integer>();
        List<Integer> treeNodesList2 = new ArrayList<Integer>();

        inOrder(tree.getRoot(), treeNodesList);
        inOrder(tree2.getRoot(), treeNodesList2);
        int i = 0, j = 0;

        while (i < treeNodesList.size() && j < treeNodesList2.size()) {
            if (treeNodesList.get(i) != treeNodesList2.get(j)) {
                return new int[]{treeNodesList.get(i), treeNodesList2.get(j)};
            }

            i++;
            j++;
        }

        return null;
    }

    private void inOrder(TreeNode<Integer> root, List<Integer> treeNodesList) {
        if (root != null) {
            inOrder(root.left, treeNodesList);
            if (root.left == null && root.right == null) {
                treeNodesList.add(root.data);
            }
            inOrder(root.right, treeNodesList);
        }
    }

    public int[] findNonMatchingLeaves2(BinaryTree<Integer> tree, BinaryTree<Integer> tree2) {
        Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
        Stack<TreeNode<Integer>> stack2 = new Stack<TreeNode<Integer>>();
        Set<TreeNode<Integer>> visited = new HashSet<TreeNode<Integer>>();
        Set<TreeNode<Integer>> visited2 = new HashSet<TreeNode<Integer>>();

        stack.push(tree.getRoot());
        stack2.push(tree2.getRoot());

        while (!stack.isEmpty() && !stack2.isEmpty()) {
            TreeNode<Integer> peekNode = stack.peek();
            TreeNode<Integer> peekNode2 = stack2.peek();
            TreeNode<Integer> node = getNodeToAdd(peekNode, visited);
            TreeNode<Integer> node2 = getNodeToAdd(peekNode2, visited2);

            if (isLeaf(peekNode) && isLeaf(peekNode2)) {
                TreeNode<Integer> top = stack.pop();
                TreeNode<Integer> top2 = stack2.pop();

                visited.add(top);
                visited2.add(top2);

                if (top.data != top2.data) {
                    return new int[]{top.data, top2.data};
                }
            } else if (isLeaf(peekNode)) {
                pushNodeOrPop(node2, stack2, visited2);
            } else if (isLeaf(peekNode2)) {
                pushNodeOrPop(node, stack, visited);
            } else {
                pushNodeOrPop(node, stack, visited);
                pushNodeOrPop(node2, stack2, visited2);
            }
        }

        return null;
    }

    private void pushNodeOrPop(TreeNode<Integer> node, Stack<TreeNode<Integer>> stack, Set<TreeNode<Integer>> visited) {
        if (node != null) {
            stack.push(node);
        } else {
            visited.add(stack.pop());
        }
    }

    private TreeNode<Integer> getNodeToAdd(TreeNode<Integer> node, Set<TreeNode<Integer>> visited) {
        if (node.left != null && !visited.contains(node.left)) {
            return node.left;
        } else if (node.right != null && !visited.contains(node.right)) {
            return node.right;
        }

        return null;
    }

    private boolean isLeaf(TreeNode<Integer> node) {
        return node.left == null && node.right == null;
    }
}
