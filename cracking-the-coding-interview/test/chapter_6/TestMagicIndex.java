package chapter_6;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestMagicIndex {
  private static String inputFile = "input_files/chapter_6/magic_index/test_case";
  private static MagicIndex magicIndex;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    magicIndex = new MagicIndex();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    magicIndex = null;
    input = null;
  }

  @Test
  public void testMagicIndexTestCase1() {
    assertMagicIndex(input[0]);
  }

  @Test
  public void testMagicIndexTestCase2() {
    assertMagicIndex(input[1]);
  }

  @Test
  public void testMagicIndexTestCase3() {
    assertMagicIndex(input[2]);
  }

  private void assertMagicIndex(String input) {
    String[] values = input.split(" ");
    String[] arrValues = values[0].split(",");
    String[] expectedValues = values[1].split(",");
    int[] arr = new int[arrValues.length];
    List<Integer> expected = new ArrayList<Integer>();

    for (int i = 0; i < arrValues.length; i++) {
      arr[i] = Integer.parseInt(arrValues[i]);
    }

    for (int i = 0; i < expectedValues.length; i++) {
      expected.add(Integer.parseInt(expectedValues[i]));
    }

    int output = magicIndex.findMagicIndex(arr);
    assertEquals(true, expected.contains(output));
  }
}
