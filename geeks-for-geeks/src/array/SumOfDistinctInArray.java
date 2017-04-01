package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfDistinctInArray {

  public int getSum(int[] arr) {
    int sum = 0;
    Set<Integer> numbersSet = new HashSet<Integer>();

    for (int i = 0; i < arr.length; i++) {
      if (!numbersSet.contains(arr[i])) {
        numbersSet.add(arr[i]);
        sum += arr[i];
      }
    }

    return sum;
  }

  public int getSum2(int[] arr) {
    int i = 0, sum = 0;
    Arrays.sort(arr);

    for (i = 0; i < arr.length - 1; i++) {
      if (arr[i] != arr[i + 1]) {
        sum += arr[i];
      }
    }

    return (sum += arr[i]);
  }

  public int getSum3(int[] arr) {
    int i = 0, sum = 0;

    for (i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[i] == arr[j]) {
            arr[j] = 0;
          }
        }
        sum += arr[i];
      }
    }

    return sum;
  }
}
