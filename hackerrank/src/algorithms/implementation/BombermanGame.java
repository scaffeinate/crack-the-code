/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/bomber-man
 * 
 * @author Sudharsanan Muralidharan
 */
public class BombermanGame {

  private static void plant(char[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '.') {
          matrix[i][j] = '0';
        }
      }
    }
  }

  private static void burst(char[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 'O') {
          matrix[i][j] = '.';
          if (j - 1 >= 0 && matrix[i][j - 1] != 'O') {
            matrix[i][j - 1] = '.';
          }
          if (j + 1 < matrix[0].length && matrix[i][j + 1] != 'O') {
            matrix[i][j + 1] = '.';
          }
          if (i - 1 >= 0 && matrix[i - 1][j] != 'O') {
            matrix[i - 1][j] = '.';
          }
          if (i + 1 < matrix.length && matrix[i + 1][j] != 'O') {
            matrix[i + 1][j] = '.';
          }
        }
      }
    }
  }

  private static void flip(char[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          matrix[i][j] = 'O';
        }
      }
    }
  }

  private static void finalState(char[][] matrix, int n) {
    for (int i = 2; i <= n; i++) {
      if (i % 2 == 0) {
        plant(matrix);
      } else {
        burst(matrix);
        flip(matrix);
      }
    }

    print(matrix);
  }

  private static void print(char[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '0') {
          System.out.print('O');
        } else {
          System.out.print(matrix[i][j]);
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int r = in.nextInt();
    int c = in.nextInt();
    int n = in.nextInt();
    char[][] matrix = new char[r][c];

    for (int i = 0; i < r; i++) {
      String input = in.next();
      for (int j = 0; j < input.length(); j++) {
        matrix[i][j] = input.charAt(j);
      }
    }

    if (n > 3) {
      int remainder = (n % 4);
      n = remainder + ((remainder < 3) ? 4 : 0);
    }

    finalState(matrix, n);
    in.close();
  }
}
