/**
 * 
 */
package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/larrys-array
 * 
 * @author Sudharsanan Muralidharan
 */
public class LarrysArray {

  static class InversionArray {
    int[] arr;
    int inversionsCount = 0;
  }

  public static int countInversions(int[] arr) {
    InversionArray inversionArray = new InversionArray();
    inversionArray.arr = arr;
    int inversions = countInversions(inversionArray, 0, arr.length - 1).inversionsCount;
    return inversions;
  }

  private static InversionArray countInversions(InversionArray inversionArr, int start, int end) {
    InversionArray resultArr = new InversionArray();
    if (start == end) {
      resultArr.arr = Arrays.copyOfRange(inversionArr.arr, start, end + 1);
      resultArr.inversionsCount = 0;
      return resultArr;
    }

    int middle = (start + end) / 2;
    InversionArray leftInversions = countInversions(inversionArr, start, middle);
    InversionArray rightInversions = countInversions(inversionArr, middle + 1, end);
    InversionArray splitInversions = mergeAndCountSplitInversions(leftInversions.arr, rightInversions.arr);

    resultArr.arr = splitInversions.arr;
    resultArr.inversionsCount = leftInversions.inversionsCount + rightInversions.inversionsCount
        + splitInversions.inversionsCount;
    return resultArr;
  }

  private static InversionArray mergeAndCountSplitInversions(int[] leftArr, int[] rightArr) {
    int n = leftArr.length;
    int m = rightArr.length;
    int inversionCount = 0;
    InversionArray resultArr = new InversionArray();
    int[] result = new int[m + n];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      if (leftArr[i] < rightArr[j]) {
        result[k] = leftArr[i];
        i++;
      } else {
        result[k] = rightArr[j];
        j++;
        inversionCount += (leftArr.length - i);
      }

      k++;
    }

    while (i < n) {
      result[k] = leftArr[i];
      i++;
      k++;
    }

    while (j < m) {
      result[k] = rightArr[j];
      j++;
      k++;
    }

    resultArr.inversionsCount = inversionCount;
    resultArr.arr = result;

    return resultArr;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }

      int inversions = countInversions(arr);
      System.out.println((inversions % 2 == 0) ? "YES" : "NO");
    }

    in.close();
  }
}
