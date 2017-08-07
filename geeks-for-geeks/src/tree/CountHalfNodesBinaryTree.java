package tree;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Question:
 * http://www.geeksforgeeks.org/count-half-nodes-in-a-binary-tree-iterative-and-recursive/
 *
 * @author Sudharsanan Muralidharan
 */
public class CountHalfNodesBinaryTree {
    private BinaryTree<Integer> tree = null;
    private Map<Integer, TreeNode<Integer>> nodesMap = null;
    private TreeNode<Integer> root = null;

    public CountHalfNodesBinaryTree() {
        tree = new BinaryTree<Integer>();
        nodesMap = new HashMap<Integer, TreeNode<Integer>>();
    }

    public void constructTree(String[] input) {
        for (String line : input) {
            String[] values = line.split(" ");
            int val = 0;
            switch (values[0]) {
                case "insertRoot":
                    val = Integer.parseInt(values[1]);
                    TreeNode<Integer> root = tree.insertRoot(val);
                    if (root != null) {
                        nodesMap.put(val, root);
                        this.root = root;
                    }
                    break;
                case "insertLeft":
                    insert(values[1], values[2], true);
                    break;
                case "insertRight":
                    insert(values[1], values[2], false);
                    break;
            }
        }
    }

    private void insert(String parentStr, String nodeStr, boolean isLeft) {
        int parentVal = Integer.parseInt(parentStr);
        int nodeVal = Integer.parseInt(nodeStr);
        TreeNode<Integer> parentNode = nodesMap.get(parentVal);
        if (parentNode == null) {
            return;
        }

        TreeNode<Integer> node = new TreeNode<Integer>(nodeVal);
        nodesMap.put(nodeVal, tree.insert(parentNode, node, isLeft));
    }

    public int countHalfNodes() {
        return countHalfNodes(root);
    }

    public int countHalfNodesIterative() {
        int count = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();
            boolean halfNode = false;

            if (current.left != null) {
                queue.add(current.left);
                halfNode = !halfNode;
            }

            if (current.right != null) {
                queue.add(current.right);
                halfNode = !halfNode;
            }

            count += halfNode ? 1 : 0;
        }

        return count;
    }

    private int countHalfNodes(TreeNode<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        } else {
            int numHalfNodes = (root.left == null || root.right == null) ? 1 : 0;
            return countHalfNodes(root.left) + countHalfNodes(root.right) + numHalfNodes;
        }
    }
}
