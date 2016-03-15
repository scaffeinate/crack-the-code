package chapter_1;

import java.io.FileNotFoundException;

import util.InputUtil;

/**
 * Question 1.7: Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes, write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 * 
 * @author Sudharsanan Muralidharan
 */
public class RotateMatrix {

  /**
   * Rotates the matrix in-place. The number of layers is ceil(n/2) where n is
   * the matrix length. For each layer shift the elements of top, left, right
   * and bottom without using an extra array of size n.
   * 
   * temp = top top = left left = bottom bottom = right right = temp
   * 
   * Complexity: O(n2), Space: O(n2)
   * 
   * @param matrix
   * @param degrees
   * @return matrix
   */
  private int[][] rotate(int[][] matrix, int degrees) {
    int layers = (int) Math.ceil(matrix.length / 2.0);

    int top, left, right, bottom;

    // Rotate (degrees/90) times
    for (int k = 0; k < (degrees / 90); k++) {
      // For each layer do the shift
      for (int i = 0; i < layers; i++) {
        int len = matrix.length - 1;
        top = left = i;
        bottom = right = len - i;
        int temp = 0;

        // shift the elements of each side
        for (int j = i; j < len - i; j++) {
          temp = matrix[top][j];
          matrix[top][j] = matrix[len - j][left];
          matrix[len - j][left] = matrix[bottom][len - j];
          matrix[bottom][len - j] = matrix[j][right];
          matrix[j][right] = temp;
        }
      }
    }

    return matrix;
  }

  /**
   * Prints the matrix
   * 
   * @param matrix
   */
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
   * @throws FileNotFoundException
   */
  public static void main(String[] args) throws FileNotFoundException {
    RotateMatrix rotateMatrix = new RotateMatrix();
    String[] input = InputUtil.readContents(1, "image_matrix");
    int[][] matrix;
    int n = input.length;

    matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] row = input[i].split(" ");
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);
      }
    }

    System.out.println("Original Image Matrix:");
    rotateMatrix.printMatrix(matrix);

    System.out.println("\nAfter Rotation:");
    rotateMatrix.rotate(matrix, 90);
    rotateMatrix.printMatrix(matrix);
  }
}
