package binarytree;

import java.util.HashMap;
import java.util.Map;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

/**
 * Question:
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 *
 * @author Sudharsanan Muralidharan
 */
public class LCABinaryTree {
    private BinaryTree<Integer> tree = null;
    private Map<Integer, TreeNode<Integer>> nodesMap = null;
    private TreeNode<Integer> root = null;

    public LCABinaryTree() {
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

    public TreeNode<Integer> lca(int nodeData, int node2Data) {
        return lca(root, nodeData, node2Data);
    }

    private TreeNode<Integer> lca(TreeNode<Integer> root, Integer nodeData, Integer node2Data) {
        if (root != null) {
            TreeNode<Integer> leftNode = lca(root.left, nodeData, node2Data);
            TreeNode<Integer> rightNode = lca(root.right, nodeData, node2Data);

            if ((leftNode != null && rightNode != null) || (root.data == nodeData || root.data == node2Data)) {
                return root;
            } else if (leftNode != null || rightNode != null) {
                return (leftNode != null) ? leftNode : rightNode;
            }
        }
        return null;
    }

}
