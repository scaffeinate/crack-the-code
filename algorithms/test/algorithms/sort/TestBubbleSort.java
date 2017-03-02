/**
 * 
 */
package algorithms.sort;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sudharsanan Muralidharan
 */
public class TestBubbleSort {

  private String fileName = "input_files/test_sort";
  private BubbleSort<Integer> bubbleSort = null;
  private Scanner in = null;

  @Before
  public void setup() throws FileNotFoundException {
    in = new Scanner(new FileReader(fileName));
    bubbleSort = new BubbleSort<Integer>();
  }

  @After
  public void teardown() {
    if (in != null) {
      in.close();
    }
    in = null;
    bubbleSort = null;
  }

  @Test
  public void testBubbleSort() {
    while (in.hasNextLine()) {
      String line = in.nextLine();
      String[] values = line.split(" ");
      Integer[] arr = new Integer[values.length];
      for (int i = 0; i < values.length; i++) {
        arr[i] = Integer.parseInt(values[i]);
      }

      Integer[] expected = arr.clone();
      bubbleSort.sort(arr);
      Arrays.sort(expected);

      boolean eq = true;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i].intValue() != expected[i].intValue()) {
          eq = false;
          break;
        }
      }

      assertTrue(eq);
    }
  }
}
