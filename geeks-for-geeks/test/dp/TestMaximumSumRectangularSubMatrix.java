package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/1/17.
 */
public class TestMaximumSumRectangularSubMatrix {
    private static String inputFile = "input_files/dp/maximum_sum_rectangular_sub_matrix/test_case";
    private static MaximumSumRectangularSubMatrix maxSumRectSubMatrix = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        maxSumRectSubMatrix = new MaximumSumRectangularSubMatrix();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        maxSumRectSubMatrix = null;
        input = null;
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase1() {
        String[] values = input[0].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase2() {
        String[] values = input[1].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase3() {
        String[] values = input[2].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase4() {
        String[] values = input[3].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase5() {
        String[] values = input[4].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    @Test
    public void testMaximumSumRectangularSubMatrixTestCase6() {
        String[] values = input[5].split(" ");
        assertMaxSumRectangularSubMatrix(values);
    }

    private void assertMaxSumRectangularSubMatrix(String[] values) {
        int expected = Integer.parseInt(values[1]);
        String[] arrValues = values[0].split(",");
        int[][] matrix = new int[arrValues.length][];

        for (int i = 0; i < arrValues.length; i++) {
            String[] elements = arrValues[i].split(":");
            int[] row = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                row[j] = Integer.parseInt(elements[j]);
            }
            matrix[i] = row;
        }

        assertEquals(expected, maxSumRectSubMatrix.maximumSum(matrix));
    }
}
