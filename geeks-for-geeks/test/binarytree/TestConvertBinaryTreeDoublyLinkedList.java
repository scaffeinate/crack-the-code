package binarytree;


import datastructures.lists.LinkedListNode;
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
public class TestConvertBinaryTreeDoublyLinkedList {
  private static final String basePath = "input_files/binarytree/convert_binary_tree_doubly_linked_list/";
  private static String[] testCases = new String[]{"test_case_1", "test_case_2"};
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static ConvertBinaryTreeDoublyLinkedList convertBinaryTreeDoublyLinkedList = null;

  @BeforeClass
  public static void setup() {
    convertBinaryTreeDoublyLinkedList = new ConvertBinaryTreeDoublyLinkedList();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    convertBinaryTreeDoublyLinkedList = null;
    inputList = null;
  }

  @Test
  public void testConvertBinaryTreeDoublyLinkedListTestCase1() {
    String[] input = inputList.get(0);
    int[] expected = new int[]{25, 12, 30, 10, 36, 15};
    assertConvertBinaryTreeDoublyLinkedList(input, expected);
  }

  @Test
  public void testConvertBinaryTreeDoublyLinkedListBinaryTreeTestCase2() {
    String[] input = inputList.get(1);
    int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertConvertBinaryTreeDoublyLinkedList(input, expected);
  }

  private void assertConvertBinaryTreeDoublyLinkedList(String[] input, int[] expected) {
    convertBinaryTreeDoublyLinkedList.constructTree(input);
    ConvertBinaryTreeDoublyLinkedList.Wrapper wrapper = convertBinaryTreeDoublyLinkedList.convert();
    LinkedListNode<Integer> head = wrapper.head;
    LinkedListNode<Integer> tail = wrapper.tail;
    int i = 0;

    while (i < expected.length) {
      assertEquals(expected[i], (int) head.data);
      head = head.next;
      i++;
    }

    i = expected.length - 1;
    while (i >= 0) {
      assertEquals(expected[i], (int) tail.data);
      tail = tail.prev;
      i--;
    }
  }
}
