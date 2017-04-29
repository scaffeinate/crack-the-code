package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestRotateMatrix {
  private static String inputFile = "input_files/chapter_1/rotate_matrix/test_case";
  private static RotateMatrix rotateMatrix;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    rotateMatrix = new RotateMatrix();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    rotateMatrix = null;
    input = null;
  }

  @Test
  public void testRotateMatrixTestCase1() {
    int[][] expected = new int[][] { new int[] { 1, 7, 9, 0, 2, 1 }, new int[] { 2, 8, 4, 9, 3, 2 },
        new int[] { 7, 0, 5, 8, 1, 4 }, new int[] { 8, 1, 6, 2, 3, 5 }, new int[] { 9, 0, 2, 4, 4, 6 },
        new int[] { 0, 2, 1, 5, 8, 9 } };
    assertRotateMatrix(input, 90, expected);
  }

  @Test
  public void testRotateMatrixTestCase2() {
    int[][] expected = new int[][] { new int[] { 0, 9, 8, 7, 2, 1 }, new int[] { 2, 0, 1, 0, 8, 7 },
        new int[] { 1, 2, 6, 5, 4, 9 }, new int[] { 5, 4, 2, 8, 9, 0 }, new int[] { 8, 4, 3, 1, 3, 2 },
        new int[] { 9, 6, 5, 4, 2, 1 } };
    assertRotateMatrix(input, 540, expected);
  }

  @Test
  public void testRotateMatrixTestCase3() {
    int[][] expected = new int[][] { new int[] { 9, 8, 5, 1, 2, 0 }, new int[] { 6, 4, 4, 2, 0, 9 },
        new int[] { 5, 3, 2, 6, 1, 8 }, new int[] { 4, 1, 8, 5, 0, 7 }, new int[] { 2, 3, 9, 4, 8, 2 },
        new int[] { 1, 2, 0, 9, 7, 1 } };
    assertRotateMatrix(input, 630, expected);
  }

  private void assertRotateMatrix(String[] input, int degrees, int[][] expected) {
    int[][] matrix;
    int n = input.length;

    matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] row = input[i].split(" ");
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }

    int[][] output = rotateMatrix.rotate(matrix, degrees);
    assertEquals(expected.length, output.length);

    for (int i = 0; i < expected.length; i++) {
      for (int j = 0; j < expected[0].length; j++) {
        assertEquals(expected[i][j], output[i][j]);
      }
    }
  }
}