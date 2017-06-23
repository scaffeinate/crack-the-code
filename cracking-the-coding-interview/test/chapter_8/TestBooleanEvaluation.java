package chapter_8;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 5/24/17.
 */
public class TestBooleanEvaluation {
    private static final String inputFile = "input_files/chapter_8/boolean_evaluation/test_case";
    private static String[] input = null;
    private static BooleanEvaluation booleanEvaluation = null;

    @BeforeClass
    public static void setup() {
        booleanEvaluation = new BooleanEvaluation();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        booleanEvaluation = null;
        input = null;
    }

    @Test
    public void testBooleanEvaluationTestCase1() {
        assertBooleanEvaluation(input[0]);
    }

    @Test
    public void testBooleanEvaluationTestCase2() {
        assertBooleanEvaluation(input[1]);
    }

    @Test
    public void testBooleanEvaluationTestCase3() {
        assertBooleanEvaluation(input[2]);
    }

    @Test
    public void testBooleanEvaluationTestCase4() {
        assertBooleanEvaluation(input[3]);
    }

    @Test
    public void testBooleanEvaluationTestCase5() {
        assertBooleanEvaluation(input[4]);
    }

    private void assertBooleanEvaluation(String input) {
        String[] values = input.split(" ");
        String expression = values[0];
        boolean expected = Boolean.parseBoolean(values[1]);
        int numWays = booleanEvaluation.countWays(expression, expected);
        assertEquals(Integer.parseInt(values[2]), numWays);

        int numWaysMemoized = booleanEvaluation.countWaysMemoized(expression, expected);
        assertEquals(Integer.parseInt(values[2]), numWaysMemoized);
    }
}
