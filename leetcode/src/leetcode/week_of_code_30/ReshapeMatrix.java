package leetcode.week_of_code_30;

import java.util.Scanner;

public class ReshapeMatrix {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] matrix = new int[][] { new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8 } };
    int r = in.nextInt();
    int c = in.nextInt();
    int[][] result = matrixReshape(matrix, r, c);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
    in.close();
  }

  private static int[][] matrixReshape(int[][] nums, int r, int c) {
    int[][] result = null;
    int row = 0, column = 0;
    if ((nums.length * nums[0].length) == (r * c)) {
      result = new int[r][c];
      for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums[0].length; j++) {
          if (column == c) {
            row++;
            column = 0;
          }
          result[row][column] = nums[i][j];
          column++;
        }
      }
      return result;
    }
    return nums;
  }
}
