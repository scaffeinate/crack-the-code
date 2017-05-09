package chapter_6;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import datastructures.util.InputUtil;

public class TestRecursiveMultiply {
  private static String inputFile = "input_files/chapter_6/recursive_multiply/test_case";
  private static RecursiveMultiply recursiveMultiply;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    recursiveMultiply = new RecursiveMultiply();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    recursiveMultiply = null;
    input = null;
  }

  @Test
  public void testRecursiveMultiplyTestCase1() {
    assertRecursiveMultiply(input[0]);
  }

  @Test
  public void testRecursiveMultiplyTestCase2() {
    assertRecursiveMultiply(input[1]);
  }

  @Test
  public void testRecursiveMultiplyTestCase3() {
    assertRecursiveMultiply(input[2]);
  }

  @Test
  public void testRecursiveMultiplyTestCase4() {
    assertRecursiveMultiply(input[3]);
  }

  @Test
  public void testRecursiveMultiplyTestCase5() {
    assertRecursiveMultiply(input[4]);
  }

  @Test
  public void testRecursiveMultiplyTestCase6() {
    assertRecursiveMultiply(input[5]);
  }

  private void assertRecursiveMultiply(String input) {
    String[] values = input.split(" ");
    assertEquals(Long.parseLong(values[2]),
        recursiveMultiply.multiply(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
  }
}
