package algoritms.problems;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.problems.ExcelCell;
import algorithms.util.InputUtil;

public class TestExcelCell {
  private static final String fileName = "input_files/problems/excell_cell";
  private static String[] input = null;
  private static ExcelCell excelCell = null;

  @BeforeClass
  public static void setup() {
    excelCell = new ExcelCell();
    input = InputUtil.readContents(fileName);
  }

  @AfterClass
  public static void teardown() {
    excelCell = null;
    input = null;
  }

  @Test
  public void testExcelCellTestCase() {
    for (String line : input) {
      String[] values = line.split(" ");
      switch (values[0]) {
      case "cell":
        
        break;
      case "column":
        break;
      }
    }
  }
}
