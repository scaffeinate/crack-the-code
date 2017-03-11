package datastructures.heap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestMaxPriorityQueue {
  private static final String basePath = "input_files/max_priority_queue/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private PriorityQueue<Integer, String> priorityQueue = null;

  @BeforeClass
  public static void setup() {
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    testCases = null;
    inputList = null;
  }

  @Before
  public void setupTest() {
    priorityQueue = new PriorityQueue<Integer, String>(HeapType.MAX_HEAP);
  }

  @After
  public void teardownTest() {
    priorityQueue = null;
  }

  @Test
  public void testMaxPriorityQueueTestCase1() {
    String[] input = inputList.get(0);
    String[] expected = new String[] { "merge_sort", "radix_sort", "double_pivoted_quick_sort", "quick_sort",
        "heap_sort", "tree_sort", "insertion_sort", "bubble_sort" };
    assertMaxPriorityQueue(input, expected);
  }

  @Test
  public void testMaxPriorityQueueTestCase2() {
    String[] input = inputList.get(1);
    String[] expected = new String[] {};
    assertMaxPriorityQueue(input, expected);
  }

  @Test
  public void testMaxPriorityQueueTestCase3() {
    String[] input = inputList.get(2);
    String[] expected = new String[] {};
    assertMaxPriorityQueue(input, expected);
  }

  private void assertMaxPriorityQueue(String[] input, String[] expected) {
    List<String> actual = new ArrayList<String>();
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "insert":
        priorityQueue.insert(Integer.parseInt(values[1]), values[2]);
        break;
      case "increaseKey":
        priorityQueue.increaseKey(values[1], Integer.parseInt(values[2]));
        break;
      case "extractAll":
        while (!priorityQueue.isEmpty()) {
          actual.add(priorityQueue.extract().value);
        }
        break;
      }
    }

    assertThat(actual, hasSize(expected.length));
    assertThat(actual, contains(expected));
  }
}
