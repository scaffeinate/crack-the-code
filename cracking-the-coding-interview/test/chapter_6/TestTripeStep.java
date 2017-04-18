package chapter_6;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestTripeStep {
  private static String inputFile = "input_files/chapter_6/triple_step/test_case";
  private static TripleStep tripleStep;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    tripleStep = new TripleStep();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    tripleStep = null;
    input = null;
  }

  @Test
  public void testTripleStepTestCase1() {
    assertTripleStep(input[0]);
  }

  @Test
  public void testTripleStepTestCase2() {
    assertTripleStep(input[1]);
  }

  @Test
  public void testTripleStepTestCase3() {
    assertTripleStep(input[2]);
  }

  @Test
  public void testTripleStepTestCase4() {
    assertTripleStep(input[3]);
  }

  @Test
  public void testTripleStepTestCase5() {
    assertTripleStep(input[4]);
  }

  @Test
  public void testTripleStepTestCase6() {
    assertTripleStep(input[5]);
  }

  private void assertTripleStep(String input) {
    String[] values = input.split(" ");
    assertEquals(Integer.parseInt(values[1]), tripleStep.countWays(Integer.parseInt(values[0])));
  }
}
