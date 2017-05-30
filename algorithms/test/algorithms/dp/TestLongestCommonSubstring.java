package algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestLongestCommonSubstring {
  private static String inputFile = "input_files/dp/longest_common_substring/test_case";
  private static LongestCommonSubstring longestCommonSubstring = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    longestCommonSubstring = new LongestCommonSubstring();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    longestCommonSubstring = null;
    input = null;
  }

  @Test
  public void testLongestCommonSubstringTestCase1() {
    String[] values = input[0].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubstringTestCase2() {
    String[] values = input[1].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubstringTestCase3() {
    String[] values = input[2].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubstringTestCase4() {
    String[] values = input[3].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubstringTestCase5() {
    String[] values = input[4].split(" ");
    assertLCS(values);
  }

  @Test
  public void testLongestCommonSubstringTestCase6() {
    String[] values = input[5].split(" ");
    assertLCS(values);
  }

  private void assertLCS(String[] values) {
    String lcsString = longestCommonSubstring.lcsTabulated(values[0], values[1]);
    assertEquals(Integer.parseInt(values[2]), lcsString.length());
    if (lcsString.length() > 0) {
      assertEquals(values[3], lcsString);
    }
  }
}
