package binarytree;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: http://www.geeksforgeeks.org/find-deepest-node-binary-tree/
 */
public class DeepestNodeBinaryTree {

    private BinaryTree<Integer> tree = null;
    private Map<Integer, TreeNode<Integer>> nodesMap = null;

    public DeepestNodeBinaryTree() {
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
                    nodesMap.put(val, tree.insertRoot(val));
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

    public Integer getDeepestNode() {
        return deepestNode(tree.getRoot()).treeNode.data;
    }

    public Integer getDeepestNode2() {
        TreeNodeWrapper<Integer> deepestWrapper = new TreeNodeWrapper<>(tree.getRoot(), 0);
        deepestNode(tree.getRoot(), deepestWrapper, 0);
        return deepestWrapper.treeNode.data;
    }

    private TreeNodeWrapper<Integer> deepestNode(TreeNode<Integer> root) {
        if (root == null) {
            return new TreeNodeWrapper<Integer>(null, -1);
        }

        TreeNodeWrapper<Integer> leftWrapper = deepestNode(root.left);
        TreeNodeWrapper<Integer> rightWrapper = deepestNode(root.right);

        if (leftWrapper.treeNode == null && rightWrapper.treeNode == null) {
            return new TreeNodeWrapper<Integer>(root, 1);
        } else {
            TreeNodeWrapper<Integer> deepestWrapper = (leftWrapper.depth >= rightWrapper.depth) ? leftWrapper : rightWrapper;
            deepestWrapper.depth += 1;
            return deepestWrapper;
        }
    }

    private void deepestNode(TreeNode<Integer> root, TreeNodeWrapper<Integer> deepestWrapper,
                             int depth) {
        if (root == null) {
            return;
        }

        deepestNode(root.left, deepestWrapper, depth + 1);
        deepestNode(root.right, deepestWrapper, depth + 1);

        if (deepestWrapper.depth < depth) {
            deepestWrapper.depth = depth;
            deepestWrapper.treeNode = root;
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

    @SuppressWarnings("hiding")
    private class TreeNodeWrapper<Integer> {
        TreeNode<Integer> treeNode = null;
        int depth = 0;

        public TreeNodeWrapper(TreeNode<Integer> treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
