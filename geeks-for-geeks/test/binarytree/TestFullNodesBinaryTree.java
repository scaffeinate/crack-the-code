package binarytree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestFullNodesBinaryTree {
    private static final String basePath = "input_files/binarytree/full_nodes/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static FullNodesInBinaryTree fullNodesBinaryTree = null;

    @BeforeClass
    public static void setup() {
        fullNodesBinaryTree = new FullNodesInBinaryTree();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        fullNodesBinaryTree = null;
        inputList = null;
    }

    @Test
    public void testFullNodesBinaryTreeTestCase1() {
        String[] input = inputList.get(0);
        Integer[] expected = new Integer[]{10, 8};
        assertFullNodes(input, expected);
    }

    @Test
    public void testFullNodesBinaryTreeTestCase2() {
        String[] input = inputList.get(1);
        Integer[] expected = new Integer[]{1, 3};
        assertFullNodes(input, expected);
    }

    @Test
    public void testFullNodesBinaryTreeTestCase3() {
        String[] input = inputList.get(2);
        Integer[] expected = new Integer[]{};
        assertFullNodes(input, expected);
    }

    @Test
    public void testFullNodesBinaryTreeTestCase4() {
        String[] input = inputList.get(3);
        Integer[] expected = new Integer[]{};
        assertFullNodes(input, expected);
    }

    private void assertFullNodes(String[] input, Integer[] expected) {
        fullNodesBinaryTree.constructTree(input);
        List<Integer> output = fullNodesBinaryTree.getFullNodes();
        assertThat(Arrays.asList(expected), containsInAnyOrder(output.toArray()));
        output = fullNodesBinaryTree.getFullNodes2();
        assertThat(Arrays.asList(expected), containsInAnyOrder(output.toArray()));
    }
}
