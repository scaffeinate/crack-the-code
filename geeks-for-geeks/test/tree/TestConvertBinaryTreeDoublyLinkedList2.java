package tree;


import datastructures.tree.TreeNode;
import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 6/3/17.
 */
public class TestConvertBinaryTreeDoublyLinkedList2 {
    private static final String basePath = "input_files/tree/convert_binary_tree_doubly_linked_list/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static ConvertBinaryTreeDoublyLinkedList2 convertBinaryTreeDoublyLinkedList2 = null;

    @BeforeClass
    public static void setup() {
        convertBinaryTreeDoublyLinkedList2 = new ConvertBinaryTreeDoublyLinkedList2();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        convertBinaryTreeDoublyLinkedList2 = null;
        inputList = null;
    }

    @Test
    public void testConvertBinaryTreeDoublyLinkedList2TestCase1() {
        String[] input = inputList.get(0);
        int[] expected = new int[]{25, 12, 30, 10, 36, 15};
        assertConvertBinaryTreeDoublyLinkedList2(input, expected);
    }

    @Test
    public void testConvertBinaryTreeDoublyLinkedList2BinaryTreeTestCase2() {
        String[] input = inputList.get(1);
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertConvertBinaryTreeDoublyLinkedList2(input, expected);
    }

    @Test
    public void testConvertBinaryTreeDoublyLinkedListBinaryTreeTestCase3() {
        String[] input = inputList.get(2);
        int[] expected = new int[]{1, 4, 6, 7, 3, 8, 10, 13, 14};
        assertConvertBinaryTreeDoublyLinkedList2(input, expected);
    }

    private void assertConvertBinaryTreeDoublyLinkedList2(String[] input, int[] expected) {
        convertBinaryTreeDoublyLinkedList2.constructTree(input);
        ConvertBinaryTreeDoublyLinkedList2.Wrapper wrapper = convertBinaryTreeDoublyLinkedList2.convert();
        TreeNode<Integer> head = wrapper.head;
        TreeNode<Integer> tail = wrapper.tail;
        int i = 0;

        while (i < expected.length) {
            assertEquals(expected[i], (int) head.data);
            head = head.right;
            i++;
        }

        i = expected.length - 1;
        while (i >= 0) {
            assertEquals(expected[i], (int) tail.data);
            tail = tail.left;
            i--;
        }
    }
}
