/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.Arrays;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class CountInversions {

  class InversionArray {
    int[] arr;
    int inversionCount = 0;
  }

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

  private int countInversions2(int[] arr) {
    return sortAndCountInverse(arr, 0, arr.length - 1).inversionCount;
  }

  private InversionArray sortAndCountInverse(int[] arr, int start, int end) {
    if (start == end) {
      InversionArray result = new InversionArray();
      result.arr = Arrays.copyOfRange(arr, start, end + 1);
      return result;
    }

    int middle = (start + end) / 2;
    InversionArray leftInversions = sortAndCountInverse(arr, start, middle);
    InversionArray rightInversions = sortAndCountInverse(arr, middle + 1, end);
    InversionArray splitInversions = mergeAndCountSplitInversions(leftInversions, rightInversions);

    InversionArray result = new InversionArray();
    result.arr = splitInversions.arr;
    result.inversionCount = leftInversions.inversionCount + rightInversions.inversionCount
        + splitInversions.inversionCount;

    return result;
  }
  
  private InversionArray mergeAndCountSplitInversions(InversionArray leftInversions, InversionArray rightInversions) {
    InversionArray inversionArray = new InversionArray();
    int[] leftArr = leftInversions.arr;
    int[] rightArr = rightInversions.arr;
    int[] result = new int[leftArr.length + rightArr.length];
    int i = 0, j = 0, k = 0, inversionCount = 0;

    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        result[k] = leftArr[i];
        i++;
      } else {
        result[k] = rightArr[j];
        j++;
        inversionCount += (leftArr.length - i);
      }
      k++;
    }

    while (i < leftArr.length) {
      result[k] = leftArr[i];
      i++;
      k++;
    }

    while (j < rightArr.length) {
      result[k] = rightArr[j];
      j++;
      k++;
    }

    inversionArray.arr = result;
    inversionArray.inversionCount = inversionCount;
    
    return inversionArray;
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
      System.out.println("Number of Inversions using brute force: " + countInversions.countInversions(arr));
      System.out.println("Number of Inversions using divide and conquer: " + countInversions.countInversions2(arr));
      System.out.println();
    }
  }
}
