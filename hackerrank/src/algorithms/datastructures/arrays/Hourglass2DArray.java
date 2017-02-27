/**
 * 
 */
package algorithms.datastructures.arrays;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class Hourglass2DArray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = 6;
    int arr[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = in.nextInt();
      }
    }

    int rowStart = 0;
    int columnStart = 0;
    int maxSum = Integer.MIN_VALUE;
    while (rowStart <= (n / 2)) {
      int sum = 0;
      int rowEnd = rowStart + 3;
      for (int i = rowStart; i < rowEnd; i++) {
        int columnEnd = columnStart + 3;
        if (i > rowStart && i < rowEnd - 1) {
          sum += arr[i][columnEnd - 2];
        } else {
          for (int j = columnStart; j < columnEnd; j++) {
            sum += arr[i][j];
          }
        }
      }

      if (++columnStart > (n / 2)) {
        rowStart++;
        columnStart = 0;
      }
      if (sum > maxSum) {
        maxSum = sum;
      }
    }

    System.out.println(maxSum);
    in.close();
  }
}
