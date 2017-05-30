package algorithms.graph;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestBellmanFordShortestPath {
  private static final String basePath = "input_files/graph/shortest_path/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private BellmanFordShortestPath bellmanFord = null;

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
    bellmanFord = new BellmanFordShortestPath();
  }

  @After
  public void tearDownTest() {
    bellmanFord = null;
  }

  @Test
  public void testBellmanFordShortestPathTestCase1() {
    String[] input = inputList.get(0);
    bellmanFord.constructGraph(input);
    assertShortestPath(input);
  }

  @Test
  public void testBellmanFordShortestPathTestCase2() {
    String[] input = inputList.get(1);
    bellmanFord.constructGraph(input);
    assertShortestPath(input);
  }

  @Test
  public void testBellmanFordShortestPathTestCase3() {
    String[] input = inputList.get(2);
    bellmanFord.constructGraph(input);
    assertShortestPath(input);
  }
  
  @Test
  public void testBellmanFordShortestPathTestCase4() {
    String[] input = inputList.get(3);
    bellmanFord.constructGraph(input);
    assertShortestPath(input);
  }

  private void assertShortestPath(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "compute":
        bellmanFord.computeShortestPath(values[1]);
        break;
      case "shortestPath":
        String[] expected = values[2].split(",");
        if (expected[0].equals("empty")) {
          assertThat(bellmanFord.getShortestPathTo(values[1]), IsEmptyCollection.empty());
        } else {
          assertThat(bellmanFord.getShortestPathTo(values[1]), contains(expected));
        }
        break;
      case "shortestDistance":
        Integer expectedDistance = null;
        if (values[2].equals("infinity")) {
          expectedDistance = Integer.MAX_VALUE;
        } else if (values[2].equals("-infinity")) {
          expectedDistance = Integer.MIN_VALUE;
        } else {
          expectedDistance = Integer.parseInt(values[2]);
        }
        assertThat(bellmanFord.getShortestDistanceTo(values[1]), is(expectedDistance));
        break;
      }
    }
  }
}
