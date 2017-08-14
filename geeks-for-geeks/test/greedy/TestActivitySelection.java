package greedy;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/14/17.
 */
public class TestActivitySelection {
    private static String inputFile = "input_files/greedy/activity_selection/test_case";
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        input = null;
    }

    @Test
    public void testActivitySelectionTestCase1() {
        assertActivitySelection(input[0]);
    }

    @Test
    public void testActivitySelectionTestCase2() {
        assertActivitySelection(input[1]);
    }

    @Test
    public void testActivitySelectionTestCase3() {
        assertActivitySelection(input[2]);
    }

    @Test
    public void testActivitySelectionTestCase4() {
        assertActivitySelection(input[3]);
    }

    @Test
    public void testActivitySelectionTestCase5() {
        assertActivitySelection(input[4]);
    }

    private void assertActivitySelection(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        Integer[][] arr = new Integer[arrValues.length][2];

        for (int i = 0; i < arrValues.length; i++) {
            String[] temp = arrValues[i].split(":");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        assertEquals(Integer.parseInt(values[1]), ActivitySelection.maxActivities(arr));
    }
}
