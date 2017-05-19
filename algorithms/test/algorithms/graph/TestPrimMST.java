package algorithms.graph;

import algorithms.util.InputUtil;
import datastructures.graph.Edge;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TestPrimMST {
  private static final String basePath = "input_files/graph/minimum_spanning_tree/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private PrimMST primMST = null;

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
    primMST = new PrimMST();
  }

  @After
  public void tearDownTest() {
    primMST = null;
  }

  @Test
  public void testPrimMSTTestCase1() {
    String[] input = inputList.get(0);
    primMST.constructGraph(input);
    List<Edge<String>> mst = primMST.minimumSpanningTree();
    String[] expected = new String[] { "AB", "BD", "CD" };
    assertMST(mst, expected, 3);
  }

  @Test
  public void testPrimMSTTestCase2() {
    String[] input = inputList.get(1);
    primMST.constructGraph(input);
    List<Edge<String>> mst = primMST.minimumSpanningTree();
    String[] expected = new String[] { "AD", "BC", "CD", "EF", "CF" };
    assertMST(mst, expected, 9);
  }

  @Test
  public void testPrimMSTTestCase3() {
    String[] input = inputList.get(2);
    primMST.constructGraph(input);
    List<Edge<String>> mst = primMST.minimumSpanningTree();
    String[] expected = new String[] { "AD", "AB", "BC", "AC", "CH", "GH", "FG", "AE", "DE" };
    assertMST(mst, expected, 19);
  }
  
  @Test
  public void testPrimMSTTestCase4() {
    String[] input = inputList.get(3);
    primMST.constructGraph(input);
    List<Edge<String>> mst = primMST.minimumSpanningTree();
    String[] expected = new String[] { "AD", "CD", "BC", "CF", "EF" };
    assertMST(mst, expected, 9);
  }

  private void assertMST(List<Edge<String>> mst, String[] expected, int expectedWeight) {
    List<String> actual = new ArrayList<String>();
    int weight = 0;
    for (Edge<String> edge : mst) {
      actual.add(lexographicalOrder(new String[] { edge.sourceVertex.label, edge.destVertex.label }));
      weight += edge.weight;
    }
    for(String s:actual) {
      assertThat(Arrays.asList(expected), hasItem(s));
    }
    assertEquals(weight, expectedWeight);
  }

  private String lexographicalOrder(String[] arr) {
    Arrays.sort(arr);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);
    }

    return builder.toString();
  }
}
