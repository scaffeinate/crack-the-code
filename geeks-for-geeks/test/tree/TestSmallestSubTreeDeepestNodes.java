package tree;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/6/17.
 */
public class TestSmallestSubTreeDeepestNodes {
    private static final String inputFile = "input_files/tree/smallest_sub_tree_deepest_nodes/test_case";
    private static String[] input = null;
    private static SmallestSubTreeDeepestNodes smallestSubTree = null;

    @BeforeClass
    public static void setup() {
        smallestSubTree = new SmallestSubTreeDeepestNodes();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        input = null;
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase1() {
        assertSmallestSubTreeDeepestNodes(input[0]);
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase2() {
        assertSmallestSubTreeDeepestNodes(input[1]);
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase3() {
        assertSmallestSubTreeDeepestNodes(input[2]);
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase4() {
        assertSmallestSubTreeDeepestNodes(input[3]);
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase5() {
        assertSmallestSubTreeDeepestNodes(input[4]);
    }

    @Test
    public void testSmallestSubTreeDeepestNodesTestCase6() {
        assertSmallestSubTreeDeepestNodes(input[5]);
    }

    private void assertSmallestSubTreeDeepestNodes(String input) {
        String[] values = input.split("\\|");
        MultiTreeNode root = constructTree(values[0]);
        String expected = values[1];
        assertEquals(expected, MultiTree.bfs(smallestSubTree.smallestSubTree(root)));
    }

    private MultiTreeNode constructTree(String input) {
        String[] values = input.split(",");
        Map<Integer, MultiTreeNode> nodesMap = new HashMap<>();

        MultiTree multiTree = new MultiTree();
        int val = Integer.parseInt(values[0]);

        MultiTreeNode root = multiTree.insertRoot(val);
        nodesMap.put(val, root);

        for (int i = 1; i < values.length; i++) {
            String[] temp = values[i].split(":");
            val = Integer.parseInt(temp[1]);
            nodesMap.put(val, multiTree.insert(nodesMap.get(Integer.parseInt(temp[0])), val));
        }

        return root;
    }
}
