package array;

import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

/**
 * Created by sudharti on 6/4/17.
 */
public class TestUnionAndIntersection {
  private static String inputFile = "input_files/array/union_and_intersection/test_case";
  private static UnionAndIntersection unionAndIntersection;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    unionAndIntersection = new UnionAndIntersection();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    unionAndIntersection = null;
    input = null;
  }

  @Test
  public void testUnionAndIntersectionTestCase1() {
    assertUnionAndIntersection(input[0]);
  }

  @Test
  public void testUnionAndIntersectionTestCase2() {
    assertUnionAndIntersection(input[1]);
  }

  @Test
  public void testUnionAndIntersectionTestCase3() {
    assertUnionAndIntersection(input[2]);
  }

  @Test
  public void testUnionAndIntersectionTestCase4() {
    assertUnionAndIntersection(input[3]);
  }

  private void assertUnionAndIntersection(String input) {
    String[] values = input.split(" ");
    String[] arrValues = values[0].split(",");
    String[] arr2Values = values[1].split(",");
    String[] expectedUnionValues = values[2].split(",");
    String[] expectedIntersectionValues = values[3].split(",");

    Integer[] arr = convertStringArrToIntArr(arrValues);
    Integer[] arr2 = convertStringArrToIntArr(arr2Values);
    Integer[] expectedUnion = convertStringArrToIntArr(expectedUnionValues);
    Integer[] expectedIntersection = convertStringArrToIntArr(expectedIntersectionValues);

    List<Integer> actualUnion = unionAndIntersection.union(arr, arr2);
    List<Integer> actualIntersection = unionAndIntersection.intersection(arr, arr2);

    assertThat(actualUnion, contains(expectedUnion));
    assertThat(actualIntersection, contains(expectedIntersection));
  }

  private Integer[] convertStringArrToIntArr(String[] values) {
    Integer[] arr = new Integer[values.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    return arr;
  }
}
