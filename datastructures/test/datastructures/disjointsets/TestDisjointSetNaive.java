package datastructures.disjointsets;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestDisjointSetNaive {
  private static DisjointSetNaive<Integer> disjointSetNaive = null;
  private static final String basePath = "input_files/disjoint_sets/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    disjointSetNaive = new DisjointSetNaive<Integer>();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    disjointSetNaive = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testDisjointSetNaiveTestCase1() {
    String[] input = inputList.get(0);
    Integer[] expected = new Integer[] { 4, 4, 4, 4, 4, 4 };
    assertDisjointSet(input, expected);
  }

  @Test
  public void testDisjointSetNaiveTestCase2() {
    String[] input = inputList.get(1);
    Integer[] expected = new Integer[] { 1, 1, 4, 4, 4, 1 };
    assertDisjointSet(input, expected);
  }

  @Test
  public void testDisjointSetNaiveTestCase3() {
    String[] input = inputList.get(2);
    Integer[] expected = new Integer[] { 1, 2, 2, 2, 1 };
    assertDisjointSet(input, expected);
  }

  private void assertDisjointSet(String[] input, Integer[] expected) {
    Integer[] actual = new Integer[expected.length];
    int i = 0;

    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];
      switch (action) {
      case "makeSet":
        disjointSetNaive.makeSet(Integer.parseInt(values[1]));
        break;
      case "union":
        disjointSetNaive.union(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
        break;
      case "findSet":
        actual[i] = disjointSetNaive.findSet(Integer.parseInt(values[1]));
        i++;
        break;
      }
    }

    assertArrayEquals(expected, actual);
  }
}
