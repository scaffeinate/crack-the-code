package array;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * Created by sudharti on 6/4/17.
 */
public class TestFindCommonThreeSortedArrays {
    private static String inputFile = "input_files/array/find_common_three_sorted_arrays/test_case";
    private static FindCommonThreeSortedArrays findCommon;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        findCommon = new FindCommonThreeSortedArrays();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        findCommon = null;
        input = null;
    }

    @Test
    public void testFindCommonThreeSortedArraysTestCase1() {
        assertFindCommonThreeSortedArrays(input[0]);
    }

    @Test
    public void testFindCommonThreeSortedArraysTestCase2() {
        assertFindCommonThreeSortedArrays(input[1]);
    }

    private void assertFindCommonThreeSortedArrays(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        String[] arr2Values = values[1].split(",");
        String[] arr3Values = values[2].split(",");
        String[] expectedValues = values[3].split(",");

        Integer[] arr = convertStringArrToIntArr(arrValues);
        Integer[] arr2 = convertStringArrToIntArr(arr2Values);
        Integer[] arr3 = convertStringArrToIntArr(arr3Values);
        Integer[] expected = convertStringArrToIntArr(expectedValues);

        List<Integer> actual = findCommon.findCommon(arr, arr2, arr3);
        assertThat(actual, contains(expected));
    }

    private Integer[] convertStringArrToIntArr(String[] values) {
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        return arr;
    }
}
