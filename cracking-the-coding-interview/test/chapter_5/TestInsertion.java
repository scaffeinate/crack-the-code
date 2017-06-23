package chapter_5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestInsertion {
    private static String basePath = "input_files/chapter_5/insertion/";
    private static Insertion insertion;
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3"};
    ;
    private static List<String[]> inputList = new ArrayList<String[]>();

    @BeforeClass
    public static void setup() {
        insertion = new Insertion();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        insertion = null;
        testCases = null;
        inputList = null;
    }

    @Test
    public void testInsertionCase1() {
        String[] input = inputList.get(0);
        assertInsertion(input);
    }

    @Test
    public void testInsertionCase2() {
        String[] input = inputList.get(1);
        assertInsertion(input);
    }

    @Test
    public void testInsertionCase3() {
        String[] input = inputList.get(2);
        assertInsertion(input);
    }

    private void assertInsertion(String[] input) {
        String[] values = input[0].split(" ");
        int m = Integer.parseInt(values[0], 2);
        int n = Integer.parseInt(values[1], 2);
        int i = Integer.parseInt(values[2]);
        int j = Integer.parseInt(values[3]);

        String actual = insertion.insertMIntoN(n, m, i, j);
        assertEquals(input[1], actual);
    }
}
