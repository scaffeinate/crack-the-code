/**
 * 
 */
package algorithms.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a
 * -given-string/
 * 
 * Complexity: O(n * n!)
 * 
 * @author Sudharsanan Muralidharan
 */
public class StringPermutations {

  /**
   * @param arr
   */
  public List<String> generatePermutations(char[] arr) {
    List<String> resultList = new ArrayList<String>();
    generatePermutations(arr, 0, resultList);
    return resultList;
  }

  public List<String> generatePermutationsIterative(char[] arr) {
    List<String> resultList = new ArrayList<String>();
    int n = arr.length;
    int fact = fact(n);
    int m = fact / n;

    for (int i = 0; i < n; i++) {
      swap(arr, 0, i);
      int j = 0, k = 1;
      while (j < m) {
        if (k < n - 1) {
          swap(arr, k, k + 1);
          resultList.add(stringify(arr));
          k++;
          j++;
        } else {
          k = 1;
        }
      }
    }
    
    return resultList;
  }

  private int fact(int n) {
    if (n == 0) {
      return 1;
    }

    return n * fact(n - 1);
  }

  private void generatePermutations(char[] arr, int start, List<String> resultList) {
    if (start == arr.length - 1) {
      resultList.add(stringify(arr));
      return;
    }

    for (int i = start; i < arr.length; i++) {
      swap(arr, i, start);
      generatePermutations(arr, start + 1, resultList);
      swap(arr, start, i);
    }
  }

  private char[] swap(char[] arr, int i, int j) {
    if (i == j) {
      return arr;
    }
    arr[i] = (char) (arr[i] + arr[j]);
    arr[j] = (char) (arr[i] - arr[j]);
    arr[i] = (char) (arr[i] - arr[j]);
    return arr;
  }

  private String stringify(char[] arr) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);
    }
    
    return builder.toString();
  }
}
