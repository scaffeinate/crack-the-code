package dp;

import datastructures.util.InputUtil;
import dp.EggDroppingProblem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEggDroppingProblem {
  private static String inputFile = "input_files/dp/egg_dropping_problem/test_case";
  private static EggDroppingProblem eggDroppingProblem = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    eggDroppingProblem = new EggDroppingProblem();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    eggDroppingProblem = null;
    input = null;
  }

  @Test
  public void testEggDroppingProblemTestCase1() {
    String[] values = input[0].split(" ");
    assertEggDroppingProblemRecursive(values);
    assertEggDroppingProblemDP(values);
  }

  @Test
  public void testEggDroppingProblemTestCase2() {
    String[] values = input[1].split(" ");
    assertEggDroppingProblemRecursive(values);
    assertEggDroppingProblemDP(values);
  }

  @Test
  public void testEggDroppingProblemTestCase3() {
    String[] values = input[2].split(" ");
    assertEggDroppingProblemRecursive(values);
    assertEggDroppingProblemDP(values);
  }

  @Test
  public void testEggDroppingProblemTestCase4() {
    String[] values = input[3].split(" ");
    assertEggDroppingProblemDP(values);
  }

  @Test
  public void testEggDroppingProblemTestCase5() {
    String[] values = input[4].split(" ");
    assertEggDroppingProblemDP(values);
  }

  private void assertEggDroppingProblemDP(String[] values) {
    assertEquals(Long.parseLong(values[2]), eggDroppingProblem.minAttemptsDP(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
  }

  private void assertEggDroppingProblemRecursive(String[] values) {
    assertEquals(Long.parseLong(values[2]), eggDroppingProblem.minAttemptsRecursive(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
  }
}
