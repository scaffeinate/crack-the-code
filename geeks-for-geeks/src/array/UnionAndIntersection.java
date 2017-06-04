package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 */
public class UnionAndIntersection {
  public List<Integer> union(Integer[] arr, Integer[] arr2) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < arr.length && j < arr2.length) {
      if (arr[i] == arr2[j]) {
        result.add(arr[i]);
        i++;
        j++;
      } else if (arr[i] < arr2[j]) {
        result.add(arr[i]);
        i++;
      } else {
        result.add(arr2[j]);
        j++;
      }
    }

    while (i < arr.length) {
      result.add(arr[i]);
      i++;
    }

    while (j < arr2.length) {
      result.add(arr2[j]);
      j++;
    }

    return result;
  }

  public List<Integer> intersection(Integer[] arr, Integer[] arr2) {
    List<Integer> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < arr.length && j < arr2.length) {
      if (arr[i] == arr2[j]) {
        result.add(arr[i]);
        i++;
        j++;
      } else if (arr[i] < arr2[j]) {
        i++;
      } else {
        j++;
      }
    }

    if (result.isEmpty()) {
      result.add(-1);
    }
    return result;
  }
}
