package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestURLify {
  private static String inputFile = "input_files/chapter_1/urlify/test_case";
  private static URLify urlify;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    urlify = new URLify();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    urlify = null;
    input = null;
  }

  @Test
  public void testURLifyTestCase1() {
    assertURLify(input[0]);
  }

  @Test
  public void testURLifyTestCase2() {
    assertURLify(input[1]);
  }

  @Test
  public void testURLifyTestCase3() {
    assertURLify(input[2]);
  }

  private void assertURLify(String input) {
    String[] values = input.split(",");
    String line = values[0];
    assertEquals(values[1], urlify.getURL(line, line.length()));
    assertEquals(values[1], urlify.getURLForward(line, line.length()));
  }
}
