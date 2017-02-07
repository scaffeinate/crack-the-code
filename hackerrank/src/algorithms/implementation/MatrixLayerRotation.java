/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/matrix-rotation-algo
 * 
 * @author Sudharsanan Muralidharan
 */
public class MatrixLayerRotation {

  private static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int m = in.nextInt();
    int n = in.nextInt();
    int r = in.nextInt();
    int[][] matrix = new int[m][n];
    int numLayers = Math.min(m, n) / 2;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = in.nextInt();
      }
    }

    int start = 0;
    int colEnd = n;
    int rowEnd = m;

    for (int k = 0; k < numLayers; k++) {
      int numElements = (2 * (rowEnd - start) + 2 * ((colEnd - start) - 2));
      int numRotations = r % numElements;

      while (numRotations-- > 0) {
        int temp = matrix[start][start + 1];

        for (int j = start + 1; j < colEnd - 1; j++) {
          matrix[start][j] = matrix[start][j + 1];
        }

        for (int i = start; i < rowEnd - 1; i++) {
          matrix[i][colEnd - 1] = matrix[i + 1][colEnd - 1];
        }

        for (int j = colEnd - 1; j > start; j--) {
          matrix[rowEnd - 1][j] = matrix[rowEnd - 1][j - 1];
        }

        for (int i = rowEnd - 1; i > start; i--) {
          matrix[i][start] = matrix[i - 1][start];
        }

        matrix[start][start] = temp;
      }

      start++;
      colEnd--;
      rowEnd--;
    }

    print(matrix);
    in.close();
  }
}
