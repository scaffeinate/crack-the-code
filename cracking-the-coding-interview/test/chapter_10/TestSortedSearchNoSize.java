package chapter_10;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/9/17.
 */
public class TestSortedSearchNoSize {
    private static final String inputFile = "input_files/chapter_10/sorted_search_no_size/test_case";
    private static String[] input = null;
    private static SortedSearchNoSize sortedSearch = null;

    @BeforeClass
    public static void setup() {
        sortedSearch = new SortedSearchNoSize();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        sortedSearch = null;
        input = null;
    }

    @Test
    public void testSortedSearchNoSizeTestCase1() {
        assertSortedSearchNoSize(input[0]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase2() {
        assertSortedSearchNoSize(input[1]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase3() {
        assertSortedSearchNoSize(input[2]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase4() {
        assertSortedSearchNoSize(input[3]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase5() {
        assertSortedSearchNoSize(input[4]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase6() {
        assertSortedSearchNoSize(input[5]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase7() {
        assertSortedSearchNoSize(input[6]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase8() {
        assertSortedSearchNoSize(input[7]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase9() {
        assertSortedSearchNoSize(input[8]);
    }

    @Test
    public void testSortedSearchNoSizeTestCase10() {
        assertSortedSearchNoSize(input[9]);
    }

    private void assertSortedSearchNoSize(String input) {
        String[] values = input.split("\\|");
        int target = Integer.parseInt(values[1]);
        int expected = Integer.parseInt(values[2]);

        String[] inputValues = values[0].split(",");
        Listy listy = new Listy();
        for (int i = 0; i < inputValues.length; i++) {
            listy.add(Integer.parseInt(inputValues[i]));
        }

        assertEquals(expected, sortedSearch.search(listy, target));
    }
}
