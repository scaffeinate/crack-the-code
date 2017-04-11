package linked_list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;
import linked_list.CloneLinkedListPsuedo.CustomLinkedListPsuedo;
import linked_list.CloneLinkedListPsuedo.LinkedListNodePsuedo;

public class TestCloneLinkedListPsuedo {
  private static final String basePath = "input_files/linked_list/clone_linked_list_pseudo/";
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3", "test_case_4" };
  private static CloneLinkedListPsuedo cloneLinkedList = null;

  @BeforeClass
  public static void setup() {
    for (String testCase : testCases) {
      inputList.add(InputUtil.readContents(basePath + testCase));
    }
  }

  @AfterClass
  public static void teardown() {
    cloneLinkedList = null;
    inputList = null;
  }

  @Before
  public void setupTestCase() {
    cloneLinkedList = new CloneLinkedListPsuedo();
  }

  @Test
  public void testCloneLinkedListPsuedoTestCase1() {
    String[] values = inputList.get(0);
    assertCloneLinkedLists(values);
  }

  @Test
  public void testCloneLinkedListPsuedoTestCase2() {
    String[] values = inputList.get(1);
    assertCloneLinkedLists(values);
  }

  @Test
  public void testCloneLinkedListPsuedoTestCase3() {
    String[] values = inputList.get(2);
    assertCloneLinkedLists(values);
  }

  @Test
  public void testCloneLinkedListPsuedoTestCase4() {
    String[] values = inputList.get(3);
    assertCloneLinkedLists(values);
  }

  private void assertCloneLinkedLists(String[] values) {
    CustomLinkedListPsuedo original = cloneLinkedList.constructList(values);
    String expectedOutput = formatList(original);
    CustomLinkedListPsuedo output = cloneLinkedList.clone(original);
    String actualOutput = formatList(output);
    assertEquals(expectedOutput, actualOutput);
  }

  private String formatList(CustomLinkedListPsuedo list) {
    LinkedListNodePsuedo current = list.head;
    StringBuilder builder = new StringBuilder();
    while (current != null) {
      builder.append(current.data).append("->").append((current.next != null) ? current.next.data : "null").append("=>")
          .append((current.psuedo != null) ? current.psuedo.data : "null").append(" ");
      current = current.next;
    }

    return builder.toString();
  }
}
