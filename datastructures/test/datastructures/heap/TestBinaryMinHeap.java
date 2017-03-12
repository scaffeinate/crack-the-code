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

public class TestBinaryMinHeap {
  private static final String basePath = "input_files/binary_heap/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private BinaryHeap<Integer> binaryHeap = null;

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
    binaryHeap = new BinaryMinHeap<Integer>(Integer.class);
  }

  @After
  public void teardownTest() {
    binaryHeap = null;
  }

  @Test
  public void testBinaryMinHeapTestCase1() {
    String[] input = inputList.get(0);
    Integer[] expected = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    assertBinaryMinHeap(input, expected);
  }

  @Test
  public void testBinaryMaxHeapTestCase2() {
    String[] input = inputList.get(1);
    Integer[] expected = new Integer[] { -1, -1, -1, -1, 0, 0, 0, 0 };
    assertBinaryMinHeap(input, expected);
  }

  private void assertBinaryMinHeap(String[] input, Integer[] expected) {
    List<Integer> actual = new ArrayList<Integer>();
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "insert":
        binaryHeap.insert(Integer.parseInt(values[1]));
        break;
      case "extractAll":
        while (!binaryHeap.isEmpty()) {
          actual.add(binaryHeap.extract());
        }
        break;
      }
    }

    assertThat(actual, hasSize(expected.length));
    assertThat(actual, contains(expected));
  }
}
