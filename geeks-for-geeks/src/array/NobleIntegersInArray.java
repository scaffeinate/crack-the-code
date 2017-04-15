package array;

import java.util.Arrays;

/**
 * Question:
 * http://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/
 * 
 * @author Sudharsanan Muralidharan
 */
public class NobleIntegersInArray {

  public int nobleInteger(int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if ((arr.length - 1 - i) == arr[i]) {
        return arr[i];
      }
    }

    return -1;
  }
}
