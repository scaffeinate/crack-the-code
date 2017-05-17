package string;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestCountSubstringsFirstLastCharacters {
  private static String inputFile = "input_files/string/count_substrings_first_last/test_case";
  private static CountSubstringsFirstLastCharacters countSubstrings;
  private static String[] input = null;
  
  @BeforeClass
  public static void setup() {
    countSubstrings = new CountSubstringsFirstLastCharacters();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    countSubstrings = null;
    input = null;
  }

  @Test
  public void testCountSubstringsTestCase1() {
    assertFlipBitToWin(input[0]);
  }
  
  @Test
  public void testCountSubstringsTestCase2() {
    assertFlipBitToWin(input[1]);
  }
  
  @Test
  public void testCountSubstringsTestCase3() {
    assertFlipBitToWin(input[2]);
  }
  
  @Test
  public void testCountSubstringsTestCase4() {
    assertFlipBitToWin(input[3]);
  }
  
  @Test
  public void testCountSubstringsTestCase5() {
    assertFlipBitToWin(input[4]);
  }
  
  @Test
  public void testCountSubstringsTestCase6() {
    assertFlipBitToWin(input[5]);
  }

  private void assertFlipBitToWin(String input) {
    String[] values = input.split(" ");
    assertEquals(Integer.parseInt(values[1]), countSubstrings.countSubstrings(values[0]));
    assertEquals(Integer.parseInt(values[1]), countSubstrings.countSubstrings2(values[0]));
    assertEquals(Integer.parseInt(values[1]), countSubstrings.countSubstrings3(values[0]));
  }
}
