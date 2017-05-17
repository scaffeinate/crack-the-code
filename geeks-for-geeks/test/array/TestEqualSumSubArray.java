package array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;
import array.EqualSumSubArrays.Result;

public class TestEqualSumSubArray {
  private static String inputFile = "input_files/array/equal_sum_subarray/test_case";
  private static EqualSumSubArrays equalSumSubArrays;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    equalSumSubArrays = new EqualSumSubArrays();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    equalSumSubArrays = null;
    input = null;
  }

  @Test
  public void testEqualSumSubArraysTestCase1() {
    assertEqualSum(input[0]);
  }

  @Test
  public void testEqualSumSubArraysTestCase2() {
    assertEqualSum(input[1]);
  }

  @Test
  public void testEqualSumSubArraysTestCase3() {
    assertEqualSum(input[2]);
  }

  @Test
  public void testEqualSumSubArraysTestCase4() {
    assertEqualSum(input[3]);
  }

  private void assertEqualSum(String input) {
    String[] values = input.split(" ");
    String[] arrValues = values[0].split(",");
    String[] leftArrValues = values[1].split(",");
    String[] rightArrValues = values[2].split(",");

    int[] arr = new int[arrValues.length];
    int[] leftExpected = new int[leftArrValues.length];
    int[] rightExpected = new int[rightArrValues.length];

    for (int i = 0; i < arrValues.length; i++) {
      arr[i] = Integer.parseInt(arrValues[i]);
    }

    if (values[1].equals("[]")) {
      leftExpected = new int[] {};
    } else {
      for (int i = 0; i < leftArrValues.length; i++) {
        leftExpected[i] = Integer.parseInt(leftArrValues[i]);
      }
    }

    if (values[2].equals("[]")) {
      rightExpected = new int[] {};
    } else {
      for (int i = 0; i < rightArrValues.length; i++) {
        rightExpected[i] = Integer.parseInt(rightArrValues[i]);
      }
    }

    Result result = equalSumSubArrays.subArrays(arr);

    assertArrayEquals(leftExpected, result.leftArr);
    assertArrayEquals(rightExpected, result.rightArr);
  }
}
