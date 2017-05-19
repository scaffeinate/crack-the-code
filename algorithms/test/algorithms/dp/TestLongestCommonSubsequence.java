package algorithms.dp;

import algorithms.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLongestCommonSubsequence {
  private static String inputFile = "input_files/dp/longest_common_subsequence/test_case";
  private static LongestCommonSubsequence longestCommonSubSeq = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    longestCommonSubSeq = new LongestCommonSubsequence();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    longestCommonSubSeq = null;
    input = null;
  }

  @Test
  public void testLongestCommonSubsequenceTestCase1() {
    String[] values = input[0].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubsequenceTestCase2() {
    String[] values = input[1].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubsequenceTestCase3() {
    String[] values = input[2].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubsequenceTestCase4() {
    String[] values = input[3].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubsequenceTestCase5() {
    String[] values = input[4].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubsequenceTestCase6() {
    String[] values = input[5].split(" ");
    assertLCS(values);
  }

  private void assertLCS(String[] values) {
    String lcsString = longestCommonSubSeq.lcsTabulated(values[0], values[1]);
    assertEquals(Integer.parseInt(values[2]), lcsString.length());
    assertEquals(values[3], lcsString);
    assertEquals(Integer.parseInt(values[2]), longestCommonSubSeq.lcsMemoized(values[0], values[1]));
  }
}
