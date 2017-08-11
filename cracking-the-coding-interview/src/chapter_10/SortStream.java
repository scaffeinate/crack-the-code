package chapter_10;

/**
 * Question 10.10
 */
public class SortStream {
    private TreeNodeWithRank root = null;

    public void track(int n) {
        if (this.root == null) {
            this.root = new TreeNodeWithRank(n);
        } else {
            insert(this.root, n);
        }
    }

    public int getRank(int target) {
        return getRank(root, target);
    }

    private TreeNodeWithRank insert(TreeNodeWithRank root, int n) {
        if (root == null) {
            return new TreeNodeWithRank(n);
        } else if (root.value >= n) {
            root.incrementRank();
            root.left = insert(root.left, n);
        } else {
            root.right = insert(root.right, n);
        }

        return root;
    }

    private int getRank(TreeNodeWithRank root, int target) {
        if (root == null) return -1;
        if (root.value == target) {
            return root.getRank();
        } else if (root.value >= target) {
            return getRank(root.left, target);
        } else {
            int rank = getRank(root.right, target);
            return (rank == -1) ? -1 : (1 + root.getRank() + rank);
        }
    }
}
