package dp;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudharti on 8/1/17.
 */
public class TestTotalNumberOfBSTNkeys {
    private static String inputFile = "input_files/dp/total_number_of_bst_nkeys/test_case";
    ;
    private static String[] input = null;
    private static TotalNumberOfBSTNKeys totalNumberOfBSTNKeys = null;

    @BeforeClass
    public static void setup() {
        totalNumberOfBSTNKeys = new TotalNumberOfBSTNKeys();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        totalNumberOfBSTNKeys = null;
        input = null;
    }

    @Test
    public void testTotalNumberOfBSTNKeys1() {
        assertTotalNumberOfBSTNKeys(input[0]);
    }

    @Test
    public void testTotalNumberOfBSTNKeys2() {
        assertTotalNumberOfBSTNKeys(input[1]);
    }

    @Test
    public void testTotalNumberOfBSTNKeys3() {
        assertTotalNumberOfBSTNKeys(input[2]);
    }

    @Test
    public void testTotalNumberOfBSTNKeys4() {
        assertTotalNumberOfBSTNKeys(input[3]);
    }

    @Test
    public void testTotalNumberOfBSTNKeys5() {
        assertTotalNumberOfBSTNKeys(input[4]);
    }

    @Test
    public void testTotalNumberOfBSTNKeys6() {
        assertTotalNumberOfBSTNKeys(input[5]);
    }

    private void assertTotalNumberOfBSTNKeys(String input) {
        String[] values = input.split(" ");
        int N = Integer.parseInt(values[0]);
        long expected = Long.parseLong(values[1]);
        assertEquals(expected, totalNumberOfBSTNKeys.totalWays(N));
    }
}
