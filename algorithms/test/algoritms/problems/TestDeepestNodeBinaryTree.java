package algoritms.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.DeepestNodeBinaryTree;
import algorithms.util.InputUtil;

public class TestDeepestNodeBinaryTree {
  private static final String basePath = "input_files/tree/deepest_node_binary_tree/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static DeepestNodeBinaryTree deepestNode = null;

  @BeforeClass
  public static void setup() {
    deepestNode = new DeepestNodeBinaryTree();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    deepestNode = null;
    inputList = null;
  }

  @Test
  public void testDeepestNodeBinaryTreeTestCase1() {
    String[] input = inputList.get(0);
    deepestNode.constructTree(input);
    assertEquals(Integer.valueOf(12), deepestNode.getDeepestNode());
  }
  
  @Test
  public void testDeepestNodeBinaryTreeTestCase2() {
    String[] input = inputList.get(1);
    deepestNode.constructTree(input);
    assertEquals(Integer.valueOf(9), deepestNode.getDeepestNode());
  }
}
