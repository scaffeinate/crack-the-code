package binarytree;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;
import datastructures.tree.BinaryTree;

public class TestNonMatchingLeavesBinaryTree {
    private static final String basePath = "input_files/binarytree/non_matching_leaves/";
    private static String[] testCases = new String[]{"test_case_1.1", "test_case_1.2", "test_case_2.1", "test_case_2.2",
            "test_case_3.1", "test_case_3.2"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static NonMatchingLeavesBinaryTree nonMatchingLeaves = null;

    @BeforeClass
    public static void setup() {
        nonMatchingLeaves = new NonMatchingLeavesBinaryTree();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        nonMatchingLeaves = null;
        inputList = null;
    }

    @Test
    public void testNonMatchingLeavesBinaryTreeTestCase1() {
        String[] input = inputList.get(0);
        String[] input2 = inputList.get(1);
        int[] expected = new int[]{11, 15};
        assertNonMatchingLeavesBinaryTree(input, input2, expected);
    }

    @Test
    public void testNonMatchingLeavesBinaryTreeTestCase2() {
        String[] input = inputList.get(2);
        String[] input2 = inputList.get(3);
        int[] expected = null;
        assertNonMatchingLeavesBinaryTree(input, input2, expected);
    }

    @Test
    public void testNonMatchingLeavesBinaryTreeTestCase3() {
        String[] input = inputList.get(4);
        String[] input2 = inputList.get(5);
        int[] expected = new int[]{14, 11};
        assertNonMatchingLeavesBinaryTree(input, input2, expected);
    }

    private void assertNonMatchingLeavesBinaryTree(String[] input, String[] input2, int[] expected) {
        BinaryTree<Integer> tree = nonMatchingLeaves.constructTree(input);
        BinaryTree<Integer> tree2 = nonMatchingLeaves.constructTree(input2);

        assertArrayEquals(expected, nonMatchingLeaves.findNonMatchingLeaves(tree, tree2));
        assertArrayEquals(expected, nonMatchingLeaves.findNonMatchingLeaves2(tree, tree2));
    }
}
