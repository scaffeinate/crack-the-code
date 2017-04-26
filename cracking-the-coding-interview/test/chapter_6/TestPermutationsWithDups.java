package chapter_6;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestPermutationsWithDups {
  private static final String basePath = "input_files/chapter_6/permutations_with_dups/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static PermutationsWithDups permutations = null;

  @BeforeClass
  public static void setup() {
    permutations = new PermutationsWithDups();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    permutations = null;
    testCases = null;
    inputList = null;
  }

  @Test
  public void testStringPermutationsTestCase1() {
    String[] input = inputList.get(0);
    String[] expected = new String[] { "1234", "1243", "1324", "1342", "1423", "1432", "2134", "2143", "2314", "2341",
        "2413", "2431", "3124", "3142", "3214", "3241", "3412", "3421", "4123", "4132", "4213", "4231", "4312",
        "4321" };
    List<String> actual = permutations.permutations(input[0]);
    assertStringPermutations(actual, expected);
  }

  @Test
  public void testStringPermutationsTestCase2() {
    String[] input = inputList.get(1);
    String[] expected = new String[] { "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda",
        "bdac", "bdca", "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab",
        "dcba" };
    List<String> actual = permutations.permutations(input[0]);
    assertStringPermutations(actual, expected);
  }

  @Test
  public void testStringPermutationsTestCase3() {
    String[] input = inputList.get(2);
    String[] expected = new String[] { "aabc", "aacb", "abac", "abca", "acab", "acba", "baac", "baca", "bcaa", "caab",
        "caba", "cbaa" };
    List<String> actual = permutations.permutations(input[0]);
    assertStringPermutations(actual, expected);
  }

  private void assertStringPermutations(List<String> actual, String[] expected) {
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, containsInAnyOrder(expected));
  }
}
