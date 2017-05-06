package random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import algorithms.util.InputUtil;

public class TestCircularMatrix {
  private static String inputFile = "input_files/random/circular_matrix/test_case";
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    input = null;
  }

  @Test
  public void testCircularMatrixTestCase1() {
    String[] values = input[0].split(" ");
    assertCircularMatrix(values, new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 12, 13, 14, 5 },
        new int[] { 11, 16, 15, 6 }, new int[] { 10, 9, 8, 7 } });
  }

  @Test
  public void testCircularMatrixTestCase2() {
    String[] values = input[1].split(" ");
    assertCircularMatrix(values,
        new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 10, 11, 12, 5 }, new int[] { 9, 8, 7, 6 } });
  }

  @Test
  public void testCircularMatrixTestCase3() {
    String[] values = input[2].split(" ");
    assertCircularMatrix(values, new int[][] { new int[] { 1 } });
  }

  @Test
  public void testCircularMatrixTestCase4() {
    String[] values = input[3].split(" ");
    assertCircularMatrix(values,
        new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 24, 25, 26, 5 }, new int[] { 23, 40, 27, 6 },
            new int[] { 22, 39, 28, 7 }, new int[] { 21, 38, 29, 8 }, new int[] { 20, 37, 30, 9 },
            new int[] { 19, 36, 31, 10 }, new int[] { 18, 35, 32, 11 }, new int[] { 17, 34, 33, 12 },
            new int[] { 16, 15, 14, 13 } });
  }

  private void assertCircularMatrix(String[] values, int[][] expected) {
    int m = Integer.parseInt(values[0]);
    int n = Integer.parseInt(values[1]);

    int[][] output = CircularMatrix.constructMatrix(m, n);
    for (int i = 0; i < output.length; i++) {
      assertArrayEquals(expected[i], output[i]);
    }
  }
}
