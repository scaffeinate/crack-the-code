package chapter_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import datastructures.util.InputUtil;

public class TestPaintFill {
  private static final String basePath = "input_files/chapter_6/paint_fill/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static PaintFill paintFill = null;
  private Point[][] display = null;
  private static Map<Integer, Color> colorMap = null;

  @BeforeClass
  public static void setup() {
    paintFill = new PaintFill();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }

    loadColorMappings();
  }

  @AfterClass
  public static void teardown() {
    paintFill = null;
    testCases = null;
    inputList = null;
  }

  @Before
  public void setupTest() {
    loadInputMatrix();
  }

  @Test
  public void testPaintFillTestCase1() {
    String[] input = inputList.get(0);
    assertPaintFill(input, 1);
  }

  @Test
  public void testPaintFillTestCase2() {
    String[] input = inputList.get(1);
    assertPaintFill(input, 1);
  }

  @Test
  public void testPaintFillTestCase3() {
    String[] input = inputList.get(2);
    assertPaintFill(input, 1);
  }

  @Test
  public void testPaintFillTestCase4() {
    String[] input = inputList.get(3);
    assertPaintFill(input, 1);
  }

  @Test
  public void testPaintFillTestCase5() {
    String[] input = inputList.get(0);
    assertPaintFill(input, 2);
  }

  @Test
  public void testPaintFillTestCase6() {
    String[] input = inputList.get(1);
    assertPaintFill(input, 2);
  }

  @Test
  public void testPaintFillTestCase7() {
    String[] input = inputList.get(2);
    assertPaintFill(input, 2);
  }

  @Test
  public void testPaintFillTestCase8() {
    String[] input = inputList.get(3);
    assertPaintFill(input, 2);
  }

  private void assertPaintFill(String[] input, int method) {
    String[] values = input[0].split(" ");
    int x = Integer.parseInt(values[0]);
    int y = Integer.parseInt(values[1]);
    int colorCode = Integer.parseInt(values[2]);
    Point[][] expected = new Point[input.length - 1][input[1].split(" ").length];

    for (int i = 1; i < input.length; i++) {
      String[] inputValues = input[i].split(" ");
      for (int j = 0; j < inputValues.length; j++) {
        expected[i - 1][j] = new Point(i - 1, j, colorMap.get(Integer.parseInt(inputValues[j])));
      }
    }

    if (method == 1) {
      paintFill.fill(display, display[x][y], colorMap.get(colorCode));
    } else if (method == 2) {
      paintFill.fill2(display, display[x][y], colorMap.get(colorCode));
    }
    assertEquals(printDisplay(expected), printDisplay(display));
  }

  private void loadInputMatrix() {
    String[] input = InputUtil.readContents(basePath + "input_matrix");
    int m = input.length;
    int n = input[0].split(" ").length;
    display = new Point[m][n];

    for (int i = 0; i < m; i++) {
      String[] values = input[i].split(" ");
      for (int j = 0; j < n; j++) {
        display[i][j] = new Point(i, j, colorMap.get(Integer.parseInt(values[j])));
      }
    }
  }

  private static void loadColorMappings() {
    colorMap = new HashMap<Integer, Color>();
    String[] input = InputUtil.readContents(basePath + "color_mappings");
    for (String line : input) {
      String[] values = line.split(":");
      int colorCode = Integer.parseInt(values[0]);
      colorMap.put(colorCode, new Color(colorCode, values[1]));
    }
  }

  private static String printDisplay(Point[][] display) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < display.length; i++) {
      for (int j = 0; j < display[0].length; j++) {
        builder.append(display[i][j].color.colorCode).append(" ");
      }
      builder.append("\n");
    }

    return builder.toString();
  }

}
