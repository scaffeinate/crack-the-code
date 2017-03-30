package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestNextNumber {
  private static String inputFile = "input_files/chapter_5/next_number/test_case";
  private static NextNumber nextNumber;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    nextNumber = new NextNumber();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    nextNumber = null;
    input = null;
  }

  @Test
  public void testNextNumberTestCase1() {
    assertNextNumber(input[0]);
  }
  
  @Test
  public void testNextNumberTestCase2() {
    assertNextNumber(input[1]);
  }
  
  @Test
  public void testNextNumberTestCase3() {
    assertNextNumber(input[2]);
  }

  private void assertNextNumber(String input) {
    String[] values = input.split(" ");
    int n = Integer.parseInt(values[0]);
    assertEquals(Integer.parseInt(values[1]), nextNumber.getNext(n));
    assertEquals(Integer.parseInt(values[2]), nextNumber.getPrevious(n));
  }
}
