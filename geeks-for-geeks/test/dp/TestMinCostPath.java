package dp;


import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMinCostPath {
    private static String inputFile = "input_files/dp/min_cost_path/test_case";
    ;
    private static String[] input = null;
    private static MinCostPath minCostPath = null;

    @BeforeClass
    public static void setup() {
        minCostPath = new MinCostPath();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        minCostPath = null;
        input = null;
    }

    @Test
    public void testMinCostPathTestCase1() {
        assertMinCostPath(input[0]);
    }

    @Test
    public void testMinCostPathTestCase2() {
        assertMinCostPath(input[1]);
    }

    @Test
    public void testMinCostPathTestCase3() {
        assertMinCostPath(input[2]);
    }

    @Test
    public void testMinCostPathTestCase4() {
        assertMinCostPath(input[3]);
    }


    private void assertMinCostPath(String input) {
        String[] inputArr = input.split(" ");
        int[][] matrix = new int[inputArr.length - 2][];
        for (int i = 0; i < inputArr.length - 2; i++) {
            String[] values = inputArr[i].split(",");
            int[] row = new int[values.length];
            for (int j = 0; j < row.length; j++) {
                row[j] = Integer.parseInt(values[j]);
            }
            matrix[i] = row;
        }

        String[] outputValues = inputArr[inputArr.length - 2].split(",");
        int m = Integer.parseInt(outputValues[0]);
        int n = Integer.parseInt(outputValues[1]);
        int expected = Integer.parseInt(inputArr[inputArr.length - 1]);

        assertEquals(expected, minCostPath.minCost(matrix, m, n));
        assertEquals(expected, minCostPath.minCostBottomup(matrix, m, n));
    }
}
