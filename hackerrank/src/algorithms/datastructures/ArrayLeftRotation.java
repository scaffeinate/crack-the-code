/**
 * 
 */
package algorithms.datastructures;

import java.util.Scanner;

/**
 * 
 * Challenge: https://www.hackerrank.com/challenges/array-left-rotation
 * 
 * References:
 * 
 * 1. http://www.geeksforgeeks.org/array-rotation/
 * 
 * 2.
 * http://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-
 * algorithm/
 * 
 * @author Sudharsanan Muralidharan
 */
public class ArrayLeftRotation {

  /**
   * Brute force approach. Rotate each item for n*d times.
   * 
   * Time Complexity: O(n2), Space Complexity: O(1)
   * 
   * @param arr
   * @param n
   * @param d
   */
  private static void rotate(int[] arr, int n, int d) {
    for (int i = 0; i < d; i++) {
      int temp = arr[0];
      for (int j = 0; j < n - 1; j++) {
        arr[j] = arr[j + 1];
      }
      arr[n - 1] = temp;
    }
    print(arr);
  }

  /**
   * Using a buffer array to copy the ranges.
   * 
   * Time Complexity: O(n), Space Complexity: O(n)
   * 
   * @param arr
   * @param n
   * @param d
   */
  private static void rotateUsingBufferArray(int[] arr, int n, int d) {
    int[] newArr = new int[arr.length];
    System.arraycopy(arr, d, newArr, 0, n - d);
    System.arraycopy(arr, 0, newArr, (n - d), d);
    print(newArr);

  }

  /**
   * Reversing 0 to d-1 and then d to n-1 and then reverse the whole array from
   * 0 to n-1.
   * 
   * Time Complexity: O(n), Space Complexity: O(1)
   * 
   * @param arr
   * @param n
   * @param d
   */
  private static void rotateByReversing(int[] arr, int n, int d) {
    reverseRange(arr, 0, d - 1);
    reverseRange(arr, d, n - 1);
    reverseRange  (arr, 0, n - 1);
    print(arr);
  }

  private static void reverseRange(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  private static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int d = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    rotateByReversing(arr, n, d);

    in.close();
  }
}
