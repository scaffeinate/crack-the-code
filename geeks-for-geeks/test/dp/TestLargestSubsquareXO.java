package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 7/27/17.
 */
public class TestLargestSubsquareXO {
    private static String inputFile = "input_files/dp/largest_subsquare_xo/test_case";
    private static LargestSubsquareXO largestSubsquareXO = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        largestSubsquareXO = new LargestSubsquareXO();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        largestSubsquareXO = null;
        input = null;
    }

    @Test
    public void testLargestSubsquareXOTestCase1() {
        String[] values = input[0].split(" ");
        assertLargestSubsquareXO(values);
    }

    @Test
    public void testLargestSubsquareXOTestCase2() {
        String[] values = input[1].split(" ");
        assertLargestSubsquareXO(values);
    }

    @Test
    public void testLargestSubsquareXOTestCase3() {
        String[] values = input[2].split(" ");
        assertLargestSubsquareXO(values);
    }

    @Test
    public void testLargestSubsquareXOTestCase4() {
        String[] values = input[3].split(" ");
        assertLargestSubsquareXO(values);
    }

    @Test
    public void testLargestSubsquareXOTestCase5() {
        String[] values = input[4].split(" ");
        assertLargestSubsquareXO(values);
    }

    @Test
    public void testLargestSubsquareXOTestCase6() {
        String[] values = input[5].split(" ");
        assertLargestSubsquareXO(values);
    }

    private void assertLargestSubsquareXO(String[] values) {
        String[] arrValues = values[0].split(",");
        char[][] matrix = new char[arrValues.length][arrValues[0].length()];
        int expected = Integer.parseInt(values[1]);

        for (int i = 0; i < arrValues.length; i++) {
            String str = arrValues[i];
            for (int j = 0; j < str.length(); j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        assertEquals(expected, largestSubsquareXO.maxSquare(matrix));
    }
}
