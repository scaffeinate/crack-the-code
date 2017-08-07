package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudharti on 8/6/17.
 */
public class MultiTreeNode {
    public int val = 0;
    public List<MultiTreeNode> children;

    public MultiTreeNode() {
        this(0, new ArrayList<>());
    }

    public MultiTreeNode(int val) {
        this(val, new ArrayList<>());
    }

    public MultiTreeNode(int val, List<MultiTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
