package binarytree;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.util.InputUtil;

public class TestCheckSortedSubSequenceBST {
  private static final String basePath = "input_files/binarytree/check_sorted_subsequence_bst/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2", "test_case_3" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private static CheckSortedSubSequenceBST checkSubSeq = null;

  @BeforeClass
  public static void setup() {
    checkSubSeq = new CheckSortedSubSequenceBST();
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    checkSubSeq = null;
    inputList = null;
  }

  @Test
  public void testCheckSortedSubSeqBSTTestCase1() {
    String[] input = inputList.get(0);
    assertCheckSortedSubSeq(input);
  }

  @Test
  public void testCheckSortedSubSeqBSTTestCase2() {
    String[] input = inputList.get(1);
    assertCheckSortedSubSeq(input);
  }

  @Test
  public void testCheckSortedSubSeqBSTTestCase3() {
    String[] input = inputList.get(2);
    assertCheckSortedSubSeq(input);
  }

  private void assertCheckSortedSubSeq(String[] input) {
    checkSubSeq.constructTree(input);
    for (String line : input) {
      String[] values = line.split(" ");
      if (values[0].equals("checkSeq")) {
        String[] seqValues = values[1].split(",");
        int[] sequence = new int[seqValues.length];
        for (int i = 0; i < seqValues.length; i++) {
          sequence[i] = Integer.parseInt(seqValues[i]);
        }
        assertEquals(Boolean.parseBoolean(values[2]), checkSubSeq.checkIfSeqExists(sequence));
      }
    }
  }
}
