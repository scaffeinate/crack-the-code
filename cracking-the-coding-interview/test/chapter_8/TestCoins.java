package chapter_8;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCoins {
  private static final String inputFile = "input_files/chapter_8/coins/test_case";
  private static String[] input = null;
  private static Coins coins = null;

  @BeforeClass
  public static void setup() {
    coins = new Coins();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    coins = null;
    input = null;
  }

  @Test
  public void testCoinsTestCase1() {
    String[] values = input[0].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  @Test
  public void testCoinsTestCase2() {
    String[] values = input[1].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  @Test
  public void testCoinsTestCase3() {
    String[] values = input[2].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  @Test
  public void testCoinsTestCase4() {
    String[] values = input[3].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  @Test
  public void testCoinsTestCase5() {
    String[] values = input[4].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  @Test
  public void testCoinsTestCase6() {
    String[] values = input[5].split(" ");
    assertCoins(Integer.parseInt(values[0]), Long.parseLong(values[1]));
  }

  private void assertCoins(int n, long expected) {
    assertEquals(expected, coins.numWays(n));
  }
}
