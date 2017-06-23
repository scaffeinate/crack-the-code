package chapter_8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import chapter_8.RobotInAGrid2.Cell;
import datastructures.util.InputUtil;

public class TestRobotInAGrid2 {
    private static String basePath = "input_files/chapter_8/robot_in_a_grid/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3"};
    ;
    private static RobotInAGrid2 robotInAGrid2 = null;
    private static List<String[]> inputList = new ArrayList<String[]>();

    @BeforeClass
    public static void setup() {
        robotInAGrid2 = new RobotInAGrid2();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        robotInAGrid2 = null;
        inputList = null;
    }

    @Test
    public void testRobotInAGrid2TestCase1() {
        String[] input = inputList.get(0);
        String[] expected = new String[]{"0,0", "1,0", "2,0", "2,1", "3,1", "4,1", "5,1", "5,2", "6,2", "7,2", "7,3",
                "7,4", "7,5", "7,6", "7,7"};
        assertRobotInAGrid2(input, expected);
    }

    @Test
    public void testRobotInAGrid2TestCase2() {
        String[] input = inputList.get(1);
        String[] expected = new String[]{"0,0", "0,1", "1,1", "2,1", "2,2", "2,3", "2,4"};
        assertRobotInAGrid2(input, expected);
    }

    @Test
    public void testRobotInAGrid2TestCase3() {
        String[] input = inputList.get(2);
        assertRobotInAGrid2(input, new String[]{});
    }

    private void assertRobotInAGrid2(String[] input, String[] expected) {
        int rows = input.length, columns = input[0].split(" ").length;
        int[][] grid = new int[rows][columns];

        for (int i = 0; i < input.length; i++) {
            String[] values = input[i].split(" ");
            for (int j = 0; j < values.length; j++) {
                grid[i][j] = Integer.parseInt(values[j]);
            }
        }
        List<Cell> path = robotInAGrid2.findPath(grid);
        assertThat(path, hasSize(expected.length));

        for (int i = 0; i < expected.length; i++) {
            Cell cell = path.get(i);
            assertEquals(expected[i], cell.toString());
        }
    }
}
