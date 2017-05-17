package binarytree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestCountHalfNodes {
  private static final String basePath = "input_files/binarytree/count_half_nodes/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static CountHalfNodesBinaryTree countHalfNodesBinaryTree = null;

  @BeforeClass
  public static void setup() {
    countHalfNodesBinaryTree = new CountHalfNodesBinaryTree();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    countHalfNodesBinaryTree = null;
    inputList = null;
  }

  @Test
  public void testCountHalfNodesBinaryTreeTestCase1() {
    String[] input = inputList.get(0);
    assertCountHalfNodes(input);
  }

  @Test
  public void testCountHalfNodesBinaryTreeTestCase2() {
    String[] input = inputList.get(1);
    assertCountHalfNodes(input);
  }

  @Test
  public void testCountHalfNodesBinaryTreeTestCase3() {
    String[] input = inputList.get(2);
    assertCountHalfNodes(input);
  }

  @Test
  public void testCountHalfNodesBinaryTreeTestCase4() {
    String[] input = inputList.get(3);
    assertCountHalfNodes(input);
  }

  private void assertCountHalfNodes(String[] input) {
    countHalfNodesBinaryTree.constructTree(input);
    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("count")) {
        assertEquals(Integer.parseInt(values[1]), countHalfNodesBinaryTree.countHalfNodes());
        assertEquals(Integer.parseInt(values[1]), countHalfNodesBinaryTree.countHalfNodesIterative());
      }
    }
  }
}
