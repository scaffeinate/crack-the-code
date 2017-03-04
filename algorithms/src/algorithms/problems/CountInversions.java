/**
 * 
 */
package algorithms.problems;

import java.util.Arrays;

/**
 * @author Sudharsanan Muralidharan
 */
public class CountInversions {

  class InversionArray {
    int[] arr;
    int inversionCount = 0;
  }

  public int countInversions(int[] arr) {
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

  public int countInversions2(int[] arr) {
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
}
