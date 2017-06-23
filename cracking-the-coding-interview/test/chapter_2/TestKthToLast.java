package chapter_2;

import datastructures.lists.CustomLinkedList;
import datastructures.util.InputUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sudhar on 6/2/17.
 */
public class TestKthToLast {
    private static String inputFile = "input_files/chapter_2/kth_to_last/test_case";
    private static KthToLast kthToLast;
    private static String[] input = null;

    @BeforeClass
    public static void setup() {
        kthToLast = new KthToLast();
        input = InputUtil.readContents(inputFile);
    }

    @AfterClass
    public static void teardown() {
        kthToLast = null;
        input = null;
    }

    @Test
    public void testKthToLastTestCase1() {
        assertKthToLast(input[0]);
    }

    @Test
    public void testKthToLastTestCase2() {
        assertKthToLast(input[1]);
    }

    @Test
    public void testKthToLastTestCase3() {
        assertKthToLast(input[2]);
    }

    private void assertKthToLast(String input) {
        String[] elements;
        int k = 0, expected = 0;
        String[] values = input.split(" ");
        elements = values[0].split(":");
        k = Integer.parseInt(values[1]);
        expected = Integer.parseInt(values[2]);

        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        for (String e : elements) {
            if (e != null && !e.trim().isEmpty()) {
                list.add(Integer.parseInt(e));
            }
        }

        assertEquals(expected, kthToLast.findElement(list, k));
        assertEquals(expected, kthToLast.findElement2(list, k));
    }
}
