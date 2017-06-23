package random;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestPalindromicSubstring {
    private static String inputFile = "input_files/random/longest_palindromic_substring/test_case";
    private static LongestPalindromicSubstring longestPalindromicSubstring = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        longestPalindromicSubstring = null;
        input = null;
    }

    @Test
    public void testLongestPalindromicSubstringTestCase1() {
        String[] values = input[0].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubstringTestCase2() {
        String[] values = input[1].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubstringTestCase3() {
        String[] values = input[2].split(" ");
        assertLPS(values);
    }

    @Test
    public void testLongestPalindromicSubstringTestCase4() {
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
        String lcsString = longestPalindromicSubstring.longestPS(values[0]);
        assertEquals(values[1].length(), lcsString.length());
        if (lcsString.length() > 0) {
            assertEquals(values[1], lcsString);
        }
    }
}
