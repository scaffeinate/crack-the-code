package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestStringRotation {
    private static String inputFile = "input_files/chapter_1/string_rotation/test_case";
    private static StringRotation stringRotation;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        stringRotation = new StringRotation();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        stringRotation = null;
        input = null;
    }

    @Test
    public void testStringRotationTestCase1() {
        assertStringRotation(input[0]);
    }

    @Test
    public void testStringRotationTestCase2() {
        assertStringRotation(input[1]);
    }

    @Test
    public void testStringRotationTestCase3() {
        assertStringRotation(input[2]);
    }

    private void assertStringRotation(String input) {
        String[] values = input.split(" ");
        assertEquals(Boolean.parseBoolean(values[2]), stringRotation.isStringRotation(values[0], values[1]));
    }
}
