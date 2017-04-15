package algorithms.dp;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestCountWaysToReachNStairs {
  private static String inputFile = "input_files/dp/count_ways_n_stairs/test_case";
  private static CountWaysToReachNStairs countWaysToReachNStairs = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    countWaysToReachNStairs = new CountWaysToReachNStairs();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    countWaysToReachNStairs = null;
    input = null;
  }

  @Test
  public void testFibonacciNumberTestCase1() {
    String[] values = input[0].split(" ");
    assertCountWaysToReachN(values);
  }

  @Test
  public void testFibonacciNumberTestCase2() {
    String[] values = input[1].split(" ");
    assertCountWaysToReachN(values);
  }
  
  @Test
  public void testFibonacciNumberTestCase3() {
    String[] values = input[2].split(" ");
    assertCountWaysToReachN(values);
  }

  private void assertCountWaysToReachN(String[] values) {
    int numWays = countWaysToReachNStairs.countWays(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    assertEquals(Integer.parseInt(values[2]), numWays);
  }
}
