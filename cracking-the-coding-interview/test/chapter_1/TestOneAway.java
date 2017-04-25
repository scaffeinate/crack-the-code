package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestOneAway {
  private static String inputFile = "input_files/chapter_1/one_away/test_case";
  private static OneAway oneAway;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    oneAway = new OneAway();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    oneAway = null;
    input = null;
  }

  @Test
  public void testOneAwayTestCase1() {
    assertOneAway(input[0]);
  }

  @Test
  public void testOneAwayTestCase2() {
    assertOneAway(input[1]);
  }

  @Test
  public void testOneAwayTestCase3() {
    assertOneAway(input[2]);
  }

  private void assertOneAway(String input) {
    String[] values = input.split(",");
    String first = values[0];
    String second = values[1];
    assertEquals(Boolean.parseBoolean(values[2]), oneAway.checkOneAway(first,second));
    assertEquals(Boolean.parseBoolean(values[2]), oneAway.checkOneAway2(first,second));
    assertEquals(Boolean.parseBoolean(values[2]), oneAway.checkOneAway3(first,second));
  }
}
