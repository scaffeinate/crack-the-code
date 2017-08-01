package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/1/17.
 */
public class TestMaximumSumNonAdjacent {
    private static String inputFile = "input_files/dp/maximum_sum_non_adjacent/test_case";
    private static MaximumSumNonAdjacent maxSumNonAdj = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        maxSumNonAdj = new MaximumSumNonAdjacent();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        maxSumNonAdj = null;
        input = null;
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase1() {
        String[] values = input[0].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase2() {
        String[] values = input[1].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase3() {
        String[] values = input[2].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase4() {
        String[] values = input[3].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase5() {
        String[] values = input[4].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase6() {
        String[] values = input[5].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumNonAdjacentTestCase7() {
        String[] values = input[6].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    private void assertMaxSumIncreasingSubseq(String[] values) {
        int expected = Integer.parseInt(values[1]);
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(expected, maxSumNonAdj.maxSum(arr));
        assertEquals(expected, maxSumNonAdj.maxSumBottomUp(arr));
    }
}
