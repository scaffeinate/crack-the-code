package dp;

/**
 * Question: http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * Solution: https://www.youtube.com/watch?v=NJuKJ8sasGk
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
    long[] memo = new long[n + 1];
    for (int i = 1; i < memo.length; i++) {
      memo[i] = Long.MAX_VALUE;
    }
    return numWaysMemoized(n, coins, memo);
  }

  private long numWaysMemoized(int n, int[] coins, long[] memo) {
    if (n == 0) {
      return 0;
    } else if (n < 0) {
      return Long.MAX_VALUE;
    } else if (memo[n] == Long.MAX_VALUE) {
      for (int i = 0; i < coins.length; i++) {
        long val = numWaysMemoized(n - coins[i], coins, memo);
        memo[n] = Math.min(memo[n], (val == Long.MAX_VALUE) ? Long.MAX_VALUE : 1 + val);
      }
    }

    return memo[n];
  }

  public long numWaysMemoized2(int n, int[] coins) {
    long[] memo = new long[n + 1];

    for (int i = 1; i < memo.length; i++) {
      memo[i] = Long.MAX_VALUE;
    }

    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= n; j++) {
        if (j >= coins[i]) {
          memo[j] = Math.min(memo[j], ((memo[j - coins[i]] == Long.MAX_VALUE) ? Long.MAX_VALUE : 1 + memo[j - coins[i]]));
        }
      }
    }

    return memo[n];
  }

  public long numWaysMemoized3(int n, int[] coins) {
    long[] memo = new long[n + 1];

    for (int i = 1; i < memo.length; i++) {
      memo[i] = Long.MAX_VALUE;
    }

    for (int i = 1; i < memo.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i >= coins[j]) {
          memo[i] = Math.min(memo[i], (memo[i - coins[j]] == Long.MAX_VALUE) ? Long.MAX_VALUE : (1 + memo[i - coins[j]]));
        }
      }
    }

    return memo[n];
  }
}
