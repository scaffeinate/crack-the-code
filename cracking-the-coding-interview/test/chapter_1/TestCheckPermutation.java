package chapter_1;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestCheckPermutation {
  private static String inputFile = "input_files/chapter_1/check_permutation/test_case";
  private static CheckPermutation checkPermutation;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    checkPermutation = new CheckPermutation();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    checkPermutation = null;
    input = null;
  }

  @Test
  public void testCheckPermutationTestCase1() {
    assertCheckPermutation(input[0]);
  }

  @Test
  public void testCheckPermutationTestCase2() {
    assertCheckPermutation(input[1]);
  }

  @Test
  public void testCheckPermutationTestCase3() {
    assertCheckPermutation(input[2]);
  }

  private void assertCheckPermutation(String input) {
    String[] values = input.split(" ");
    String word = values[0].toLowerCase();
    String word2 = values[1].toLowerCase();
    assertEquals(Boolean.parseBoolean(values[2]), checkPermutation.isPermutationSorted(word, word2));
    assertEquals(Boolean.parseBoolean(values[2]), checkPermutation.isPermutationArray(word, word2));
    assertEquals(Boolean.parseBoolean(values[2]), checkPermutation.isPermutationBitWise(word, word2));
  }
}
