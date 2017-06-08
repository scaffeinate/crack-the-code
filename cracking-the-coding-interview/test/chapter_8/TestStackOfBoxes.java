package chapter_8;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStackOfBoxes {
  private static final String basePath = "input_files/chapter_8/stack_of_boxes/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static StackOfBoxes stackOfBoxes = null;

  @BeforeClass
  public static void setup() {
    stackOfBoxes = new StackOfBoxes();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    stackOfBoxes = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testStackOfBoxesTestCase1() {
    String[] input = inputList.get(0);
    assertStackOfBoxes(input, 12);
  }
  
  @Test
  public void testStackOfBoxesTestCase2() {
    String[] input = inputList.get(1);
    assertStackOfBoxes(input, 12);
  }

  @Test
  public void testStackOfBoxesTestCase3() {
    String[] input = inputList.get(2);
    assertStackOfBoxes(input, 48);
  }

  private void assertStackOfBoxes(String[] input, int expected) {
    List<Box> boxes = new ArrayList<Box>();
    for (String line : input) {
      String[] values = line.split(" ");
      boxes.add(new Box(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2])));
    }

    assertEquals(expected, stackOfBoxes.maximumHeight(boxes));
    assertEquals(expected, stackOfBoxes.maximumHeight2(boxes));
  }
}
