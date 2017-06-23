package chapter_2;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;
import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudhar on 6/1/17.
 */
public class TestRemoveDuplicates {
    private static String inputFile = "input_files/chapter_2/remove_duplicates/test_case";
    private static RemoveDuplicates removeDuplicates;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        removeDuplicates = new RemoveDuplicates();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        removeDuplicates = null;
        input = null;
    }

    @Test
    public void testRemoveDuplicatesTestCase1() {
        assertRemoveDuplicates(input[0]);
    }

    @Test
    public void testRemoveDuplicatesTestCase2() {
        assertRemoveDuplicates(input[1]);
    }

    @Test
    public void testRemoveDuplicatesTestCase3() {
        assertRemoveDuplicates(input[2]);
    }

    private void assertRemoveDuplicates(String input) {
        String[] lists = input.split(" ");
        String[] elements = lists[0].split(":");
        String[] elements2 = lists[1].split(":");
        CustomLinkedList<Integer> actual = new CustomLinkedList<Integer>();
        CustomLinkedList<Integer> expected = new CustomLinkedList<Integer>();

        for (String e : elements) {
            if (e != null && !e.trim().isEmpty()) {
                actual.add(Integer.parseInt(e));
            }
        }

        for (String e : elements2) {
            expected.add(Integer.parseInt(e));
        }

        CustomLinkedList<Integer> inputList = actual.clone();
        removeDuplicates.remove(inputList);
        assertCustomLinkedListEquals(expected, inputList);

        inputList = actual.clone();
        removeDuplicates.removeSet(inputList);
        assertCustomLinkedListEquals(expected, inputList);
    }

    private void assertCustomLinkedListEquals(CustomLinkedList<Integer> expected, CustomLinkedList<Integer> actual) {
        LinkedListNode<Integer> current = expected.head();
        LinkedListNode<Integer> current2 = actual.head();

        int size = 0, size2 = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        while (current2 != null) {
            size2++;
            current2 = current2.next;
        }

        assertEquals(size, size2);

        current = expected.head();
        current2 = actual.head();

        while (current != null && current2 != null) {
            assertEquals(current.data, current2.data);
            current = current.next;
            current2 = current2.next;
        }
    }

}
