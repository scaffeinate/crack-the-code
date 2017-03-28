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
    String[] values = input[0].split(" ");
    Double num = Double.parseDouble(values[0]);
    assertEquals(values[1], binaryString.toBinaryString(num));
  }
  
  @Test
  public void testBinaryStringTestCase2() {
    String[] values = input[1].split(" ");
    Double num = Double.parseDouble(values[0]);
    assertEquals(values[1], binaryString.toBinaryString(num));
  }
  
  @Test
  public void testBinaryStringTestCase3() {
    String[] values = input[2].split(" ");
    Double num = Double.parseDouble(values[0]);
    assertEquals(values[1], binaryString.toBinaryString(num));
  }
  
  @Test
  public void testBinaryStringTestCase4() {
    String[] values = input[3].split(" ");
    Double num = Double.parseDouble(values[0]);
    assertEquals(values[1], binaryString.toBinaryString(num));
  }
}
