/**
 * 
 */
package algorithms.sort;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class TestBubbleSort {

  private static String basePath = "input_files/sort/";
  private static BubbleSort<Integer> bubbleSort = null;
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };;
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    bubbleSort = new BubbleSort<Integer>();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    bubbleSort = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testBubbleSortTestCase1() {
    assertResult(inputList.get(0));
  }
  
  @Test
  public void testBubbleSortTestCase2() {
    assertResult(inputList.get(1));
  }
  
  @Test
  public void testBubbleSortTestCase3() {
    assertResult(inputList.get(2));
  }
  
  private void assertResult(String[] input) {
    String line = input[0];
    String[] values = line.split(" ");
    Integer[] arr = new Integer[values.length];
    for (int i = 0; i < values.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Integer[] expected = arr.clone();
    bubbleSort.sort(arr);
    Arrays.sort(expected);

    assertTrue(validateResult(arr, expected));
  }

  private boolean validateResult(Integer[] arr, Integer[] expected) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].intValue() != expected[i].intValue()) {
        return false;
      }
    }

    return true;
  }
}
