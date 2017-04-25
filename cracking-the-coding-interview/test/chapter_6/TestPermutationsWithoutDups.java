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

public class TestPermutationsWithoutDups {
  private static final String basePath = "input_files/chapter_6/permutations_without_dups/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static PermutaionWithoutDups permutations = null;

  @BeforeClass
  public static void setup() {
    permutations = new PermutaionWithoutDups();
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
    List<String> actual2 = permutations.permutationsIterative(input[0]);
    assertStringPermutations(actual, actual2, expected);
  }

  @Test
  public void testStringPermutationsTestCase2() {
    String[] input = inputList.get(1);
    String[] expected = new String[] { "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda",
        "bdac", "bdca", "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab",
        "dcba" };
    List<String> actual = permutations.permutations(input[0]);
    List<String> actual2 = permutations.permutationsIterative(input[0]);
    assertStringPermutations(actual, actual2, expected);
  }

  private void assertStringPermutations(List<String> actual, List<String> actual2, String[] expected) {
    assertThat(actual, hasSize(expected.length));
    assertThat(actual, containsInAnyOrder(expected));

    assertThat(actual, hasSize(actual2.size()));
    assertThat(actual, containsInAnyOrder(actual2.toArray()));
  }
}
