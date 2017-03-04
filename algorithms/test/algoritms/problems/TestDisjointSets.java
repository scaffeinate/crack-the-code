package algoritms.problems;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.DisjointSets;
import algorithms.util.InputUtil;

public class TestDisjointSets {
  private static DisjointSets disjointSets = null;
  private static final String basePath = "input_files/problems/disjoint_sets/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    disjointSets = new DisjointSets();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    disjointSets = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testDisjointSetsTestCase1() {
    String[] input = inputList.get(0);
    disjointSets.constructDisjointSet(input);
    Integer[] expected = new Integer[] { 4, 4, 4, 4, 4, 4 };
    Integer[] actual = new Integer[expected.length];
    int i = 0;

    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("find")) {
        actual[i] = disjointSets.find(Integer.parseInt(values[1]));
        i++;
      }
    }

    assertArrayEquals(actual, expected);
  }
  
  @Test
  public void testDisjointSetsTestCase2() {
    String[] input = inputList.get(1);
    disjointSets.constructDisjointSet(input);
    Integer[] expected = new Integer[] { 1, 1, 4, 4, 4, 1 };
    Integer[] actual = new Integer[expected.length];
    int i = 0;

    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("find")) {
        actual[i] = disjointSets.find(Integer.parseInt(values[1]));
        i++;
      }
    }

    assertArrayEquals(actual, expected);
  }
  
  @Test
  public void testDisjointSetsTestCase3() {
    String[] input = inputList.get(2);
    disjointSets.constructDisjointSet(input);
    Integer[] expected = new Integer[] { 1, 2, 2, 2, 1 };
    Integer[] actual = new Integer[expected.length];
    int i = 0;

    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("find")) {
        actual[i] = disjointSets.find(Integer.parseInt(values[1]));
        i++;
      }
    }

    assertArrayEquals(actual, expected);
  }
}
