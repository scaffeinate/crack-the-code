package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestTotalWaysMatrix {

    private static String inputFile = "input_files/dp/total_ways_matrix/test_case";
    ;
    private static String[] input = null;
    private static TotalWaysMatrix totalWaysMatrix = null;

    @BeforeClass
    public static void setup() {
        totalWaysMatrix = new TotalWaysMatrix();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        totalWaysMatrix = null;
        input = null;
    }

    @Test
    public void testTotalWaysMatrix1() {
        assertTotalWaysMatrix(input[0]);
    }

    @Test
    public void testTotalWaysMatrix2() {
        assertTotalWaysMatrix(input[1]);
    }

    @Test
    public void testTotalWaysMatrix3() {
        assertTotalWaysMatrix(input[0]);
    }


    private void assertTotalWaysMatrix(String input) {
        String[] inputArr = input.split(" ");
        int m = Integer.parseInt(inputArr[0]);
        int n = Integer.parseInt(inputArr[1]);
        int expected = Integer.parseInt(inputArr[2]);

        assertEquals(expected, totalWaysMatrix.totalWays(m, n));
        assertEquals(expected, totalWaysMatrix.totalWaysBottomUp(m, n));
    }
}
