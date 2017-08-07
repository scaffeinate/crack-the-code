package tree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestLCABinaryTree {
    private static final String basePath = "input_files/tree/lca/";
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static LCABinaryTree lcaBinaryTree = null;

    @BeforeClass
    public static void setup() {
        lcaBinaryTree = new LCABinaryTree();
        for (String testCase : testCases) {
            String inputFile = basePath + testCase;
            inputList.add(InputUtil.readContents(inputFile));
        }
    }

    @AfterClass
    public static void teardown() {
        lcaBinaryTree = null;
        inputList = null;
    }

    @Test
    public void testLCABinaryTree1() {
        String[] input = inputList.get(0);
        assertLCA(input);
    }

    @Test
    public void testLCABinaryTree2() {
        String[] input = inputList.get(1);
        assertLCA(input);
    }

    @Test
    public void testLCABinaryTree3() {
        String[] input = inputList.get(2);
        assertLCA(input);
    }

    @Test
    public void testLCABinaryTree4() {
        String[] input = inputList.get(3);
        assertLCA(input);
    }

    private void assertLCA(String[] input) {
        lcaBinaryTree.constructTree(input);
        int expected = 0;
        for (String line : input) {
            String[] values = line.split(" ");
            if (values[0].equals("lca")) {
                expected = Integer.parseInt(values[3]);
                int output = lcaBinaryTree.lca(Integer.parseInt(values[1]), Integer.parseInt(values[2])).data;
                assertEquals(expected, output);
                break;
            }
        }
    }
}
