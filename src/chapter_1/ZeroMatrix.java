/**
 * 
 */
package chapter_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

  private void constructZeroMatrix(int[][] matrix) {

    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> columns = new HashSet<Integer>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (Integer row : rows) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[row][i] = 0;
      }
    }

    for (Integer column : columns) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][column] = 0;
      }
    }
    
    printMatrix(matrix);
  }

  private void constructZeroMatrix2(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] columns = new boolean[matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          columns[j] = true;
        }
      }
    }
    
    for(int i=0;i<rows.length;i++) {
      for(int j=0;j<matrix.length;j++) {
        if(rows[i]) {
          matrix[i][j] = 0;
        }
      }
    }
    
    for(int i=0;i<matrix.length;i++) {
      for(int j=0;j<columns.length;j++) {
        if(columns[j]) {
          matrix[i][j] = 0;
        }
      }
    }
    
    printMatrix(matrix);
  }

  private void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FileReader fileReader;
    ZeroMatrix zeroMatrix;
    try {
      fileReader = new FileReader(new File("input_files/zero_matrix"));
      Scanner scanner = new Scanner(fileReader);
      zeroMatrix = new ZeroMatrix();
      StringBuilder builder = new StringBuilder();
      int n = 0;

      while (scanner.hasNextLine()) {
        builder.append(scanner.nextLine()).append("\n");
        n++;
      }

      int[][] matrix = new int[n][n];
      String[] lines = builder.toString().split("\n");
      for (int i = 0; i < lines.length; i++) {
        String[] rows = lines[i].split(" ");
        for (int j = 0; j < rows.length; j++) {
          matrix[i][j] = Integer.parseInt(rows[j]);
        }
      }

      System.out.println("Original Matrix:");
      zeroMatrix.printMatrix(matrix);

      System.out.println("After setting zeros:");
      zeroMatrix.constructZeroMatrix(matrix);

      scanner.close();      
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
