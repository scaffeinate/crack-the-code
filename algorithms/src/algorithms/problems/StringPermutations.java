/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;

import algorithms.util.InputUtil;

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
  private void generatePermuations(char[] arr) {
    printPermuatations(arr, 0);
  }

  private void printPermuatations(char[] arr, int start) {
    if (start == arr.length - 1) {
      print(arr);
      return;
    }

    for (int i = start; i < arr.length; i++) {
      swap(arr, i, start);
      printPermuatations(arr, start + 1);
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

  private void print(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_permutations");
    StringPermutations permutations = new StringPermutations();
    for (String line : input) {
      permutations.generatePermuations(line.toCharArray());
    }
  }
}
