package array;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestSumOfDistinctInArray {
    private static String inputFile = "input_files/array/sum_of_distinct_in_array/test_case";
    private static SumOfDistinctInArray sumDistinct;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        sumDistinct = new SumOfDistinctInArray();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        sumDistinct = null;
        input = null;
    }

    @Test
    public void testSumDistinctInArrayTestCase1() {
        assertSumDistinct(input[0]);
    }

    @Test
    public void testSumDistinctInArrayTestCase2() {
        assertSumDistinct(input[1]);
    }

    @Test
    public void testSumDistinctInArrayTestCase3() {
        assertSumDistinct(input[2]);
    }

    @Test
    public void testSumDistinctInArrayTestCase4() {
        assertSumDistinct(input[3]);
    }

    private void assertSumDistinct(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(Integer.parseInt(values[1]), sumDistinct.getSum(arr));
        assertEquals(Integer.parseInt(values[1]), sumDistinct.getSum2(arr));
        assertEquals(Integer.parseInt(values[1]), sumDistinct.getSum3(arr));
    }
}
