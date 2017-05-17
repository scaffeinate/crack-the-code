package array;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestMimumSumAbsDiffTwoArrays {
  private static String inputFile = "input_files/array/mimum_sum_abs_diff/test_case";
  private static MinimumSumAbsDiffTwoArrays minimumSum;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    minimumSum = new MinimumSumAbsDiffTwoArrays();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    minimumSum = null;
    input = null;
  }
  
  @Test
  public void testMinimumSumAbsDiffTwoArraysTestCase1() {
    assertMinimumSumAbsDiff(input[0]);
  }

  @Test
  public void testMinimumSumAbsDiffTwoArraysTestCase2() {
    assertMinimumSumAbsDiff(input[1]);
  }

  @Test
  public void testMinimumSumAbsDiffTwoArraysTestCase3() {
    assertMinimumSumAbsDiff(input[2]);
  }

  @Test
  public void testMinimumSumAbsDiffTwoArraysTestCase4() {
    assertMinimumSumAbsDiff(input[3]);
  }
  
  private void assertMinimumSumAbsDiff(String input) {
    String[] values = input.split(" ");
    String[] arrValues = values[0].split(",");
    int[] a = new int[arrValues.length];
    for (int i = 0; i < arrValues.length; i++) {
      a[i] = Integer.parseInt(arrValues[i]);
    }
    
    arrValues = values[1].split(",");
    int[] b = new int[arrValues.length];
    for (int i = 0; i < arrValues.length; i++) {
      b[i] = Integer.parseInt(arrValues[i]);
    }
    
    assertEquals(Integer.parseInt(values[2]), minimumSum.getMinimumSum(a, b));
  }
}
