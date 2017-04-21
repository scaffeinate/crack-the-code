package chapter_6;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestRobotInAGrid {
  private static String basePath = "input_files/chapter_6/robot_in_a_grid/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };;
  private static RobotInAGrid robotInAGrid = null;
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    robotInAGrid = new RobotInAGrid();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    robotInAGrid = null;
    inputList = null;
  }

  @Test
  public void testRobotInAGrid1() {
    String[] input = inputList.get(0);
    assertRobotInAGrid(input, 27);
  }
  
  @Test
  public void testRobotInAGrid2() {
    String[] input = inputList.get(1);
    assertRobotInAGrid(input, 1);
  }
  
  @Test
  public void testRobotInAGrid3() {
    String[] input = inputList.get(2);
    assertRobotInAGrid(input, 0);
  }

  private void assertRobotInAGrid(String[] input, int expected) {
    int rows = input.length, columns = input[0].split(" ").length;
    int[][] grid = new int[rows][columns];

    for (int i = 0; i < input.length; i++) {
      String[] values = input[i].split(" ");
      for (int j = 0; j < values.length; j++) {
        grid[i][j] = Integer.parseInt(values[j]);
      }
    }
    int output = robotInAGrid.numPaths(grid);

    assertEquals(expected, output);
  }
}
