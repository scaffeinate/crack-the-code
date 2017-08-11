package chapter_10;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sudharti on 8/11/17.
 */
public class TestSortStream {
    private static final String basePath = "input_files/chapter_10/sort_stream/";
    private static final String[] testCases = new String[]{"test_case_1", "test_case_2" };
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static SortStream sortStream = null;

    @BeforeClass
    public static void setup() {
        sortStream = new SortStream();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        sortStream = null;
        inputList = null;
    }

    @Test
    public void testSortStreamTestCase1() {
        assertSortStream(inputList.get(0));
    }

    @Test
    public void testSortStreamTestCase2() {
        assertSortStream(inputList.get(1));
    }

    private void assertSortStream(String[] input) {
        for (String line:input) {
            String[] values = line.split(" ");
            switch (values[0]) {
                case "t":
                    sortStream.track(Integer.parseInt(values[1]));
                    break;
                case "r":
                    assertEquals(Integer.parseInt(values[2]), sortStream.getRank(Integer.parseInt(values[1])));
                    break;
            }
        }
    }
}
