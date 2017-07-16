package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMaximumSumIncreasingSubsequence {
    private static String inputFile = "input_files/dp/maximum_sum_increasing_subsequence/test_case";
    private static MaximumSumIncreasingSubsequence maxSumIncreasingSubsequence = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        maxSumIncreasingSubsequence = new MaximumSumIncreasingSubsequence();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        maxSumIncreasingSubsequence = null;
        input = null;
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase1() {
        String[] values = input[0].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase2() {
        String[] values = input[1].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase3() {
        String[] values = input[2].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase4() {
        String[] values = input[3].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase5() {
        String[] values = input[4].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    @Test
    public void testMaximumSumIncreasingSubsequenceTestCase6() {
        String[] values = input[5].split(" ");
        assertMaxSumIncreasingSubseq(values);
    }

    private void assertMaxSumIncreasingSubseq(String[] values) {
        int expected = Integer.parseInt(values[1]);
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(expected, maxSumIncreasingSubsequence.maximumSum(arr));
        assertEquals(expected, maxSumIncreasingSubsequence.maximumSumTopDown(arr));
    }
}
