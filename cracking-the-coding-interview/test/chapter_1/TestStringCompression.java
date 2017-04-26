package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestStringCompression {
  private static String inputFile = "input_files/chapter_1/string_compression/test_case";
  private static StringCompression stringCompression;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    stringCompression = new StringCompression();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    stringCompression = null;
    input = null;
  }

  @Test
  public void testStringCompressionTestCase1() {
    assertStringCompression(input[0]);
  }

  @Test
  public void testStringCompressionTestCase2() {
    assertStringCompression(input[1]);
  }

  @Test
  public void testStringCompressionTestCase3() {
    assertStringCompression(input[2]);
  }

  private void assertStringCompression(String input) {
    String[] values = input.split(",");
    String line = values[0];
    assertEquals(values[1], stringCompression.compressString(line));
  }
}
