package chapter_10;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sudharti on 8/8/17.
 */
public class TestSortedMerge {
    private static final String inputFile = "input_files/chapter_10/sorted_merge/test_case";
    private static String[] input = null;
    private static SortedMerge sortedMerge = null;

    @BeforeClass
    public static void setup() {
        sortedMerge = new SortedMerge();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        sortedMerge = null;
        input = null;
    }

    @Test
    public void testSortedMergeTestCase1() {
        assertSortedMerge(input[0]);
    }

    @Test
    public void testSortedMergeTestCase2() {
        assertSortedMerge(input[1]);
    }

    @Test
    public void testSortedMergeTestCase3() {
        assertSortedMerge(input[2]);
    }

    @Test
    public void testSortedMergeTestCase4() {
        assertSortedMerge(input[3]);
    }

    @Test
    public void testSortedMergeTestCase5() {
        assertSortedMerge(input[4]);
    }

    private void assertSortedMerge(String input) {
        String[] values = input.split("\\|");
        int[] expected = constructArr(values[1]);

        String[] inputValues = values[0].split(":");
        int[] arr1 = constructArr(inputValues[0]);
        int[] arr2 = constructArr(inputValues[2]);
        int m = Integer.parseInt(inputValues[1]);
        int n = Integer.parseInt(inputValues[3]);

        sortedMerge.mergeSorted(arr1, m, arr2, n);
        assertArrayEquals(expected, arr1);
    }

    private int[] constructArr(String str) {
        String[] values = str.split(",");
        int[] arr = new int[values.length];
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(values[i]);
        return arr;
    }
}
