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
  private void generatePermutations(char[] arr) {
    printPermuatations(arr, 0);
  }

  private void generatePermutationsIterative(char[] arr) {
    int n = arr.length;
    int fact = fact(n);
    int m = fact / n;

    for (int i = 0; i < n; i++) {
      swap(arr, 0, i);
      int j = 0, k = 1;
      while (j < m) {
        if (k < n - 1) {
          swap(arr, k, k + 1);
          print(arr);
          k++;
          j++;
        } else {
          k = 1;
        }
      }
    }
  }

  private int fact(int n) {
    if (n == 0) {
      return 1;
    }

    return n * fact(n - 1);
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
    System.out.print(", ");
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("test_permutations");
    StringPermutations permutations = new StringPermutations();
    System.out.println("Permutations using Recursion: ");
    for (String line : input) {
      System.out.print("[ ");
      permutations.generatePermutations(line.toCharArray());
      System.out.println("]");
    }

    System.out.println("\nPermutations using Iteration: ");
    for (String line : input) {
      System.out.print("[ ");
      permutations.generatePermutationsIterative(line.toCharArray());
      System.out.println("]");
    }
  }
}
