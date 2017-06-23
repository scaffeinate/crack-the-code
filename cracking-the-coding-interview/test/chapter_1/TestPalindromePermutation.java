package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestPalindromePermutation {
    private static String inputFile = "input_files/chapter_1/palindrome_permutation/test_case";
    private static PalindromePermutation palindromePermutation;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        palindromePermutation = new PalindromePermutation();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        palindromePermutation = null;
        input = null;
    }

    @Test
    public void testPalindromePermutationTestCase1() {
        assertPalindromePermutation(input[0]);
    }

    @Test
    public void testPalindromePermutationTestCase2() {
        assertPalindromePermutation(input[1]);
    }

    @Test
    public void testPalindromePermutationTestCase3() {
        assertPalindromePermutation(input[2]);
    }

    private void assertPalindromePermutation(String input) {
        String[] values = input.split(" ");
        String word = values[0];
        assertEquals(Boolean.parseBoolean(values[1]), palindromePermutation.isPalindromePermutationMap(word));
        assertEquals(Boolean.parseBoolean(values[1]), palindromePermutation.isPalindromePermutationArr(word));
        assertEquals(Boolean.parseBoolean(values[1]), palindromePermutation.isPalindromePermutationBit(word));
    }
}
