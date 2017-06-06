package dp;

import static org.junit.Assert.assertEquals;

import dp.FibonacciNumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestFibonacciNumber {
  private static String inputFile = "input_files/dp/fibonacci_number/test_case";
  private static FibonacciNumber fibonacciNumber = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    fibonacciNumber = new FibonacciNumber();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    fibonacciNumber = null;
    input = null;
  }

  @Test
  public void testFibonacciNumberTestCase1() {
    String[] values = input[0].split(" ");
    assertFib(values);
    assertFibMemoized(values);
    assertFibTabulated(values);
  }

  @Test
  public void testFibonacciNumberTestCase2() {
    String[] values = input[1].split(" ");
    assertFib(values);
    assertFibMemoized(values);
    assertFibTabulated(values);
  }

  @Test
  public void testFibonacciNumberTestCase3() {
    String[] values = input[2].split(" ");
    assertFib(values);
    assertFibMemoized(values);
    assertFibTabulated(values);
  }

  @Test
  public void testFibonacciNumberTestCase4() {
    String[] values = input[3].split(" ");
    assertFib(values);
    assertFibMemoized(values);
    assertFibTabulated(values);
  }

  @Test
  public void testFibonacciNumberTestCase5() {
    String[] values = input[4].split(" ");
    assertFib(values);
    assertFibMemoized(values);
    assertFibTabulated(values);
  }

  private void assertFib(String[] values) {
    assertEquals(Long.parseLong(values[1]), fibonacciNumber.fib(Integer.parseInt(values[0])));
  }

  private void assertFibMemoized(String[] values) {
    assertEquals(Long.parseLong(values[1]), fibonacciNumber.fibMemoized(Integer.parseInt(values[0])));
  }

  private void assertFibTabulated(String[] values) {
    assertEquals(Long.parseLong(values[1]), fibonacciNumber.fibTabulated(Integer.parseInt(values[0])));
  }
}
