package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestBitonicSubsequence {
    private static String inputFile = "input_files/dp/longest_bitonic_subsequence/test_case";
    private static LongestBitonicSubsequence longestBitonicSubsequence = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        longestBitonicSubsequence = new LongestBitonicSubsequence();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        longestBitonicSubsequence = null;
        input = null;
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase1() {
        String[] values = input[0].split(" ");
        assertLIS(values);
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase2() {
        String[] values = input[1].split(" ");
        assertLIS(values);
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase3() {
        String[] values = input[2].split(" ");
        assertLIS(values);
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase4() {
        String[] values = input[3].split(" ");
        assertLIS(values);
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase5() {
        String[] values = input[4].split(" ");
        assertLIS(values);
    }

    @Test
    public void testLongestBitonicSubsequenceTestCase6() {
        String[] values = input[5].split(" ");
        assertLIS(values);
    }

    private void assertLIS(String[] values) {
        int expected = Integer.parseInt(values[1]);
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(expected, longestBitonicSubsequence.longest(arr));
    }
}
