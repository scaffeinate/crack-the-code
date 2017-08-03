package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/3/17.
 */
public class TestPalindromePartitioning {
    private static String inputFile = "input_files/dp/palindrome_partitioning/test_case";
    private static PalindromePartitioning palindromePartitioning = null;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        palindromePartitioning = new PalindromePartitioning();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        palindromePartitioning = null;
        input = null;
    }

    @Test
    public void testPalindromePartitioningTestCase1() {
        String[] values = input[0].split(" ");
        assertPalindromePartitioning(values);
    }

    @Test
    public void testPalindromePartitioningTestCase2() {
        String[] values = input[1].split(" ");
        assertPalindromePartitioning(values);
    }

    @Test
    public void testPalindromePartitioningTestCase3() {
        String[] values = input[2].split(" ");
        assertPalindromePartitioning(values);
    }

    @Test
    public void testPalindromePartitioningTestCase4() {
        String[] values = input[3].split(" ");
        assertPalindromePartitioning(values);
    }

    @Test
    public void testPalindromePartitioningTestCase5() {
        String[] values = input[4].split(" ");
        assertPalindromePartitioning(values);
    }

    private void assertPalindromePartitioning(String[] values) {
        int expected = Integer.parseInt(values[1]);
        assertEquals(expected, palindromePartitioning.minCuts(values[0]));
    }
}
