package chapter_1;

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
  public int[][] rotate(int[][] matrix, int degrees) {
    int numRotations = (degrees / 90);
    int numLayers = matrix.length / 2;
    int top, left, right, bottom, temp = 0;
    while (numRotations-- > 0) {
      for (int i = 0; i < numLayers; i++) {
        int len = matrix.length - 1;
        top = left = i;
        bottom = right = len - i;

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
}
