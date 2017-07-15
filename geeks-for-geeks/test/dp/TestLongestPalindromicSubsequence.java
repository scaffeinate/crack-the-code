package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestPalindromicSubsequence {
    private static String inputFile = "input_files/dp/longest_palindromic_subsequence/test_case";
    private static LongestPalindromicSubsequence longestPalindromicSubsequence = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        longestPalindromicSubsequence = null;
        input = null;
    }

    @Test
    public void testLongestPalindromicSubsequenceTestCase1() {
        String[] values = input[0].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubsequenceTestCase2() {
        String[] values = input[1].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubsequenceTestCase3() {
        String[] values = input[2].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubsequenceTestCase4() {
        String[] values = input[3].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestCommonSubstringTestCase5() {
        String[] values = input[4].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestCommonSubstringTestCase6() {
        String[] values = input[5].split(" ");
        assertLPS(values);
    }

    private void assertLPS(String[] values) {
        String lcsString = longestPalindromicSubsequence.longestPS(values[0]);
        assertEquals(Integer.parseInt(values[1]), lcsString.length());
    }
}
