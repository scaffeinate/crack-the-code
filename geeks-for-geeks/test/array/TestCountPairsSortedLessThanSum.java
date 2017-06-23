package array;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestCountPairsSortedLessThanSum {
    private static String inputFile = "input_files/array/count_pairs_sorted_less_than_sum/test_case";
    private static CountPairsSortedLessThanSum countPairs;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        countPairs = new CountPairsSortedLessThanSum();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        countPairs = null;
        input = null;
    }

    @Test
    public void testCountPairsSortedLessThanSumTestCase1() {
        assertCountPairsSorted(input[0]);
    }

    @Test
    public void testCountPairsSortedLessThanSumTestCase2() {
        assertCountPairsSorted(input[1]);
    }

    @Test
    public void testCountPairsSortedLessThanSumTestCase3() {
        assertCountPairsSorted(input[2]);
    }

    @Test
    public void testCountPairsSortedLessThanSumTestCase4() {
        assertCountPairsSorted(input[3]);
    }

    private void assertCountPairsSorted(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(Integer.parseInt(values[2]), countPairs.countPairs(arr, Integer.parseInt(values[1])));
        assertEquals(Integer.parseInt(values[2]), countPairs.countPairs2(arr, Integer.parseInt(values[1])));
    }
}
