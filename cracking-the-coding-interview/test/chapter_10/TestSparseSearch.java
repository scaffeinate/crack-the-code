package chapter_10;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/10/17.
 */
public class TestSparseSearch {
    private static final String inputFile = "input_files/chapter_10/sparse_search/test_case";
    private static String[] input = null;
    private static SparseSearch sparseSearch = null;

    @BeforeClass
    public static void setup() {
        sparseSearch = new SparseSearch();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        sparseSearch = null;
        input = null;
    }

    @Test
    public void testSparseSearchTestCase1() {
        assertSparseSearch(input[0]);
    }

    @Test
    public void testSparseSearchTestCase2() {
        assertSparseSearch(input[1]);
    }

    @Test
    public void testSparseSearchTestCase3() {
        assertSparseSearch(input[2]);
    }

    @Test
    public void testSparseSearchTestCase4() {
        assertSparseSearch(input[3]);
    }

    @Test
    public void testSparseSearchTestCase5() {
        assertSparseSearch(input[4]);
    }

    @Test
    public void testSparseSearchTestCase6() {
        assertSparseSearch(input[5]);
    }

    @Test
    public void testSparseSearchTestCase7() {
        assertSparseSearch(input[6]);
    }

    @Test
    public void testSparseSearchTestCase8() {
        assertSparseSearch(input[7]);
    }

    @Test
    public void testSparseSearchTestCase9() {
        assertSparseSearch(input[8]);
    }

    @Test
    public void testSparseSearchTestCase10() {
        assertSparseSearch(input[9]);
    }

    @Test
    public void testSparseSearchTestCase11() {
        assertSparseSearch(input[10]);
    }

    @Test
    public void testSparseSearchTestCase12() {
        assertSparseSearch(input[11]);
    }

    @Test
    public void testSparseSearchTestCase13() {
        assertSparseSearch(input[12]);
    }

    @Test
    public void testSparseSearchTestCase14() {
        assertSparseSearch(input[13]);
    }

    @Test
    public void testSparseSearchTestCase15() {
        assertSparseSearch(input[14]);
    }

    private void assertSparseSearch(String input) {
        String[] values = input.split("\\|");
        int expected = Integer.parseInt(values[2]);

        assertEquals(expected, sparseSearch.sparseSearch(values[0].split(","), values[1]));
    }
}
