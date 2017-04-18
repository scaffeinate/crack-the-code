package algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestLongestCommonSubSequence {
  private static String inputFile = "input_files/dp/lcs/test_case";
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
  public void testLongestCommonSubSequenceTestCase1() {
    String[] values = input[0].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubSequenceTestCase2() {
    String[] values = input[1].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubSequenceTestCase3() {
    String[] values = input[2].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubSequenceTestCase4() {
    String[] values = input[3].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubSequenceTestCase5() {
    String[] values = input[4].split(" ");
    assertLCS(values);
  }
  
  @Test
  public void testLongestCommonSubSequenceTestCase6() {
    String[] values = input[5].split(" ");
    assertLCS(values);
  }

  private void assertLCS(String[] values) {
    assertEquals(Integer.parseInt(values[2]), longestCommonSubSeq.lcsTabulated(values[0], values[1]));
    assertEquals(Integer.parseInt(values[2]), longestCommonSubSeq.lcsMemoized(values[0], values[1]));
  }
}
