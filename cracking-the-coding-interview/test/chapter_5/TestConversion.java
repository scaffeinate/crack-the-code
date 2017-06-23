package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestConversion {
    private static String inputFile = "input_files/chapter_5/conversion/test_case";
    private static Conversion conversion;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        conversion = new Conversion();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        conversion = null;
        input = null;
    }

    @Test
    public void testConversionTestCase() {
        for (String line : input) {
            String[] values = line.split(" ");
            int n = Integer.parseInt(values[0], 2);
            int m = Integer.parseInt(values[1], 2);
            int count = Integer.parseInt(values[2]);
            assertEquals(count, conversion.numConversionBits(n, m));
        }
    }
}
