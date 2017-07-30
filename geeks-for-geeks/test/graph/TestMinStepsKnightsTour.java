package graph;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMinStepsKnightsTour {
    private static String inputFile = "input_files/graph/min_steps_knights_tour/test_case";
    private static MinStepsKnightsTour minStepsKnightsTour = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        minStepsKnightsTour = new MinStepsKnightsTour();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        minStepsKnightsTour = null;
        input = null;
    }

    @Test
    public void testMinStepsKnightsTourTestCase1() {
        String[] values = input[0].split(" ");
        assertMinStepsKnightsTour(values);
    }

    @Test
    public void testMinStepsKnightsTourTestCase2() {
        String[] values = input[1].split(" ");
        assertMinStepsKnightsTour(values);
    }

    @Test
    public void testMinStepsKnightsTourTestCase3() {
        String[] values = input[2].split(" ");
        assertMinStepsKnightsTour(values);
    }

    @Test
    public void testMinStepsKnightsTourTestCase4() {
        String[] values = input[3].split(" ");
        assertMinStepsKnightsTour(values);
    }

    @Test
    public void testMinStepsKnightsTourTestCase5() {
        String[] values = input[4].split(" ");
        assertMinStepsKnightsTour(values);
    }

    @Test
    public void testMinStepsKnightsTourTestCase6() {
        String[] values = input[5].split(" ");
        assertMinStepsKnightsTour(values);
    }

    private void assertMinStepsKnightsTour(String[] values) {
        String[] positionStr = values[0].split(",");
        String[] targetStr = values[1].split(",");
        int[] position = {Integer.parseInt(positionStr[0]), Integer.parseInt(positionStr[1])};
        int[] target = {Integer.parseInt(targetStr[0]), Integer.parseInt(targetStr[1])};
        int N = Integer.parseInt(values[2]);

        assertEquals(Integer.parseInt(values[3]), minStepsKnightsTour.minSteps(position, target, N));
    }
}
