package chapter_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestZeroMatrix {
  private static String basePath = "input_files/chapter_1/zero_matrix/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static ZeroMatrix zeroMatrix = new ZeroMatrix();
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    zeroMatrix = null;
    inputList = null;
  }

  @Test
  public void testZeroMatrixTestCase1() {
    String[] input = inputList.get(0);
    int[][] expected = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 1, 2, 0, 5, 0, 3 }, { 4, 4, 0, 2, 0, 4 },
        { 0, 0, 0, 0, 0, 0 } };
    assertZeroMatrix(input, expected);
  }

  @Test
  public void testZeroMatrixTestCase2() {
    String[] input = inputList.get(1);
    int[][] expected = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
    assertZeroMatrix(input, expected);
  }

  @Test
  public void testZeroMatrixTestCase3() {
    String[] input = inputList.get(2);
    int[][] expected = { { 0, 0, 0, 0, 0 }, { 0, 7, 8, 9, 1 }, { 0, 8, 7, 3, 1 } };
    assertZeroMatrix(input, expected);
  }

  private void assertZeroMatrix(String[] input, int[][] expected) {
    int m = 0, n = 0;
    m = input.length;
    n = input[0].split(" ").length;

    int[][] matrix = new int[m][n];

    for (int i = 0; i < m; i++) {
      String[] row = input[i].split(" ");
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }

    int[][] copy = deepCopy(matrix);
    zeroMatrix.constructZeroMatrix(copy, m, n);
    assertArrays(copy, expected);
    
    copy = deepCopy(matrix);
    zeroMatrix.constructZeroMatrix2(copy, m, n);
    assertArrays(copy, expected);
    
    copy = deepCopy(matrix);
    zeroMatrix.constructZeroMatrix3(copy, m, n);
    assertArrays(copy, expected);
  }
  
  private void assertArrays(int[][] original, int[][] expected) {
    assertEquals(expected.length, original.length);

    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i].length, original[i].length);
      assertArrayEquals(expected[i], original[i]);
    }
  }

  private int[][] deepCopy(int[][] matrix) {
    int[][] copy = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        copy[i][j] = matrix[i][j];
      }
    }
    
    return copy;
  }
}
