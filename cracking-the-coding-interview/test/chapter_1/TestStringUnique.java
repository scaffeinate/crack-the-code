package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestStringUnique {
    private static String inputFile = "input_files/chapter_1/string_unique/test_case";
    private static StringUnique stringUnique;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        stringUnique = new StringUnique();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        stringUnique = null;
        input = null;
    }

    @Test
    public void testStringUniqueTestCase1() {
        assertStringUnique(input[0]);
    }

    @Test
    public void testStringUniqueTestCase2() {
        assertStringUnique(input[1]);
    }

    @Test
    public void testStringUniqueTestCase3() {
        assertStringUnique(input[2]);
    }

    private void assertStringUnique(String input) {
        String[] values = input.split(",");
        String word = values[0].toLowerCase().replaceAll(" ", "");
        assertEquals(Boolean.parseBoolean(values[1]), stringUnique.checkUniqueChars(word));
        assertEquals(Boolean.parseBoolean(values[1]), stringUnique.checkUniqueCharsSorted(word));
        assertEquals(Boolean.parseBoolean(values[1]), stringUnique.checkUniqueCharsArray(word));
        assertEquals(Boolean.parseBoolean(values[1]), stringUnique.checkUniqueCharsBits(word));
        assertEquals(Boolean.parseBoolean(values[1]), stringUnique.checkUniqueCharsSet(word));
    }
}
