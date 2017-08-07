package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import datastructures.tree.BinaryTree;
import datastructures.tree.TreeNode;

public class FullNodesInBinaryTree {
    private BinaryTree<Integer> tree = null;
    private Map<Integer, TreeNode<Integer>> nodesMap = null;
    private TreeNode<Integer> root = null;

    public FullNodesInBinaryTree() {
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

    public List<Integer> getFullNodes() {
        List<Integer> fullNodesList = new ArrayList<Integer>();
        getFullNodesDFS(root, fullNodesList);
        return fullNodesList;
    }

    public List<Integer> getFullNodes2() {
        List<Integer> fullNodesList = new ArrayList<Integer>();
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> current = queue.poll();
            if (current.left != null && current.right != null) {
                fullNodesList.add(current.data);
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return fullNodesList;
    }

    private void getFullNodesDFS(TreeNode<Integer> root, List<Integer> fullNodesList) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            fullNodesList.add(root.data);
        }

        getFullNodesDFS(root.left, fullNodesList);
        getFullNodesDFS(root.right, fullNodesList);
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
}
