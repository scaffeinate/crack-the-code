package chapter_8;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestPowerSet {
  private static String inputFile = "input_files/chapter_8/power_set/test_case";
  private static PowerSet powerSet = null;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    powerSet = new PowerSet();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    powerSet = null;
    input = null;
  }

  @Test
  public void testPowerSetTestCase1() {
    List<List<String>> expected = new ArrayList<List<String>>();
    expected.add(Arrays.asList(new String[] {}));
    expected.add(Arrays.asList(new String[] { "a" }));
    expected.add(Arrays.asList(new String[] { "b" }));
    expected.add(Arrays.asList(new String[] { "c" }));
    expected.add(Arrays.asList(new String[] { "a", "b" }));
    expected.add(Arrays.asList(new String[] { "a", "c" }));
    expected.add(Arrays.asList(new String[] { "b", "c" }));
    expected.add(Arrays.asList(new String[] { "a", "b", "c" }));
    assertPowerSet(input[0], expected);
  }

  @Test
  public void testPowerSetTestCase2() {
    List<List<String>> expected = new ArrayList<List<String>>();
    expected.add(Arrays.asList(new String[] {}));
    expected.add(Arrays.asList(new String[] { "1" }));
    expected.add(Arrays.asList(new String[] { "1", "2" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "3" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "3", "4" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "3", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "3", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "4" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "2", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "3" }));
    expected.add(Arrays.asList(new String[] { "1", "3", "4" }));
    expected.add(Arrays.asList(new String[] { "1", "3", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "3", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "4" }));
    expected.add(Arrays.asList(new String[] { "1", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "1", "5" }));
    expected.add(Arrays.asList(new String[] { "2" }));
    expected.add(Arrays.asList(new String[] { "2", "3" }));
    expected.add(Arrays.asList(new String[] { "2", "3", "4" }));
    expected.add(Arrays.asList(new String[] { "2", "3", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "2", "3", "5" }));
    expected.add(Arrays.asList(new String[] { "2", "4" }));
    expected.add(Arrays.asList(new String[] { "2", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "2", "5" }));
    expected.add(Arrays.asList(new String[] { "3" }));
    expected.add(Arrays.asList(new String[] { "3", "4" }));
    expected.add(Arrays.asList(new String[] { "3", "4", "5" }));
    expected.add(Arrays.asList(new String[] { "3", "5" }));
    expected.add(Arrays.asList(new String[] { "4" }));
    expected.add(Arrays.asList(new String[] { "4", "5" }));
    expected.add(Arrays.asList(new String[] { "5" }));
    assertPowerSet(input[1], expected);
  }

  private void assertPowerSet(String input, List<List<String>> expected) {
    String[] values = input.split(" ");
    Set<String> set = new HashSet<String>();
    for (List<String> list : expected) {
      set.add(listToString(list));
    }

    List<List<String>> output = powerSet.subsets(values);
    assertPowerSet(set, output);

    output = powerSet.subsetsIterative(values);
    assertPowerSet(set, output);

    output = powerSet.subsetsUsingBits(values);
    assertPowerSet(set, output);
  }

  private void assertPowerSet(Set<String> set, List<List<String>> output) {
    assertThat(output, hasSize(set.size()));
    Set<String> outputSet = new HashSet<String>();

    for (List<String> list : output) {
      outputSet.add(listToString(list));
    }

    for (String s : set) {
      assertTrue(outputSet.contains(s));
    }
  }

  private String listToString(List<String> list) {
    StringBuilder builder = new StringBuilder();
    Collections.sort(list);

    for (String s : list) {
      builder.append(s);
    }
    return builder.toString();
  }
}
