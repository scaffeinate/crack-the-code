package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 6/21/17.
 */
public class TestOptimalBST {
  private static String inputFile = "input_files/dp/optimal_bst/test_case";
  private static OptimalBST optimalBST = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    optimalBST = new OptimalBST();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    optimalBST = null;
    input = null;
  }

  @Test
  public void testFibonacciNumberTestCase1() {
    String[] values = input[0].split(" ");
    assertOptimalBST(values);
  }

  @Test
  public void testFibonacciNumberTestCase2() {
    String[] values = input[1].split(" ");
    assertOptimalBST(values);
  }

  private void assertOptimalBST(String[] values) {
    String[] keys = values[0].split(",");
    String[] frequencies = values[1].split(",");

    int[] keysArr = new int[keys.length];
    for (int i = 0; i < keys.length; i++) {
      keysArr[i] = Integer.parseInt(keys[i]);
    }

    int[] freqArr = new int[frequencies.length];
    for (int i = 0; i < frequencies.length; i++) {
      freqArr[i] = Integer.parseInt(frequencies[i]);
    }

    int expected = Integer.parseInt(values[2]);
    assertEquals(expected, optimalBST.optimalWeight(keysArr, freqArr));

  }
}
