package datastructures.trie;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.tree.Trie;
import datastructures.util.InputUtil;

public class TestTrie {
  private static final String basePath = "input_files/trie/";
  private static String[] testCases = new String[] { "test_case_1", "test_case_2" };
  private static List<String[]> inputList = new ArrayList<String[]>();
  private Trie trie = null;

  @BeforeClass
  public static void setup() {
    for (String testCase : testCases) {
      String inputFile = basePath + testCase;
      inputList.add(InputUtil.readContents(inputFile));
    }
  }

  @AfterClass
  public static void teardown() {
    testCases = null;
    inputList = null;
  }

  @Before
  public void setupTest() {
    trie = new Trie();
  }

  @After
  public void teardownTest() {
    trie = null;
  }
  
  @Test
  public void testTrieTestCase1() {
    String[] input = inputList.get(0);
  }
}
