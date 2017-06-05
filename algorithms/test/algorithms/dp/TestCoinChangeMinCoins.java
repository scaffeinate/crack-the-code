package algorithms.dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestCoinChangeMinCoins {
  private static final String inputFile = "input_files/dp/coin_change_min_coins/test_case";
  private static String[] input = null;
  private static CoinChangeMinCoins coinChangeMinCoins = null;

  @BeforeClass
  public static void setup() {
    coinChangeMinCoins = new CoinChangeMinCoins();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    coinChangeMinCoins = null;
    input = null;
  }

  @Test
  public void testCoinChangeMinCoinsTestCase1() {
    String[] values = input[0].split(" ");
    assertCoinChangeMinCoins(values);
    assertCoinChangeMinCoinsMemoized(values);
  }

  @Test
  public void testCoinChangeMinCoinsTestCase2() {
    String[] values = input[1].split(" ");
    assertCoinChangeMinCoins(values);
    assertCoinChangeMinCoinsMemoized(values);
  }

  @Test
  public void testCoinChangeMinCoinsTestCase3() {
    String[] values = input[2].split(" ");
    assertCoinChangeMinCoins(values);
    assertCoinChangeMinCoinsMemoized(values);
  }

  @Test
  public void testCoinChangeMinCoinsTestCase4() {
    String[] values = input[3].split(" ");
    assertCoinChangeMinCoinsMemoized(values);
  }

  private void assertCoinChangeMinCoins(String[] values) {
    int n = Integer.parseInt(values[0]);
    String[] arrValues = values[1].split(",");
    int[] coins = new int[arrValues.length];

    for (int i = 0; i < arrValues.length; i++) {
      coins[i] = Integer.parseInt(arrValues[i]);
    }

    assertEquals(Long.parseLong(values[2]), coinChangeMinCoins.numWays(n, coins));
  }

  private void assertCoinChangeMinCoinsMemoized(String[] values) {
    int n = Integer.parseInt(values[0]);
    String[] arrValues = values[1].split(",");
    int[] coins = new int[arrValues.length];

    for (int i = 0; i < arrValues.length; i++) {
      coins[i] = Integer.parseInt(arrValues[i]);
    }

    assertEquals(Long.parseLong(values[2]), coinChangeMinCoins.numWaysMemoized(n, coins));
    assertEquals(Long.parseLong(values[2]), coinChangeMinCoins.numWaysMemoized2(n, coins));
    assertEquals(Long.parseLong(values[2]), coinChangeMinCoins.numWaysMemoized3(n, coins));
  }
}
