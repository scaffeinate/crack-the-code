package tree;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCheckCousinsBinaryTree {
    private static final String basePath = "input_files/tree/check_cousins_binary_tree/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static CheckCousinsBinaryTree checkBinaryTree = null;

    @BeforeClass
    public static void setup() {
        checkBinaryTree = new CheckCousinsBinaryTree();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        checkBinaryTree = null;
        inputList = null;
    }

    @Test
    public void testCheckCousinsBinaryTreeTestCase1() {
        String[] input = inputList.get(0);
        assertCheckCousinsBinaryTree(input);
    }

    @Test
    public void testCheckCousinsBinaryTreeTestCase2() {
        String[] input = inputList.get(1);
        assertCheckCousinsBinaryTree(input);
    }

    private void assertCheckCousinsBinaryTree(String[] input) {
        checkBinaryTree.constructTree(input);
        for (String line : input) {
            String[] values = line.split(" ");
            if (values[0].equals("checkCousins")) {
                assertEquals(Boolean.parseBoolean(values[3]),
                        checkBinaryTree.checkCousins(Integer.parseInt(values[1]), Integer.parseInt(values[2])));
            }
        }
    }
}
