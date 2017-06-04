package algorithms.dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCoinChange {
  private static final String inputFile = "input_files/dp/coin_change/test_case";
  private static String[] input = null;
  private static CoinChange coinChange = null;

  @BeforeClass
  public static void setup() {
    coinChange = new CoinChange();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    coinChange = null;
    input = null;
  }

  @Test
  public void testCoinChangeTestCase1() {
    String[] values = input[0].split(" ");
    assertCoinChange(values);
  }

  @Test
  public void testCoinChangeTestCase2() {
    String[] values = input[1].split(" ");
    assertCoinChange(values);
  }

  @Test
  public void testCoinChangeTestCase3() {
    String[] values = input[2].split(" ");
    assertCoinChange(values);
  }

  @Test
  public void testCoinChangeTestCase4() {
    String[] values = input[3].split(" ");
    assertCoinChange(values);
  }

  @Test
  public void testCoinChangeTestCase5() {
    String[] values = input[4].split(" ");
    assertCoinChange(values);
  }

  @Test
  public void testCoinChangeTestCase6() {
    String[] values = input[5].split(" ");
    assertCoinChange(values);
  }

  private void assertCoinChange(String[] values) {
    int n = Integer.parseInt(values[0]);
    String[] arrValues = values[1].split(",");
    int[] arr = new int[arrValues.length];
    for (int i = 0; i < arrValues.length; i++) {
      arr[i] = Integer.parseInt(arrValues[i]);
    }
    long expected = Long.parseLong(values[2]);
    assertEquals(expected, coinChange.numWays(n, arr));
  }
}
