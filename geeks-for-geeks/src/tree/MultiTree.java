package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sudharti on 8/6/17.
 */
public class MultiTree {
    MultiTreeNode root = null;

    public MultiTreeNode insertRoot(int val) {
        this.root = new MultiTreeNode(val);
        return root;
    }

    public MultiTreeNode insert(MultiTreeNode parent, int val) {
        MultiTreeNode node = null;
        if (parent != null) {
            node = new MultiTreeNode(val);
            parent.children.add(node);
        }
        return node;
    }

    public static String bfs(MultiTreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<MultiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            MultiTreeNode current = queue.poll();
            builder.append(current.val);
            List<MultiTreeNode> children = current.children;
            for (MultiTreeNode child : children) {
                queue.offer(child);
            }
            builder.append(",");
        }

        return builder.substring(0, builder.length() - 1).toString();
    }
}
