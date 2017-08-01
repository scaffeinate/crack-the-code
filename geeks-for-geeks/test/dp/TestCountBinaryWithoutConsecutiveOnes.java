package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/1/17.
 */
public class TestCountBinaryWithoutConsecutiveOnes {
    private static String inputFile = "input_files/dp/count_binary_without_consecutive_ones/test_case";
    private static CountBinaryWithoutConsecutiveOnes countBinary = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        countBinary = new CountBinaryWithoutConsecutiveOnes();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        countBinary = null;
        input = null;
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase1() {
        String[] values = input[0].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase2() {
        String[] values = input[1].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase3() {
        String[] values = input[2].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase4() {
        String[] values = input[3].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase5() {
        String[] values = input[4].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase6() {
        String[] values = input[5].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    @Test
    public void testCountBinaryWithoutConsecutiveOnesTestCase7() {
        String[] values = input[6].split(" ");
        assertCountBinaryWithoutConsecutiveOnes(values);
    }

    private void assertCountBinaryWithoutConsecutiveOnes(String[] values) {
        int N = Integer.parseInt(values[0]);
        int expected = Integer.parseInt(values[1]);

        assertEquals(expected, countBinary.count(N));
    }
}
