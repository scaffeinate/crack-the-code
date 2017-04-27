package chapter_6;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestTowersOfHanoi {
  private static String inputFile = "input_files/chapter_6/towers_of_hanoi/test_case";
  private static TowersOfHanoi towersOfHanoi;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    towersOfHanoi = new TowersOfHanoi();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    towersOfHanoi = null;
    input = null;
  }

  @Test
  public void testTowersOfHanoiTestCase1() {
    assertTowersOfHanoi(input[0]);
  }

  @Test
  public void testTowersOfHanoiTestCase2() {
    assertTowersOfHanoi(input[1]);
  }

  @Test
  public void testTowersOfHanoiTestCase3() {
    assertTowersOfHanoi(input[2]);
  }

  private void assertTowersOfHanoi(String input) {
    String[] values = input.split(" ");
    Stack<Integer> source = new Stack<Integer>();
    Stack<Integer> expected = new Stack<Integer>();
    for (String v : values) {
      source.push(Integer.parseInt(v));
      expected.push(Integer.parseInt(v));
    }
    Stack<Integer> output = towersOfHanoi.towers(source);
    assertEquals(true, source.isEmpty());

    while (!output.isEmpty()) {
      assertEquals(expected.pop(), output.pop());
    }
  }
}
