package array;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestNobleIntegersInArray {
  private static String inputFile = "input_files/array/noble_integers_in_array/test_case";
  private static NobleIntegersInArray nobleIntegersInArray;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    nobleIntegersInArray = new NobleIntegersInArray();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    nobleIntegersInArray = null;
    input = null;
  }

  @Test
  public void testNobleIntegersInArrayTestCase1() {
    assertNobleIntegers(input[0]);
  }

  @Test
  public void testNobleIntegersInArrayTestCase2() {
    assertNobleIntegers(input[1]);
  }

  @Test
  public void testNobleIntegersInArrayTestCase3() {
    assertNobleIntegers(input[2]);
  }

  @Test
  public void testNobleIntegersInArrayTestCase4() {
    assertNobleIntegers(input[3]);
  }

  @Test
  public void testNobleIntegersInArrayTestCase5() {
    assertNobleIntegers(input[4]);
  }

  private void assertNobleIntegers(String input) {
    String[] values = input.split(" ");
    String[] arrValues = values[0].split(",");
    int[] arr = new int[arrValues.length];

    for (int i = 0; i < arrValues.length; i++) {
      arr[i] = Integer.parseInt(arrValues[i]);
    }

    assertEquals(Integer.parseInt(values[1]), nobleIntegersInArray.nobleInteger(arr));
  }
}
