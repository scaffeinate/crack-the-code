package array;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestFindAllPairsABCD {
  private static String basePath = "input_files/array/find_all_pairs_abcd/";
  private static FindAllPairsABCD findAllPairsABCD;
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();

  @BeforeClass
  public static void setup() {
    findAllPairsABCD = new FindAllPairsABCD();
    for (String testCase : testCases) {
      inputList.add(InputUtil.readContents(basePath + testCase));
    }
  }

  @AfterClass
  public static void teardown() {
    findAllPairsABCD = null;
    inputList = null;
  }

  @Test
  public void testFindAllPairsABCDTestCase1() {
    assertFindAllPairsABCD(inputList.get(0));
  }

  @Test
  public void testFindAllPairsABCDTestCase2() {
    assertFindAllPairsABCD(inputList.get(1));
  }

  @Test
  public void testFindAllPairsABCDTestCase3() {
    assertFindAllPairsABCD(inputList.get(2));
  }

  private void assertFindAllPairsABCD(String[] input) {
    String[] arrValues = input[0].split(",");
    int[] arr = new int[arrValues.length];

    for (int i = 0; i < arrValues.length; i++) {
      arr[i] = Integer.parseInt(arrValues[i]);
    }

    Map<Integer, List<Integer[]>> expected = new HashMap<Integer, List<Integer[]>>();
    for (int i = 1; i < input.length; i++) {
      List<Integer[]> setList = new ArrayList<Integer[]>();
      String[] values = input[i].split(":");
      expected.put(Integer.parseInt(values[0]), setList);

      String[] tupleValues = values[1].split(" and ");
      for (String value : tupleValues) {
        Integer[] tuple = new Integer[2];
        String[] elements = value.split(",");
        tuple[0] = Integer.parseInt(elements[0]);
        tuple[1] = Integer.parseInt(elements[1]);
        setList.add(tuple);
      }
    }

    Map<Integer, List<Integer[]>> output = findAllPairsABCD.findAllPairs(arr);

    for (Integer key : expected.keySet()) {
      List<Integer[]> expectedList = expected.get(key);
      List<Integer[]> outputList = output.get(key);
      for (int i = 0; i < expectedList.size(); i++) {
        assertThat(Arrays.asList(expectedList.get(i)), containsInAnyOrder(outputList.get(i)));
      }
    }
  }
}
