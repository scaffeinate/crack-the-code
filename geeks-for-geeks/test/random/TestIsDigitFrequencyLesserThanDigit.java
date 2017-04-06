package random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestIsDigitFrequencyLesserThanDigit {
  private static String inputFile = "input_files/random/is_digit_frequency_less_than_digit/test_case";
  private static IsDigitFrequencyLessThanDigit isDigitFrequencyLessThanDigit;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    isDigitFrequencyLessThanDigit = new IsDigitFrequencyLessThanDigit();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    isDigitFrequencyLessThanDigit = null;
    input = null;
  }
  
  @Test
  public void testIsDigitFrequencyLessThanDigit1() {
    boolean result = isDigitFrequencyLessThanDigit.isFrequencyLessThanDigit(Integer.parseInt(input[0]));
    assertFalse(result);
  }

  @Test
  public void testIsDigitFrequencyLessThanDigit2() {
    boolean result = isDigitFrequencyLessThanDigit.isFrequencyLessThanDigit(Integer.parseInt(input[1]));
    assertTrue(result);
  }

  @Test
  public void testIsDigitFrequencyLessThanDigit3() {
    boolean result = isDigitFrequencyLessThanDigit.isFrequencyLessThanDigit(Integer.parseInt(input[2]));
    assertTrue(result);
  }

  @Test
  public void testIsDigitFrequencyLessThanDigit4() {
    boolean result = isDigitFrequencyLessThanDigit.isFrequencyLessThanDigit(Integer.parseInt(input[3]));
    assertFalse(result);
  }
}
