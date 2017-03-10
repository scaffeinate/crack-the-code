package algorithms.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;
import datastructures.graph.Edge;

public class TestKruskalMST {
  private static final String basePath = "input_files/graph/minimum_spanning_tree/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private KruskalMST kruskalMST = null;

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
    kruskalMST = new KruskalMST();
  }

  @After
  public void tearDownTest() {
    kruskalMST = null;
  }

  @Test
  public void testKruskalMSTTestCase1() {
    String[] input = inputList.get(0);
    kruskalMST.constructGraph(input);
    List<Edge<String>> mst = kruskalMST.minimumSpanningTree();
    String[] expected = new String[] { "AB", "BD", "CD"};
    assertMST(mst, expected, 3);
  }
  

  @Test
  public void testKruskalMSTTestCase2() {
    String[] input = inputList.get(1);
    kruskalMST.constructGraph(input);
    List<Edge<String>> mst = kruskalMST.minimumSpanningTree();
    String[] expected = new String[] { "AD", "BC", "CD", "EF", "CF"};
    assertMST(mst, expected, 9);
  }
  
  @Test
  public void testKruskalMSTTestCase3() {
    String[] input = inputList.get(2);
    kruskalMST.constructGraph(input);
    List<Edge<String>> mst = kruskalMST.minimumSpanningTree();
    String[] expected = new String[] { "AD", "AB", "AC", "CH", "GH", "FG", "AE"};
    assertMST(mst, expected, 19);
  }
  
  @Test
  public void testKruskalMSTTestCase4() {
    String[] input = inputList.get(3);
    kruskalMST.constructGraph(input);
    List<Edge<String>> mst = kruskalMST.minimumSpanningTree();
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
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, containsInAnyOrder(expected));
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
