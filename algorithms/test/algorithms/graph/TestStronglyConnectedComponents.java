package algorithms.graph;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Vertex;

public class TestStronglyConnectedComponents {

  private static StronglyConnectedComponents stronglyConnectedComponents = null;
  private static String basePath = "input_files/graph/strongly_connected_components/";
  private static DirectedGraph<String> graph = null;
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    stronglyConnectedComponents = new StronglyConnectedComponents();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardownClass() {
    stronglyConnectedComponents = null;
    graph = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testStronglyConnectedComponentsTestCase1() {
    String[] input = inputList.get(0);
    graph = stronglyConnectedComponents.constructGraph(input);
    List<List<Vertex<String>>> connectedComponents = stronglyConnectedComponents.getConnectedComponents(graph);
    List<List<String>> actualComponents = new ArrayList<List<String>>();

    for (List<Vertex<String>> component : connectedComponents) {
      List<String> list = new ArrayList<String>();
      for (Vertex<String> vertex : component) {
        list.add(vertex.label);
      }
      actualComponents.add(list);
    }

    List<List<String>> expectedComponents = new ArrayList<List<String>>();
    expectedComponents.add(Arrays.asList(new String[] { "d", "e", "g", "h", "i", "j" }));
    expectedComponents.add(Arrays.asList(new String[] { "a", "b", "c" }));
    expectedComponents.add(Arrays.asList(new String[] { "f" }));

    sort(actualComponents);
    
    assertThat(actualComponents, hasSize(3));
    assertEquals(actualComponents.size(), expectedComponents.size());

    for (int i = 0; i < actualComponents.size(); i++) {
      assertThat(actualComponents.get(i), containsInAnyOrder(expectedComponents.get(i).toArray()));
    }
  }
  
  @Test
  public void testStronglyConnectedComponentsTestCase2() {
    String[] input = inputList.get(1);
    graph = stronglyConnectedComponents.constructGraph(input);
    List<List<Vertex<String>>> connectedComponents = stronglyConnectedComponents.getConnectedComponents(graph);
    List<List<String>> actualComponents = new ArrayList<List<String>>();

    for (List<Vertex<String>> component : connectedComponents) {
      List<String> list = new ArrayList<String>();
      for (Vertex<String> vertex : component) {
        list.add(vertex.label);
      }
      actualComponents.add(list);
    }

    List<List<String>> expectedComponents = new ArrayList<List<String>>();
    expectedComponents.add(Arrays.asList(new String[] { "g", "h", "i", "j" }));
    expectedComponents.add(Arrays.asList(new String[] { "a", "b", "c" }));
    expectedComponents.add(Arrays.asList(new String[] { "d", "e", "f" }));
    expectedComponents.add(Arrays.asList(new String[] { "k" }));
    
    sort(actualComponents);

    assertThat(actualComponents, hasSize(4));
    assertEquals(actualComponents.size(), expectedComponents.size());

    for (int i = 0; i < actualComponents.size(); i++) {
      assertThat(actualComponents.get(i), containsInAnyOrder(expectedComponents.get(i).toArray()));
    }
  }
  
  @Test
  public void testStronglyConnectedComponentsTestCase3() {
    String[] input = inputList.get(2);
    graph = stronglyConnectedComponents.constructGraph(input);
    List<List<Vertex<String>>> connectedComponents = stronglyConnectedComponents.getConnectedComponents(graph);
    List<List<String>> actualComponents = new ArrayList<List<String>>();

    for (List<Vertex<String>> component : connectedComponents) {
      List<String> list = new ArrayList<String>();
      for (Vertex<String> vertex : component) {
        list.add(vertex.label);
      }
      actualComponents.add(list);
    }

    List<List<String>> expectedComponents = new ArrayList<List<String>>();
    expectedComponents.add(Arrays.asList(new String[] { "j", "e", "f", "g", "h", "i", "a", "b", "c", "d" }));
    
    sort(actualComponents);

    assertThat(actualComponents, hasSize(1));
    assertEquals(actualComponents.size(), expectedComponents.size());

    for (int i = 0; i < actualComponents.size(); i++) {
      assertThat(actualComponents.get(i), containsInAnyOrder(expectedComponents.get(i).toArray()));
    }
  }
  
  
  private void sort(List<List<String>> list) {
    Collections.sort(list, new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        return Integer.valueOf(o2.size()).compareTo(Integer.valueOf(o1.size()));
      }
    });
  }
}
