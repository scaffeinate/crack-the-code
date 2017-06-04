package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Question: http://www.geeksforgeeks.org/?p=17401
 * Solution: https://www.youtube.com/watch?v=_fgjrs570YE
 */
public class CoinChange {
  public long numWays(int n, int[] coins) {
    long[][] matrix = new long[coins.length + 1][n + 1];

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

  public long numWays2(int n, int[] coins) {
    return numWaysMemoized(n, coins, 0, new HashMap<>());
  }

  private long numWaysMemoized(int n, int[] coins, int i, Map<String, Long> resultsMap) {
    if (n == 0) {
      return 1;
    } else if (i >= coins.length) {
      return 0;
    } else {
      String key = n + ":" + coins[i];
      if (!resultsMap.containsKey(key)) {
        int maxCoins = (n / coins[i]);
        long sum = 0;
        for (int x = 0; x <= maxCoins; x++) {
          sum += numWaysMemoized(n - (x * coins[i]), coins, i + 1, resultsMap);
        }

        resultsMap.put(key, sum);
      }

      return resultsMap.get(key);
    }
  }
}
