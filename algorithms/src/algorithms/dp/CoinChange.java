package algorithms.dp;

/**
 * Question: http://www.geeksforgeeks.org/?p=17401
 */
public class CoinChange {
  public long numWays(int n, int[] coins) {
    int[][] matrix = new int[coins.length + 1][n + 1];

    for (int i = 0; i < matrix.length; i++) {
      matrix[i][0] = 1;
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (j < coins[i - 1]) {
          matrix[i][j] = matrix[i - 1][j];
        } else {
          matrix[i][j] = matrix[i - 1][j] + matrix[i][j - coins[i - 1]];
        }
      }
    }

    return matrix[matrix.length - 1][matrix[0].length - 1];
  }
}
