package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestBinaryString {
  private static String inputFile = "input_files/chapter_5/binary_string/test_case";
  private static BinaryString binaryString;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    binaryString = new BinaryString();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    binaryString = null;
    input = null;
  }

  @Test
  public void testBinaryStringTestCase1() {
    assertBinaryString(input[0]);
  }
  
  @Test
  public void testBinaryStringTestCase2() {
    assertBinaryString(input[1]);
  }
  
  @Test
  public void testBinaryStringTestCase3() {
    assertBinaryString(input[2]);
  }
  
  @Test
  public void testBinaryStringTestCase4() {
    assertBinaryString(input[3]);
  }
  
  @Test
  public void testBinaryStringTestCase5() {
    assertBinaryString(input[4]);
  }
  
  @Test
  public void testBinaryStringTestCase6() {
    assertBinaryString(input[5]);
  }
  
  private void assertBinaryString(String input) {
    String[] values = input.split(" ");
    Double num = Double.parseDouble(values[0]);
    assertEquals(values[1], binaryString.toBinaryString(num));
    assertEquals(values[1], binaryString.toBinaryString2(num));
  }
}
