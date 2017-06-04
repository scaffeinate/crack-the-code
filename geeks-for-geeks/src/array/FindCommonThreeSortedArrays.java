package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: http://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/
 */
public class FindCommonThreeSortedArrays {
  public List<Integer> findCommon(Integer[] arr, Integer[] arr2, Integer[] arr3) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0, k = 0;
    while (i < arr.length && j < arr2.length && k < arr3.length) {
      if (arr[i] == arr2[j] && arr2[j] == arr3[k]) {
        result.add(arr[i]);
        i++;
        j++;
        k++;
      } else if (arr[i] < arr2[j]) {
        if (arr[i] < arr3[k]) {
          i++;
        } else {
          k++;
        }
      } else {
        if (arr2[j] < arr3[k]) {
          j++;
        } else {
          k++;
        }
      }
    }
    return result;
  }
}
