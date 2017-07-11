package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestRodCutting {
    private static final String inputFile = "input_files/dp/rod_cutting/test_case";
    private static String[] input = null;
    private static RodCutting rodCutting = null;

    @BeforeClass
    public static void setup() {
        rodCutting = new RodCutting();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        rodCutting = null;
        input = null;
    }

    @Test
    public void testRodCuttingTestCase1() {
        String[] values = input[0].split(" ");
        assertRodCutting(values);
    }

    @Test
    public void testRodCuttingTestCase2() {
        String[] values = input[1].split(" ");
        assertRodCutting(values);
    }

    @Test
    public void testRodCuttingTestCase3() {
        String[] values = input[2].split(" ");
        assertRodCutting(values);
    }

    @Test
    public void testRodCuttingTestCase4() {
        String[] values = input[3].split(" ");
        assertRodCutting(values);
    }

    @Test
    public void testRodCuttingTestCase5() {
        String[] values = input[4].split(" ");
        assertRodCutting(values);
    }


    private void assertRodCutting(String[] values) {
        Map<Integer, Integer> costsMap = new HashMap<Integer, Integer>();
        for (int i = 2; i < values.length; i++) {
            String[] inputArr = values[i].split(",");
            costsMap.put(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
        }

        int n = Integer.parseInt(values[0]);
        int expected = Integer.parseInt(values[1]);

        assertEquals(expected, rodCutting.maxProfit(costsMap, n));
        assertEquals(expected, rodCutting.maxProfitTopDown(costsMap, n));
    }
}
