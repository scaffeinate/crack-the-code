package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestOptimalStrategyGamePicks {
    private static String inputFile = "input_files/dp/optimal_strategy_game_picks/test_case";
    private static String[] input = null;
    private static OptimalStrategyGamePicks optimalStrategy = null;

    @BeforeClass
    public static void setup() {
        optimalStrategy = new OptimalStrategyGamePicks();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        optimalStrategy = null;
        input = null;
    }

    @Test
    public void testOptimalStrategyGamePicksTestCase1() {
        assertOptimalStrategyGamePicks(input[0]);
    }

    @Test
    public void testOptimalStrategyGamePicksTestCase2() {
        assertOptimalStrategyGamePicks(input[1]);
    }

    @Test
    public void testOptimalStrategyGamePicksTestCase3() {
        assertOptimalStrategyGamePicks(input[2]);
    }

    @Test
    public void testOptimalStrategyGamePicksTestCase4() {
        assertOptimalStrategyGamePicks(input[3]);
    }

    @Test
    public void testOptimalStrategyGamePicksTestCase5() {
        assertOptimalStrategyGamePicks(input[4]);
    }


    private void assertOptimalStrategyGamePicks(String input) {
        String[] inputArr = input.split(" ");
        String[] values = inputArr[0].split(",");
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        assertEquals(Integer.parseInt(inputArr[1]), optimalStrategy.maxValue(nums));
    }
}
