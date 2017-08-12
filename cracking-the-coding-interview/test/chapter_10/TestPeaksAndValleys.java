package chapter_10;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by sudharti on 8/12/17.
 */
public class TestPeaksAndValleys {
    private static final String inputFile = "input_files/chapter_10/peaks_and_valleys/test_case";
    private static String[] input = null;
    private static PeaksAndValleys peaksAndValleys = null;

    @BeforeClass
    public static void setup() {
        peaksAndValleys = new PeaksAndValleys();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        peaksAndValleys = null;
        input = null;
    }

    @Test
    public void testPeaksAndValleysTestCase1() {
        assertPeaksAndValleys(input[0]);
    }

    @Test
    public void testPeaksAndValleysTestCase2() {
        assertPeaksAndValleys(input[1]);
    }

    @Test
    public void testPeaksAndValleysTestCase3() {
        assertPeaksAndValleys(input[2]);
    }

    @Test
    public void testPeaksAndValleysTestCase4() {
        assertPeaksAndValleys(input[3]);
    }

    @Test
    public void testPeaksAndValleysTestCase5() {
        assertPeaksAndValleys(input[4]);
    }

    @Test
    public void testPeaksAndValleysTestCase6() {
        assertPeaksAndValleys(input[5]);
    }

    @Test
    public void testPeaksAndValleysTestCase7() {
        assertPeaksAndValleys(input[6]);
    }

    @Test
    public void testPeaksAndValleysTestCase8() {
        assertPeaksAndValleys(input[7]);
    }

    @Test
    public void testPeaksAndValleysTestCase9() {
        assertPeaksAndValleys(input[8]);
    }

    @Test
    public void testPeaksAndValleysTestCase10() {
        assertPeaksAndValleys(input[9]);
    }

    @Test
    public void testPeaksAndValleysTestCase11() {
        assertPeaksAndValleys(input[10]);
    }

    @Test
    public void testPeaksAndValleysTestCase12() {
        assertPeaksAndValleys(input[11]);
    }

    private void assertPeaksAndValleys(String input) {
        String[] inputArr = input.split(",");
        int[] nums = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) { nums[i] = Integer.parseInt(inputArr[i]); }
        peaksAndValleys.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((i % 2) == 0) {
                assertTrue(((i == 0) ? true : (nums[i] >= nums[i - 1])) &&
                        ((i == nums.length - 1) ? true : (nums[i] >= nums[i + 1])));
            } else {
                assertTrue(((i == 0) ? true : (nums[i] <= nums[i - 1])) &&
                        ((i == nums.length - 1) ? true : (nums[i] <= nums[i + 1])));
            }
        }
    }
}
