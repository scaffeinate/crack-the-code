package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestZeroOneKnapsack {
  private static String basePath = "input_files/dp/zero_one_knapsack/";
  private static ZeroOneKnapsack zeroOneKnapsack = null;
  private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    zeroOneKnapsack = new ZeroOneKnapsack();
    for (String testCase : testCases) {
      inputList.add(InputUtil.readContents(basePath + testCase));
    }
  }

  @AfterClass
  public static void teardown() {
    zeroOneKnapsack = null;
    inputList = null;
  }

  @Test
  public void testZeroOneKnapsack1() {
    String[] values = inputList.get(0);
    assertZeroOneKnapsack(values);
  }

  @Test
  public void testZeroOneKnapsack2() {
    String[] values = inputList.get(1);
    assertZeroOneKnapsack(values);
  }

  @Test
  public void testZeroOneKnapsack3() {
    String[] values = inputList.get(2);
    assertZeroOneKnapsack(values);
  }

  @Test
  public void testZeroOneKnapsack4() {
    String[] values = inputList.get(3);
    assertZeroOneKnapsack(values);
  }

  private void assertZeroOneKnapsack(String[] input) {
    int n = Integer.parseInt(input[0]);
    String[] weights = input[1].split(",");
    String[] values = input[2].split(",");
    List<Integer[]> items = new ArrayList<>();
    for (int i = 0; i < weights.length; i++) {
      items.add(new Integer[]{Integer.parseInt(weights[i]), Integer.parseInt(values[i])});
    }
    int expected = Integer.parseInt(input[3]);
    assertEquals(expected, zeroOneKnapsack.knapsack(n, items));
    assertEquals(expected, zeroOneKnapsack.knapsackMemoized(n, items));
    assertEquals(expected, zeroOneKnapsack.knapsackDP(n, items));
  }
}
