/**
 * 
 */
package chapter_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Question 1.8: Write an algorithm such that if an element in an MxN matrix is
 * 0, its entire row and column in set to 0.
 * 
 * @author Sudharsanan Muralidharan
 */
public class ZeroMatrix {

  /**
   * If an element is 0 is an MxN matrix then make all elements of row and
   * column to 0. Using set to track the rows and column indexes. Time
   * Complexity: O(n2), Space: O(n)
   * 
   * @param matrix
   */
  private void constructZeroMatrix(int[][] matrix) {
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> columns = new HashSet<Integer>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (Integer row : rows) {
      nullifyRow(matrix, row);
    }

    for (Integer column : columns) {
      nullifyColumn(matrix, column);
    }

    printMatrix(matrix);
  }

  /**
   * If an element is 0 is an MxN matrix then make all elements of row and
   * column to 0. Using boolean array to track the rows and column indexes. Book
   * solution. Time Complexity: O(n2), Space: O(n)
   * 
   * @param matrix
   */
  private void constructZeroMatrix2(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] columns = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          columns[j] = true;
        }
      }
    }

    for (int i = 0; i < rows.length; i++) {
      if (rows[i]) {
        nullifyRow(matrix, i);
      }
    }

    for (int i = 0; i < columns.length; i++) {
      if (columns[i]) {
        nullifyColumn(matrix, i);
      }
    }

    printMatrix(matrix);
  }

  /**
   * If an element is 0 is an MxN matrix then make all elements of row and
   * column to 0. Using the first row and column to track the zero fields. If
   * the first row or column contains 0 then we nullify it at the end. Book
   * Solution. Time Complexity: O(n2), Space: O(1)
   * 
   * @param matrix
   */
  private void constructZeroMatrix3(int[][] matrix) {
    boolean firstRowZero = false, firstColumnZero = false;

    /*
     * check if firstRow and firstColumn contains 0 and set the flag to true if
     * so.
     */
    for (int i = 0; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        firstColumnZero = true;
      }
    }

    /*
     * Check the elements from row 1 and column 1 and set the first row to 0.
     * For eg: If matrix[2][3] is 0 then matrix[0][3] and matrix[2][0] are set
     * to 0.
     */
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    /*
     * Loop through the fist row and make the entire column values 0
     */
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }

    /*
     * Loop through the first column and make entire row values 0
     */
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][i] == 0) {
        nullifyColumn(matrix, i);
      }
    }

    /*
     * Nullify the first row and column if the flags are set
     */
    if (firstRowZero) {
      nullifyRow(matrix, 0);
    }

    if (firstColumnZero) {
      nullifyColumn(matrix, 0);
    }

    printMatrix(matrix);
  }

  /**
   * Given a row set the entire row values to 0
   * 
   * @param matrix
   * @param row
   */
  private void nullifyRow(int[][] matrix, int row) {
    for (int i = 0; i < matrix[0].length; i++) {
      matrix[row][i] = 0;
    }
  }

  /**
   * Given a column set the entire column values to 0
   * 
   * @param matrix
   * @param column
   */
  private void nullifyColumn(int[][] matrix, int column) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][column] = 0;
    }
  }

  /**
   * Prints the matrix
   * 
   * @param matrix
   */
  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Makes a copy of the matrix and return the copy
   * 
   * @param matrix
   * @return copy
   */
  private int[][] copyMatrix(int[][] matrix) {
    int n = matrix.length;
    int[][] copy = new int[n][matrix[0].length];

    for (int i = 0; i < n; i++) {
      copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
    }

    return copy;
  }

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException {
    // TODO Auto-generated method stub
    FileReader fileReader;
    ZeroMatrix zeroMatrix;

    fileReader = new FileReader(new File("input_files/chapter_1/zero_matrix"));
    Scanner scanner = new Scanner(fileReader);
    zeroMatrix = new ZeroMatrix();
    StringBuilder builder = new StringBuilder();
    int m = 0, n = 0;

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      builder.append(line).append("\n");
      m = line.split(" ").length;
      n++;
    }

    System.out.println(m + " " + n);

    int[][] matrix = new int[n][m];
    String[] lines = builder.toString().split("\n");
    for (int i = 0; i < n; i++) {
      String[] rows = lines[i].split(" ");
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(rows[j]);
      }
    }

    System.out.println("Original Matrix:");
    zeroMatrix.printMatrix(matrix);

    int[][] copy = zeroMatrix.copyMatrix(matrix);
    System.out.println("\nAfter setting zeros:");
    zeroMatrix.constructZeroMatrix(copy);

    copy = zeroMatrix.copyMatrix(matrix);
    System.out.println("\nAfter setting zeros - method 2:");
    zeroMatrix.constructZeroMatrix2(copy);

    copy = zeroMatrix.copyMatrix(matrix);
    System.out.println("\nAfter setting zeros - method 3:");
    zeroMatrix.constructZeroMatrix3(copy);

    scanner.close();
  }

}
