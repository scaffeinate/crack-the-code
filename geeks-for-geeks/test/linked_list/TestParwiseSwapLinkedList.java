package linked_list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;
import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class TestParwiseSwapLinkedList {
    private static final String inputFile = "input_files/linked_list/pairwise_swap/test_case";
    private static String[] input = null;
    private static PairwiseSwapLinkedList pairwiseSwapLinkedList = null;

    @BeforeClass
    public static void setup() {
        pairwiseSwapLinkedList = new PairwiseSwapLinkedList();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        pairwiseSwapLinkedList = null;
        input = null;
    }

    @Test
    public void testPairwiseSwapLinkedListTestCase1() {
        Integer[] expected = new Integer[]{2, 1, 4, 3, 6, 5};
        assertPairwiseSwap(input[0], expected);
    }

    @Test
    public void testPairwiseSwapLinkedListTestCase2() {
        Integer[] expected = new Integer[]{2, 1, 4, 3, 6, 5, 7};
        assertPairwiseSwap(input[1], expected);
    }

    private void assertPairwiseSwap(String line, Integer[] expected) {
        pairwiseSwapLinkedList.constructLinkedList(line);
        CustomLinkedList<Integer> output = pairwiseSwapLinkedList.pairwiseSwap();
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
