package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSubsetSum {
    private static String inputFile = "input_files/dp/subset_sum/test_case";
    private static SubsetSum subsetSum = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        subsetSum = new SubsetSum();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        subsetSum = null;
        input = null;
    }

    @Test
    public void testFibonacciNumberTestCase1() {
        String[] values = input[0].split(" ");
        assertSubsetSum(values);
    }

    @Test
    public void testFibonacciNumberTestCase2() {
        String[] values = input[1].split(" ");
        assertSubsetSum(values);
    }

    @Test
    public void testFibonacciNumberTestCase3() {
        String[] values = input[2].split(" ");
        assertSubsetSum(values);
    }

    @Test
    public void testFibonacciNumberTestCase4() {
        String[] values = input[3].split(" ");
        assertSubsetSum(values);
    }

    @Test
    public void testFibonacciNumberTestCase5() {
        String[] values = input[4].split(" ");
        assertSubsetSum(values);
    }

    private void assertSubsetSum(String[] values) {
        int n = Integer.parseInt(values[0]);
        String[] arr = values[1].split(",");

        int[] set = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            set[i] = Integer.parseInt(arr[i]);
        }
        boolean expected = Boolean.parseBoolean(values[2]);
        assertEquals(expected, subsetSum.subsetSum(n, set));
        assertEquals(expected, subsetSum.subsetSumDP(n, set));

    }
}
