package binarytree;

import datastructures.util.InputUtil;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestLargestBST {
  private static final String basePath = "input_files/binarytree/largest_bst/";
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
