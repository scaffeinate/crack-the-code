package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMatrixMultiplication {
    private static String inputFile = "input_files/dp/matrix_multiplication/test_case";
    private static MatrixMultiplication matrixMul = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        matrixMul = new MatrixMultiplication();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        matrixMul = null;
        input = null;
    }

    @Test
    public void testMatrixMultiplicationTestCase1() {
        String[] values = input[0].split(" ");
        assertMatrixMultiplication(values);
    }

    @Test
    public void testMatrixMultiplicationTestCase2() {
        String[] values = input[1].split(" ");
        assertMatrixMultiplication(values);
    }

    @Test
    public void testMatrixMultiplicationTestCase3() {
        String[] values = input[2].split(" ");
        assertMatrixMultiplication(values);
    }

    @Test
    public void testMatrixMultiplicationTestCase4() {
        String[] values = input[3].split(" ");
        assertMatrixMultiplication(values);
    }

    @Test
    public void testMatrixMultiplicationTestCase5() {
        String[] values = input[4].split(" ");
        assertMatrixMultiplication(values);
    }

    private void assertMatrixMultiplication(String[] values) {
        int[][] matrix = new int[values.length - 1][2];

        for (int i = 0; i < values.length - 1; i++) {
            String[] temp = values[i].split(",");
            matrix[i][0] = Integer.parseInt(temp[0]);
            matrix[i][1] = Integer.parseInt(temp[1]);
        }

        assertEquals(Integer.parseInt(values[values.length - 1]), matrixMul.minOperations(matrix));
    }
}
