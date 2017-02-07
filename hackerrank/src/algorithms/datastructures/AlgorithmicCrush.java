/**
 * 
 */
package algorithms.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/crush
 * 
 * Reference:
 * http://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
 * 
 * @author Sudharsanan Muralidharan
 */
public class AlgorithmicCrush {

  static class ArrayElement {
    Long t;
    Long k;
    boolean isStart;

    ArrayElement(Long t, Long k, boolean isStart) {
      this.t = t;
      this.k = k;
      this.isStart = isStart;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();

    ArrayElement[] startArr = new ArrayElement[(int) m];
    ArrayElement[] endArr = new ArrayElement[(int) m];

    for (int i = 0; i < m; i++) {
      long a = in.nextInt();
      long b = in.nextInt();
      long k = in.nextInt();

      /*
       * Store the ranges in two separate arrays
       */
      startArr[i] = new ArrayElement(a, k, true);
      endArr[i] = new ArrayElement(b, k, false);
    }

    // Sort startArr
    Arrays.sort(startArr, new Comparator<ArrayElement>() {
      @Override
      public int compare(ArrayElement e1, ArrayElement e2) {
        return e1.t.compareTo(e2.t);
      }
    });

    // Sort endArr
    Arrays.sort(endArr, new Comparator<ArrayElement>() {
      @Override
      public int compare(ArrayElement e1, ArrayElement e2) {
        return e1.t.compareTo(e2.t);
      }
    });

    int i = 0, j = 0;
    Long count = (long) 0;
    Long max = Long.MIN_VALUE;

    /*
     * Merge startArr and endArr. Add the k value for each startRange and
     * decrement k for each endRange.
     */
    while (i < m && j < m) {
      if (startArr[i].t <= endArr[j].t) {
        count += startArr[i].k;
        i++;
      } else {
        count -= endArr[j].k;
        j++;
      }

      if (count > max) {
        max = count;
      }
    }

    System.out.println(max);
    in.close();
  }
}
