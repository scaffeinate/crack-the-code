package chapter_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Question 1.7: Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * @author Sudharsanan Muralidharan
 */
public class RotateMatrix {

  private int[][] rotate(int[][] matrix, int degrees) {

    int layers = (int) Math.ceil(matrix.length / 2.0);
    System.out.println(layers);

    int top, left, right, bottom;

    for (int i = 0; i < layers; i++) {
      int len = matrix.length - 1;
      top = left = i;
      bottom = right = len - i;
      int temp = 0;

      for (int j = i; j < len - i; j++) {
        temp = matrix[top][j];
        matrix[top][j] = matrix[len - j][left];
        matrix[len - j][left] = matrix[bottom][len - j];
        matrix[bottom][len - j] = matrix[j][right];
        matrix[j][right] = temp;
      }

    }

    printMatrix(matrix);

    return matrix;
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
   * 
   * @param args
   */
  public static void main(String[] args) {
    RotateMatrix rotateMatrix = new RotateMatrix();
    StringBuilder builder = new StringBuilder();
    int[][] matrix;
    int n = 0;
    try {
      FileReader fileReader = new FileReader("input_files/image_matrix");
      Scanner scanner = new Scanner(fileReader);
      while (scanner.hasNextLine()) {
        builder.append(scanner.nextLine().trim()).append("\n");
        n++;
      }

      matrix = new int[n][n];
      String[] lines = builder.toString().split("\n");

      for (int i = 0; i < lines.length; i++) {
        String[] rows = lines[i].split(" ");
        for (int j = 0; j < rows.length; j++) {
          matrix[i][j] = Integer.parseInt(rows[j]);
        }
      }

      System.out.println("Original Image Matrix: ");
      rotateMatrix.printMatrix(matrix);

      rotateMatrix.rotate(matrix, 90);

      scanner.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
