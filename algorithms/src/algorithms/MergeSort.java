package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

  private static void sort(int[] arr) {
    arr = split(arr, 0, arr.length - 1);
    print(arr);
  }

  private static int[] split(int[] arr, int start, int end) {
    if (start == end) {
      return Arrays.copyOfRange(arr, start, end + 1);
    }

    int middle = (start + end) / 2;
    int[] left = split(arr, start, middle);
    int[] right = split(arr, middle + 1, end);

    return merge(left, right);
  }

  private static int[] merge(int[] left, int[] right) {
    int n = left.length;
    int m = right.length;
    int[] result = new int[n + m];
    int i = 0, j = 0, k = 0;

    while (i < n && j < m) {
      if (left[i] < right[j]) {
        result[k] = left[i];
        i++;
      } else {
        result[k] = right[j];
        j++;
      }

      k++;
    }

    while (i < n) {
      result[k] = left[i];
      i++;
      k++;
    }

    while (j < m) {
      result[k] = right[j];
      j++;
      k++;
    }

    return result;
  }

  private static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    sort(arr);

    in.close();
  }
}
