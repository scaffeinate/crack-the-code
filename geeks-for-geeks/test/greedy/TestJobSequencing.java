package greedy;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/15/17.
 */
public class TestJobSequencing {
    private static String inputFile = "input_files/greedy/job_sequencing/test_case";
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
    public void testJobSequencingTestCase1() {
        assertJobSequencing(input[0]);
    }

    @Test
    public void testJobSequencingTestCase2() {
        assertJobSequencing(input[1]);
    }

    @Test
    public void testJobSequencingTestCase3() {
        assertJobSequencing(input[2]);
    }

    @Test
    public void testJobSequencingTestCase4() {
        assertJobSequencing(input[3]);
    }

    @Test
    public void testJobSequencingTestCase5() {
        assertJobSequencing(input[4]);
    }

    @Test
    public void testJobSequencingTestCase6() {
        assertJobSequencing(input[5]);
    }

    @Test
    public void testJobSequencingTestCase7() {
        assertJobSequencing(input[6]);
    }

    private void assertJobSequencing(String input) {
        String[] values = input.split(" ");
        String[] arrValues = values[0].split(",");
        Integer[][] arr = new Integer[arrValues.length][2];

        for (int i = 0; i < arrValues.length; i++) {
            String[] temp = arrValues[i].split(":");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }

        assertEquals(Integer.parseInt(values[1]), JobSequencing.maxProfit(arr));
    }
}
