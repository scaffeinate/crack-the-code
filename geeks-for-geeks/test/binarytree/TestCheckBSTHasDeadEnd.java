package binarytree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestCheckBSTHasDeadEnd {
  private static final String basePath = "input_files/binarytree/check_bst_has_dead_end/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static CheckBSTHasDeadEnd checkBSTHasDeadEnd = null;

  @BeforeClass
  public static void setup() {
    checkBSTHasDeadEnd = new CheckBSTHasDeadEnd();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    checkBSTHasDeadEnd = null;
    inputList = null;
  }

  @Test
  public void testCheckBSTHasDeadEndTestCase1() {
    String[] input = inputList.get(0);
    assertHasDeadEnd(input, true);
  }

  @Test
  public void testCheckBSTHasDeadEndTestCase2() {
    String[] input = inputList.get(1);
    assertHasDeadEnd(input, true);
  }

  @Test
  public void testCheckBSTHasDeadEndTestCase3() {
    String[] input = inputList.get(2);
    assertHasDeadEnd(input, false);
  }

  @Test
  public void testCheckBSTHasDeadEndTestCase4() {
    String[] input = inputList.get(3);
    assertHasDeadEnd(input, false);
  }

  private void assertHasDeadEnd(String[] input, boolean hasDeadEnd) {
    checkBSTHasDeadEnd.constructTree(input);
    assertEquals(hasDeadEnd, checkBSTHasDeadEnd.hasDeadEnd());
  }

}
