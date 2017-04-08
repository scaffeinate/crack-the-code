package linked_list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;
import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class TestMoveAllOccurancesToEnd {
  private static final String inputFile = "input_files/linked_list/move_all_occurances_to_end/test_case";
  private static String[] input = null;
  private static MoveAllOccurancesToEnd moveAllOccurances = null;

  @BeforeClass
  public static void setup() {
    moveAllOccurances = new MoveAllOccurancesToEnd();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    moveAllOccurances = null;
    input = null;
  }

  @Test
  public void testMoveAllOccurancesToEndTestCase1() {
    Integer[] expected = new Integer[] { 1, 4, 3, 2, 2 };
    String[] values = input[0].split(",");
    assertMoveAllOccurances(values[0].trim(), expected, Integer.parseInt(values[1].trim()));
  }

  @Test
  public void testMoveAllOccurancesToEndTestCase2() {
    Integer[] expected = new Integer[] { 7, 3, 10, 6, 6, 6 };
    String[] values = input[1].split(",");
    assertMoveAllOccurances(values[0].trim(), expected, Integer.parseInt(values[1].trim()));
  }

  private void assertMoveAllOccurances(String line, Integer[] expected, int key) {
    moveAllOccurances.constructLinkedList(line);
    CustomLinkedList<Integer> output = moveAllOccurances.moveAllOccurancesToEnd(key);
    Integer[] outputArr = new Integer[output.size()];
    LinkedListNode<Integer> head = output.head();
    int i = 0;
    while (head != null) {
      outputArr[i] = head.data;
      head = head.next;
      i++;
    }

    assertThat(Arrays.asList(expected), contains(outputArr));
  }
}
