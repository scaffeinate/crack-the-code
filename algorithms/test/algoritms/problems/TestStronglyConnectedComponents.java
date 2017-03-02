package algoritms.problems;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.problems.StronglyConnectedComponents;
import algorithms.util.InputUtil;
import datastructures.graph.DirectedGraph;
import datastructures.graph.Vertex;

public class TestStronglyConnectedComponents {

  private StronglyConnectedComponents stronglyConnectedComponents = null;
  private String basePath = "input_files/problems/strongly_connected_components/";
  private DirectedGraph<String> graph = null;

  @Before
  public void setup() {
    stronglyConnectedComponents = new StronglyConnectedComponents();
  }

  @After
  public void teardownClass() {
    stronglyConnectedComponents = null;
    graph = null;
  }

  @Test
  public void testStronglyConnectedComponentsTestCase1() {
    String inputFile = basePath + "test_case_1";
    String[] input = InputUtil.readContents(inputFile);
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
    String inputFile = basePath + "test_case_2";
    String[] input = InputUtil.readContents(inputFile);
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
  
  
  private void sort(List<List<String>> list) {
    Collections.sort(list, new Comparator<List<String>>() {
      @Override
      public int compare(List<String> o1, List<String> o2) {
        return Integer.valueOf(o2.size()).compareTo(Integer.valueOf(o1.size()));
      }
    });
  }
}
