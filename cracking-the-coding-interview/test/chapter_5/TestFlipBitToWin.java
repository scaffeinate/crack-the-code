package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestFlipBitToWin {
  private static String inputFile = "input_files/chapter_5/flip_bit_to_win/test_case";
  private static FlipBitToWin flipBit;
  private static String[] input = null;
  
  @BeforeClass
  public static void setup() {
    flipBit = new FlipBitToWin();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    flipBit = null;
    input = null;
  }

  @Test
  public void testFlipBitToWinTestCase1() {
    assertFlipBitToWin(input[0]);
  }
  
  @Test
  public void testFlipBitToWinTestCase2() {
    assertFlipBitToWin(input[1]);
  }
  
  @Test
  public void testFlipBitToWinTestCase3() {
    assertFlipBitToWin(input[2]);
  }
  
  @Test
  public void testFlipBitToWinTestCase4() {
    assertFlipBitToWin(input[3]);
  }
  
  @Test
  public void testFlipBitToWinTestCase5() {
    assertFlipBitToWin(input[4]);
  }
  
  @Test
  public void testFlipBitToWinTestCase6() {
    assertFlipBitToWin(input[5]);
  }
  
  @Test
  public void testFlipBitToWinTestCase7() {
    assertFlipBitToWin(input[6]);
  }
  
  @Test
  public void testFlipBitToWinTestCase8() {
    assertFlipBitToWin(input[7]);
  }
  
  @Test
  public void testFlipBitToWinTestCase69() {
    assertFlipBitToWin(input[8]);
  }
  
  private void assertFlipBitToWin(String input) {
    String[] values = input.split(" ");
    assertEquals(Integer.parseInt(values[1]), flipBit.flipBitToWin(values[0]));
  }
}
