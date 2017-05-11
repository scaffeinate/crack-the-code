package algorithms.dp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import algorithms.util.InputUtil;

public class TestLevenshtein {
  private static String inputFile = "input_files/dp/levenshtein/test_case";
  private static Levenshtein levenshtein = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    levenshtein = new Levenshtein();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    levenshtein = null;
    input = null;
  }

  @Test
  public void testLevenshteinTestCase1() {
    String[] values = input[0].split(" ");
    assertLevenshtein(values);
  }

  @Test
  public void testLevenshteinTestCase2() {
    String[] values = input[1].split(" ");
    assertLevenshtein(values);
  }

  @Test
  public void testLevenshteinTestCase3() {
    String[] values = input[2].split(" ");
    assertLevenshtein(values);
  }

  @Test
  public void testLevenshteinTestCase4() {
    String[] values = input[3].split(" ");
    assertLevenshtein(values);
  }

  @Test
  public void testLevenshteinTestCase5() {
    String[] values = input[4].split(" ");
    assertLevenshtein(values);
  }

  @Test
  public void testLevenshteinTestCase6() {
    String[] values = input[5].split(" ");
    assertLevenshtein(values);
  }

  private void assertLevenshtein(String[] values) {
    levenshtein.setStrings(values[0], values[1]);
    assertEquals(Integer.parseInt(values[2]), levenshtein.computeEditDistance());
  }
}
