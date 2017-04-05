package array;

import java.util.Arrays;

/**
 * Question: http://www.geeksforgeeks.org/minimum-sum-absolute-difference-pairs-two-arrays/
 * @author Sudharsanan Muralidharan
 */
public class MinimumSumAbsDiffTwoArrays {

  public int getMinimumSum(int[] a, int[] b) {
    int sum = 0;
    Arrays.sort(a);
    Arrays.sort(b);

    for (int i = 0; i < a.length; i++) {
      sum += Math.abs(b[i] - a[i]);
    }
    return sum;
  }
}
