package array;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import datastructures.util.InputUtil;

public class TestElementOccursOnce {
    private static String inputFile = "input_files/array/element_occurs_once/test_case";
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        input = null;
    }

    @Test
    public void testElementOccursOnceTestCase1() {
        assertElementOccursOnce(input[0]);
    }

    @Test
    public void testElementOccursOnceTestCase2() {
        assertElementOccursOnce(input[1]);
    }

    @Test
    public void testElementOccursOnceTestCase3() {
        assertElementOccursOnce(input[2]);
    }

    @Test
    public void testElementOccursOnceTestCase4() {
        assertElementOccursOnce(input[3]);
    }

    @Test
    public void testElementOccursOnceTestCase5() {
        assertElementOccursOnce(input[4]);
    }

    private void assertElementOccursOnce(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        int[] arr = new int[arrValues.length];

        for (int i = 0; i < arrValues.length; i++) {
            arr[i] = Integer.parseInt(arrValues[i]);
        }

        assertEquals(Integer.parseInt(values[1]), ElementOccursOnce.findElement(arr));
        assertEquals(Integer.parseInt(values[1]), ElementOccursOnce.findElement2(arr));
    }
}
