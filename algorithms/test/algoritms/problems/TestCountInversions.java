/**
 * 
 */
package algoritms.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.CountInversions;
import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class TestCountInversions {
  private static CountInversions countInversions = null;
  private static final String basePath = "input_files/problems/count_inversions/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    countInversions = new CountInversions();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    countInversions = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testCountInversionsTestCase1() {
    String[] input = inputList.get(0);
    String[] values = input[0].split(" ");
    int[] arr = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    assertEquals(countInversions.countInversions(arr), 36);
    assertEquals(countInversions.countInversions(arr), 36);
  }

  @Test
  public void testCountInversionsTestCase2() {
    String[] input = inputList.get(1);
    String[] values = input[0].split(" ");
    int[] arr = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    assertEquals(countInversions.countInversions(arr), 0);
    assertEquals(countInversions.countInversions(arr), 0);
  }

  @Test
  public void testCountInversionsTestCase3() {
    String[] input = inputList.get(2);
    String[] values = input[0].split(" ");
    int[] arr = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    assertEquals(countInversions.countInversions(arr), 0);
    assertEquals(countInversions.countInversions(arr), 0);
  }

  @Test
  public void testCountInversionsTestCase4() {
    String[] input = inputList.get(3);
    String[] values = input[0].split(" ");
    int[] arr = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }
    assertEquals(countInversions.countInversions(arr), 15);
    assertEquals(countInversions.countInversions(arr), 15);
  }
}
