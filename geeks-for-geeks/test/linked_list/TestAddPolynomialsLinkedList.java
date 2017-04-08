package linked_list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestAddPolynomialsLinkedList {
  private static final String basePath = "input_files/linked_list/add_polynomials_linked_list/";
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static AddPolynomialsLinkedList addPolynomialsLinkedList = null;

  @BeforeClass
  public static void setup() {
    addPolynomialsLinkedList = new AddPolynomialsLinkedList();
    for (String testCase : testCases) {
      inputList.add(InputUtil.readContents(basePath + testCase));
    }
  }

  @AfterClass
  public static void teardown() {
    addPolynomialsLinkedList = null;
    inputList = null;
  }

  @Test
  public void testAddPolynomialsLinkedListTestCase1() {
    String[] values = inputList.get(0);
    assertAddPolynomials(values);
  }

  @Test
  public void testAddPolynomialsLinkedListTestCase2() {
    String[] values = inputList.get(1);
    assertAddPolynomials(values);
  }

  @Test
  public void testAddPolynomialsLinkedListTestCase3() {
    String[] values = inputList.get(2);
    assertAddPolynomials(values);
  }

  private void assertAddPolynomials(String[] input) {
    addPolynomialsLinkedList.constructLinkedList(input[0], input[1]);
    String output = addPolynomialsLinkedList.addPolynomials();
    assertEquals(input[2], output);
  }
}
