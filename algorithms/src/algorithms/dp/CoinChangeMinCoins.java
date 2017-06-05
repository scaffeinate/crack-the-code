package algorithms.dp;

/**
 * Created by sudharti on 6/4/17.
 */
public class CoinChangeMinCoins {
  public long numWays(int n, int[] coins) {
    if (n == 0) {
      return 0;
    } else if (n < 0) {
      return Long.MAX_VALUE;
    } else {
      long min = Long.MAX_VALUE;
      for (int i = 0; i < coins.length; i++) {
        long val = numWays(n - coins[i], coins);
        if (val != Long.MAX_VALUE) {
          min = Math.min(min, 1 + val);
        }
      }
      return min;
    }
  }

  public long numWaysMemoized(int n, int[] coins) {
    return numWaysMemoized(n, coins, new long[n + 1]);
  }

  private long numWaysMemoized(int n, int[] coins, long[] memo) {
    if (n == 0) {
      return 0;
    } else if (n < 0) {
      return Long.MAX_VALUE;
    } else if (memo[n] == 0L) {
      long min = Long.MAX_VALUE;
      for (int i = 0; i < coins.length; i++) {
        long val = numWaysMemoized(n - coins[i], coins, memo);
        min = Math.min(min, (val == Long.MAX_VALUE) ? Long.MAX_VALUE : 1 + val);
      }
      memo[n] = min;
    }

    return memo[n];
  }
}
