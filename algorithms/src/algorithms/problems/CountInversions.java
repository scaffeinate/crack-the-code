/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class CountInversions {

  private int countInversions(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          count++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_count_inversions");
    CountInversions countInversions = new CountInversions();
    for (String line : input) {
      String[] values = line.split(" ");
      int[] arr = new int[values.length];
      for (int i = 0; i < values.length; i++) {
        arr[i] = Integer.parseInt(values[i]);
      }
      System.out.println("Number of Inversions: " + countInversions.countInversions(arr));
    }
  }
}
