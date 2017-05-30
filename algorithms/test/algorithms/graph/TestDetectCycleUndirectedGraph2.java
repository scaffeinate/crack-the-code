package algorithms.graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestDetectCycleUndirectedGraph2 {
  private static final String basePath = "input_files/graph/detect_cycle/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4",
      "test_case_5" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private DetectCycleUndirectedGraph2 detectCycleUndirectedGraph2 = null;

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
    detectCycleUndirectedGraph2 = new DetectCycleUndirectedGraph2();
  }

  @After
  public void tearDownTest() {
    detectCycleUndirectedGraph2 = null;
  }

  @Test
  public void testDetectCycleUndirectedGraph2TestCase1() {
    String[] input = inputList.get(0);
    detectCycleUndirectedGraph2.constructGraph(input);
    assertEquals(true, detectCycleUndirectedGraph2.detectCycle());
  }

  @Test
  public void testDetectCycleUndirectedGraph2TestCase2() {
    String[] input = inputList.get(1);
    detectCycleUndirectedGraph2.constructGraph(input);
    assertEquals(false, detectCycleUndirectedGraph2.detectCycle());
  }

  @Test
  public void testDetectCycleUndirectedGraph2TestCase3() {
    String[] input = inputList.get(2);
    detectCycleUndirectedGraph2.constructGraph(input);
    assertEquals(true, detectCycleUndirectedGraph2.detectCycle());
  }

  @Test
  public void testDetectCycleUndirectedGraph2TestCase4() {
    String[] input = inputList.get(3);
    detectCycleUndirectedGraph2.constructGraph(input);
    assertEquals(true, detectCycleUndirectedGraph2.detectCycle());
  }

  @Test
  public void testDetectCycleUndirectedGraph2TestCase5() {
    String[] input = inputList.get(4);
    detectCycleUndirectedGraph2.constructGraph(input);
    assertEquals(true, detectCycleUndirectedGraph2.detectCycle());
  }
}
