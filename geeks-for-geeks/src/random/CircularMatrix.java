package random;

/**
 * Question: http://www.geeksforgeeks.org/?p=141853
 * 
 * @author Sudharsanan Muralidharan
 */
public class CircularMatrix {
  public static int[][] constructMatrix(int m, int n) {
    int[][] result = new int[m][n];
    int product = m * n;
    int num = 1, startRow = 0, endRow = m, startColumn = 0, endColumn = n;

    while (num <= product) {
      for (int j = startColumn; j < endColumn && num <= product; j++) {
        result[startRow][j] = num++;
      }

      for (int i = startRow + 1; i < endRow && num <= product; i++) {
        result[i][endColumn - 1] = num++;
      }

      for (int j = endColumn - 2; j >= startColumn && num <= product; j--) {
        result[endRow - 1][j] = num++;
      }

      for (int i = endRow - 2; i > startRow && num <= product; i--) {
        result[i][startColumn] = num++;
      }

      startColumn++;
      startRow++;
      endColumn--;
      endRow--;

    }

    return result;
  }
}
