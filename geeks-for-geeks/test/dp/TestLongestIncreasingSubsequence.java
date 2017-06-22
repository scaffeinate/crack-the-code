package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 6/21/17.
 */
public class TestLongestIncreasingSubsequence {
	private static String inputFile = "input_files/dp/longest_increasing_subsequence/test_case";
	private static LongestIncreasingSubsequence longestIncreasingSubsequence = null;
	private static String[] input = null;

	@BeforeClass
	public static void setup() {
		longestIncreasingSubsequence = new LongestIncreasingSubsequence();
		input = InputUtil.readContents(inputFile);
	}

	@AfterClass
	public static void teardown() {
		longestIncreasingSubsequence = null;
		input = null;
	}

	@Test
	public void testLongestIncreasingSubsequenceTestCase1() {
		String[] values = input[0].split(" ");
		assertLIS(values);
	}

	@Test
	public void testLongestIncreasingSubsequenceTestCase2() {
		String[] values = input[1].split(" ");
		assertLIS(values);
	}

	@Test
	public void testLongestIncreasingSubsequenceTestCase3() {
		String[] values = input[2].split(" ");
		assertLIS(values);
	}

	@Test
	public void testLongestIncreasingSubsequenceTestCase4() {
		String[] values = input[3].split(" ");
		assertLIS(values);
	}

	@Test
	public void testLongestIncreasingSubsequenceTestCase5() {
		String[] values = input[4].split(" ");
		assertLIS(values);
	}

	private void assertLIS(String[] values) {
		int expected = Integer.parseInt(values[1]);
		String[] arrValues = values[0].split(",");
		int[] arr = new int[arrValues.length];

		for (int i = 0; i < arrValues.length; i++) {
			arr[i] = Integer.parseInt(arrValues[i]);
		}

		assertEquals(expected, longestIncreasingSubsequence.longestSeq(arr));
		assertEquals(expected, longestIncreasingSubsequence.longestSeqDP(arr));
	}
}
