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

public class TestShortestPathDAG {
  private static final String basePath = "input_files/graph/shortest_path_dag/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private ShortestPathDAG shortestPathDAG = null;

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
    shortestPathDAG = new ShortestPathDAG();
  }

  @After
  public void tearDownTest() {
    shortestPathDAG = null;
  }

  @Test
  public void testShortestPathDAGTestCase1() {
    String[] input = inputList.get(0);
    shortestPathDAG.constructGraph(input);
    assertShortestPath(input);
  }
  @Test
  public void testShortestPathDAGTestCase2() {
    String[] input = inputList.get(1);
    shortestPathDAG.constructGraph(input);
    assertShortestPath(input);
  }
  
  private void assertShortestPath(String[] input) {
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "compute":
        shortestPathDAG.computeShortestPath(values[1]);
        break;
      case "shortestPath":
        String[] expected = values[2].split(",");
        if(expected[0].equals("empty")) {
          assertThat(shortestPathDAG.getShortestPathTo(values[1]), IsEmptyCollection.empty());
        } else {
          assertThat(shortestPathDAG.getShortestPathTo(values[1]), contains(expected));
        }
        break;
      case "shortestDistance":
        Integer expectedDistance = Integer.MAX_VALUE;
        if(!values[2].equals("infinity")) {
          expectedDistance = Integer.parseInt(values[2]);
        }
        assertThat(shortestPathDAG.getShortestDistanceTo(values[1]), is(expectedDistance));
        break;
      }
    }
  }
}
