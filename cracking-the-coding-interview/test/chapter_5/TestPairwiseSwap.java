package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestPairwiseSwap {
    private static String inputFile = "input_files/chapter_5/pairwise_swap/test_case";
    private static PairwiseSwap pairwiseSwap;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        pairwiseSwap = new PairwiseSwap();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        pairwiseSwap = null;
        input = null;
    }

    @Test
    public void testPairwiseSwapTestCase() {
        for (String line : input) {
            String[] values = line.split(" ");
            int n = Integer.parseInt(values[0], 2);
            assertEquals(Integer.parseInt(values[1], 2), pairwiseSwap.swap(n));
        }
    }
}
