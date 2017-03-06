package algoritms.problems;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.ConnectedComponents;
import algorithms.util.InputUtil;

public class TestConnectedComponents {
  private static final String basePath = "input_files/problems/connected_components/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private ConnectedComponents connectedComponents = null;

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
    connectedComponents = new ConnectedComponents();
  }

  @After
  public void tearDownTest() {
    connectedComponents = null;
  }

  @Test
  public void testConnectedComponentsTestCase1() {
    String[] input = inputList.get(0);
    connectedComponents.constructGraph(input);
    Integer[] expected = new Integer[] { 1, 3, 6, 7, 10 };
    List<Integer> actual = new ArrayList<Integer>();
    actual.addAll(connectedComponents.connectedComponents());
    assertConnectedComponents(input, expected, actual);
  }

  @Test
  public void testConnectedComponentsTestCase2() {
    String[] input = inputList.get(1);
    connectedComponents.constructGraph(input);
    Integer[] expected = new Integer[] { 6 };
    List<Integer> actual = new ArrayList<Integer>();
    actual.addAll(connectedComponents.connectedComponents());
    assertConnectedComponents(input, expected, actual);
  }

  @Test
  public void testConnectedComponentsTestCase3() {
    String[] input = inputList.get(2);
    connectedComponents.constructGraph(input);
    Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    List<Integer> actual = new ArrayList<Integer>();
    actual.addAll(connectedComponents.connectedComponents());
    assertConnectedComponents(input, expected, actual);
  }

  private void assertConnectedComponents(String[] input, Integer[] expected, List<Integer> actual) {
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, containsInAnyOrder(expected));

    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("sameComponent")) {
        assertEquals(connectedComponents.sameComponent(values[1], values[2]), Boolean.parseBoolean(values[3]));
      }
    }
  }
}
