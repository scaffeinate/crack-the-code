package algoritms.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.SecondSmallest;
import datastructures.util.InputUtil;

public class TestSecondSmallest {
    private static final String basePath = "input_files/problems/second_smallest/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static SecondSmallest secondSmallest = null;

    @BeforeClass
    public static void setup() {
        secondSmallest = new SecondSmallest();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        secondSmallest = null;
        testCases = null;
        inputList = null;
    }

    @Test
    public void testSecondSmallestTestCase1() {
        String[] input = inputList.get(0);
        String[] values = input[0].split(" ");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        assertEquals(secondSmallest.fetchSecondSmallest(arr), 2);
    }

    @Test
    public void testSecondSmallestTestCase2() {
        String[] input = inputList.get(1);
        String[] values = input[0].split(" ");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        assertEquals(secondSmallest.fetchSecondSmallest(arr), 2);
    }

    @Test
    public void testSecondSmallestTestCase3() {
        String[] input = inputList.get(2);
        String[] values = input[0].split(" ");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        assertEquals(secondSmallest.fetchSecondSmallest(arr), 2);
    }

    @Test
    public void testSecondSmallestTestCase4() {
        String[] input = inputList.get(3);
        String[] values = input[0].split(" ");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        assertEquals(secondSmallest.fetchSecondSmallest(arr), 2);
    }
}
