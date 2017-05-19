package chapter_8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestParens {
  private static final String inputFile = "input_files/chapter_8/parens/test_case";
  private static String[] input = null;
  private static Parens parens = null;

  @BeforeClass
  public static void setup() {
    parens = new Parens();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    parens = null;
    input = null;
  }

  @Test
  public void testParensTestCase1() {
    String[] values = input[0].split(" ");
    assertParens(values[0], values[1]);
  }

  @Test
  public void testParensTestCase2() {
    String[] values = input[1].split(" ");
    assertParens(values[0], values[1]);
  }

  @Test
  public void testParensTestCase3() {
    String[] values = input[2].split(" ");
    assertParens(values[0], values[1]);
  }

  private void assertParens(String inputVal, String expectedSize) {
    List<String> output = parens.getParans(Integer.parseInt(inputVal));
    BalancedBrackets balancedBrackets = new BalancedBrackets();
    for (String s : output) {
      assertTrue(balancedBrackets.isBalanced(s));
    }

    assertEquals(Integer.parseInt(expectedSize), output.size());

    output = parens.getParans2(Integer.parseInt(inputVal));
    for (String s : output) {
      assertTrue(balancedBrackets.isBalanced(s));
    }

    assertEquals(Integer.parseInt(expectedSize), output.size());
  }
}
