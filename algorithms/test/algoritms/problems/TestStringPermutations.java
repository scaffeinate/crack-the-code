package algoritms.problems;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.StringPermutations;
import datastructures.util.InputUtil;

public class TestStringPermutations {
  private static final String basePath = "input_files/problems/string_permutations/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static StringPermutations stringPermutations = null;

  @BeforeClass
  public static void setup() {
    stringPermutations = new StringPermutations();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    stringPermutations = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testStringPermutationsTestCase1() {
    String[] input = inputList.get(0);
    String[] expected = new String[] { "1234", "1243", "1324", "1342", "1432", "1423", "2134", "2143", "2314", "2341",
        "2431", "2413", "3214", "3241", "3124", "3142", "3412", "3421", "4231", "4213", "4321", "4312", "4132",
        "4123" };
    List<String> actual = stringPermutations.generatePermutations(input[0].toCharArray());
    assertStringPermutations(actual, expected);
  }

  @Test
  public void testStringPermutationsIterativeTestCase1() {
    String[] input = inputList.get(0);
    String[] expected = new String[] { "1234", "1243", "1324", "1342", "1432", "1423", "2134", "2143", "2314", "2341",
        "2431", "2413", "3214", "3241", "3124", "3142", "3412", "3421", "4231", "4213", "4321", "4312", "4132",
        "4123" };
    List<String> actual = stringPermutations.generatePermutationsIterative(input[0].toCharArray());
    assertStringPermutationsIterative(actual, expected);
  }

  @Test
  public void testStringPermutationsTestCase2() {
    String[] input = inputList.get(1);
    String[] expected = new String[] { "abcd", "abdc", "acbd", "acdb", "adcb", "adbc", "bacd", "badc", "bcad", "bcda",
        "bdca", "bdac", "cbad", "cbda", "cabd", "cadb", "cdab", "cdba", "dbca", "dbac", "dcba", "dcab", "dacb",
        "dabc" };
    List<String> actual = stringPermutations.generatePermutations(input[0].toCharArray());
    assertStringPermutations(actual, expected);
  }

  @Test
  public void testStringPermutationsIterativeTestCase2() {
    String[] input = inputList.get(1);
    String[] expected = new String[] { "abcd", "abdc", "acbd", "acdb", "adcb", "adbc", "bacd", "badc", "bcad", "bcda",
        "bdca", "bdac", "cbad", "cbda", "cabd", "cadb", "cdab", "cdba", "dbca", "dbac", "dcba", "dcab", "dacb",
        "dabc" };
    List<String> actual = stringPermutations.generatePermutationsIterative(input[0].toCharArray());
    assertStringPermutationsIterative(actual, expected);
  }

  @Test
  public void testStringPermutationsTestCase3() {
    String[] input = inputList.get(2);
    String[] expected = new String[] { "aabb", "aabb", "abab", "abba", "abba", "abab", "aabb", "aabb", "abab", "abba",
        "abba", "abab", "baab", "baba", "baab", "baba", "bbaa", "bbaa", "baba", "baab", "bbaa", "bbaa", "baba",
        "baab" };
    List<String> actual = stringPermutations.generatePermutations(input[0].toCharArray());
    assertStringPermutations(actual, expected);
  }

  @Test
  public void testStringPermutationsIterativeTestCase3() {
    String[] input = inputList.get(2);
    String[] expected = new String[] { "aabb", "aabb", "abab", "abba", "abba", "abab", "aabb", "aabb", "abab", "abba",
        "abba", "abab", "baab", "baba", "baab", "baba", "bbaa", "bbaa", "baba", "baab", "bbaa", "bbaa", "baba",
        "baab" };
    List<String> actual = stringPermutations.generatePermutationsIterative(input[0].toCharArray());
    assertStringPermutationsIterative(actual, expected);
  }

  private void assertStringPermutations(List<String> actual, String[] expected) {
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, contains(expected));
  }

  private void assertStringPermutationsIterative(List<String> actual, String[] expected) {
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, containsInAnyOrder(expected));
  }
}
