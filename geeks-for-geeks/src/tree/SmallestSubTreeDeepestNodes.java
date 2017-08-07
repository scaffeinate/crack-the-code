package tree;

import java.util.List;

/**
 * Question: https://www.glassdoor.com/Interview/Find-the-shortest-subtree-that-consist-of-all-the-deepest-nodes-The-tree-is-not-binary-QTN_1409104.htm
 */
public class SmallestSubTreeDeepestNodes {
    public MultiTreeNode smallestSubTree(MultiTreeNode root) {
        int maxHeight = maxHeight(root) - 1;
        return smallestSubTree(root, 0, maxHeight);
    }

    private int maxHeight(MultiTreeNode root) {
        if (root == null) return 0;
        int max = 0;
        List<MultiTreeNode> children = root.children;
        for (MultiTreeNode child : children) {
            max = Math.max(max, maxHeight(child));
        }
        return max + 1;
    }

    private MultiTreeNode smallestSubTree(MultiTreeNode root, int currentHeight, int maxHeight) {
        if (root == null) return null;
        if (currentHeight == maxHeight) return root;
        List<MultiTreeNode> children = root.children;
        int count = 0;
        MultiTreeNode result = null;
        for (MultiTreeNode child : children) {
            MultiTreeNode res = smallestSubTree(child, currentHeight + 1, maxHeight);
            if (res != null) {
                count++;
                result = res;
            }
        }

        return (count == 0) ? null : ((count > 1) ? root : result);
    }
}
