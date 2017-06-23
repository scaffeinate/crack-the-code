package array;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import datastructures.util.InputUtil;

public class TestFindMissingNumber {
    private static String inputFile = "input_files/array/find_missing_number/test_case";
    private static FindMissingNumber findMissingNumber;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        findMissingNumber = new FindMissingNumber();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        findMissingNumber = null;
        input = null;
    }

    @Test
    public void testFindMissingNumberTestCase1() {
        assertFindMissingNumber(input[0]);
    }

    @Test
    public void testFindMissingNumberTestCase2() {
        assertFindMissingNumber(input[1]);
    }

    @Test
    public void testFindMissingNumberTestCase3() {
        assertFindMissingNumber(input[2]);
    }

    @Test
    public void testFindMissingNumberTestCase4() {
        assertFindMissingNumber(input[3]);
    }

    private void assertFindMissingNumber(String input) {
        String[] values = input.split(" ");
        String[] stringArr = values[0].split(",");
        String[] stringCopyArr = values[1].split(",");

        int[] arr = new int[stringArr.length];
        int[] copy = new int[stringCopyArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }

        for (int i = 0; i < stringCopyArr.length; i++) {
            copy[i] = Integer.parseInt(stringCopyArr[i]);
        }

        assertEquals(Integer.parseInt(values[2]), findMissingNumber.findNumber(arr, copy));
    }
}
