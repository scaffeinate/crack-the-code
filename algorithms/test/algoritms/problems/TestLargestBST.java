package algoritms.problems;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.LargestBST;
import algorithms.util.InputUtil;

public class TestLargestBST {
  private static final String basePath = "input_files/problems/largest_bst/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private LargestBST largestBST = null;

  @BeforeClass
  public static void setup() {
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    testCases = null;
    inputList = null;
  }

  @Before
  public void setupTest() {
    largestBST = new LargestBST();
  }

  @After
  public void tearDownTest() {
    largestBST = null;
  }
  
  @Test
  public void testLargestBSTTestCase1() {
    String[] input = inputList.get(0);
    largestBST.constructTree(input);
    assertEquals(8, largestBST.findLargestBST());
  }
  
  @Test
  public void testLargestBSTTestCase2() {
    String[] input = inputList.get(1);
    largestBST.constructTree(input);
    assertEquals(7, largestBST.findLargestBST());
  }
}
