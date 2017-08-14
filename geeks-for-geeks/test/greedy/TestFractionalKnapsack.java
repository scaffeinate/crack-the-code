package greedy;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/14/17.
 */
public class TestFractionalKnapsack {
    private static String inputFile = "input_files/greedy/fractional_knapsack/test_case";
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
    public void testFractionalKnapsackTestCase1() {
        assertFractionalKnapsack(input[0]);
    }

    @Test
    public void testFractionalKnapsackTestCase2() {
        assertFractionalKnapsack(input[1]);
    }

    @Test
    public void testFractionalKnapsackTestCase3() {
        assertFractionalKnapsack(input[2]);
    }

    @Test
    public void testFractionalKnapsackTestCase4() {
        assertFractionalKnapsack(input[3]);
    }

    @Test
    public void testFractionalKnapsackTestCase5() {
        assertFractionalKnapsack(input[4]);
    }

    private void assertFractionalKnapsack(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        Integer[][] arr = new Integer[arrValues.length][2];

        for (int i = 0; i < arrValues.length; i++) {
            String[] temp = arrValues[i].split(":");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        assertEquals(Double.parseDouble(values[2]), FractionalKnapsack.maxValue(arr, Integer.parseInt(values[1])));
    }
}
