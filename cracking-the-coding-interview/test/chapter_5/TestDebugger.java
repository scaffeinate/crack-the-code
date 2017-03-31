package chapter_5;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.util.InputUtil;

public class TestDebugger {
  private static String inputFile = "input_files/chapter_5/debugger/test_case";
  private static Debugger debugger;
  private static String[] input = null;

  @BeforeClass
  public static void setup() {
    debugger = new Debugger();
    input = InputUtil.readContents(inputFile);
  }

  @AfterClass
  public static void teardown() {
    debugger = null;
    input = null;
  }

  @Test
  public void testDebuggerCase() {
    for(String line:input) {
      String[] values = line.split(" ");
      assertEquals(debugger.powerOfTwo(Integer.parseInt(values[0])), Boolean.parseBoolean(values[1]));
    }
  }
}
