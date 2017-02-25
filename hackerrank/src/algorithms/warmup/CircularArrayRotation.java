package algorithms.warmup;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/circular-array-rotation
 * 
 * @author Sudharsanan Muralidharan
 */
public class CircularArrayRotation {
  private static void reverse(int[] arr, int i, int j) {
    while (i < j) {
      swap(arr, i, j);
      i++;
      j--;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    arr[i] = arr[i] + arr[j];
    arr[j] = arr[i] - arr[j];
    arr[i] = arr[i] - arr[j];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt() % n;
    int q = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    reverse(arr, 0, n - k - 1);
    reverse(arr, n - k, n - 1);
    reverse(arr, 0, n - 1);

    while (q-- > 0) {
      int m = in.nextInt();
      System.out.println(arr[m]);
    }

    in.close();
  }
}
