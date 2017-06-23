package binarytree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestMaxDifferenceNodeAncestor {
    private static final String basePath = "input_files/binarytree/max_diff_node_ancestor/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static MaxDifferenceNodeAncestor maxDiffNodeAncestor = null;

    @BeforeClass
    public static void setup() {
        maxDiffNodeAncestor = new MaxDifferenceNodeAncestor();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        maxDiffNodeAncestor = null;
        inputList = null;
    }

    @Test
    public void testMaxDiffNodeAncestorTestCase1() {
        String[] input = inputList.get(0);
        assertMaxDiffNodeAncestor(input);
    }

    @Test
    public void testMaxDiffNodeAncestorTestCase2() {
        String[] input = inputList.get(1);
        assertMaxDiffNodeAncestor(input);
    }

    @Test
    public void testMaxDiffNodeAncestorTestCase3() {
        String[] input = inputList.get(2);
        assertMaxDiffNodeAncestor(input);
    }

    @Test
    public void testMaxDiffNodeAncestorTestCase4() {
        String[] input = inputList.get(3);
        assertMaxDiffNodeAncestor(input);
    }

    private void assertMaxDiffNodeAncestor(String[] input) {
        maxDiffNodeAncestor.constructTree(input);
        int expected = 0;
        for (String line : input) {
            String[] values = line.split(" ");
            if (values[0].equals("maxDiff")) {
                expected = Integer.parseInt(values[1]);
                break;
            }
        }

        assertEquals(expected, maxDiffNodeAncestor.maximumDifference());
    }
}
