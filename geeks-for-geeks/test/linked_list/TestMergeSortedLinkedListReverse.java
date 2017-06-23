package linked_list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestMergeSortedLinkedListReverse {
    private static final String basePath = "input_files/linked_list/merge_sorted_linked_list_reverse/";
    private static List<String[]> inputList = new ArrayList<String[]>();
    private static String[] testCases = new String[]{"test_case_1", "test_case_2", "test_case_3", "test_case_4"};
    private static MergeSortedLinkedListsReverse mergeSorted = null;

    @BeforeClass
    public static void setup() {
        for (String testCase : testCases) {
            inputList.add(InputUtil.readContents(basePath + testCase));
        }
    }

    @AfterClass
    public static void teardown() {
        mergeSorted = null;
        inputList = null;
    }

    @Before
    public void setupTestCase() {
        mergeSorted = new MergeSortedLinkedListsReverse();
    }

    @Test
    public void testMergeSortedLinkedListReverseTestCase1() {
        String[] values = inputList.get(0);
        assertMergeSortedLists(values);
    }

    @Test
    public void testMergeSortedLinkedListReverseTestCase2() {
        String[] values = inputList.get(1);
        assertMergeSortedLists(values);
    }

    @Test
    public void testMergeSortedLinkedListReverseTestCase3() {
        String[] values = inputList.get(2);
        assertMergeSortedLists(values);
    }

    @Test
    public void testMergeSortedLinkedListReverseTestCase4() {
        String[] values = inputList.get(3);
        assertMergeSortedLists(values);
    }

    @SuppressWarnings("unchecked")
    private void assertMergeSortedLists(String[] input) {
        mergeSorted.constructLists(input[0].split(" "), input[1].split(" "));
        String[] values = input[2].split(" ");
        List<Integer> expected = new ArrayList<Integer>();
        for (String v : values) {
            if (!v.equals("NULL")) {
                expected.add(Integer.parseInt(v));
            }
        }

        assertThat(Arrays.asList(expected), contains(Arrays.asList(mergeSorted.merge().toArray())));
        assertThat(Arrays.asList(expected), contains(Arrays.asList(mergeSorted.merge2().toArray())));
        assertThat(Arrays.asList(expected), contains(Arrays.asList(mergeSorted.merge3().toArray())));
    }
}
