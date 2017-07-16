package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMinJumpsToEnd {
    private static String inputFile = "input_files/dp/min_jumps_to_end/test_case";
    ;
    private static String[] input = null;
    private static MinJumpsToEnd minJumpsToEnd = null;

    @BeforeClass
    public static void setup() {
        minJumpsToEnd = new MinJumpsToEnd();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        minJumpsToEnd = null;
        input = null;
    }

    @Test
    public void testMinJumpsToEndTestCase1() {
        assertMinJumpsToEnd(input[0]);
    }

    @Test
    public void testMinJumpsToEndTestCase2() {
        assertMinJumpsToEnd(input[1]);
    }

    @Test
    public void testMinJumpsToEndTestCase3() {
        assertMinJumpsToEnd(input[2]);
    }

    @Test
    public void testMinJumpsToEndTestCase4() {
        assertMinJumpsToEnd(input[3]);
    }

    @Test
    public void testMinJumpsToEndTestCase5() {
        assertMinJumpsToEnd(input[4]);
    }


    private void assertMinJumpsToEnd(String input) {
        String[] inputArr = input.split(" ");
        String[] values = inputArr[0].split(",");
        int[] nums = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }
        System.out.println(nums.length);

        assertEquals(Integer.parseInt(inputArr[1]), minJumpsToEnd.minJumps(nums));
        assertEquals(Integer.parseInt(inputArr[1]), minJumpsToEnd.minJumpsBottomUp(nums));
    }
}
