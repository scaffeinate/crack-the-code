package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * Solution: https://www.youtube.com/watch?v=s6FhG--P7z0
 */
public class SubsetSum {
  public boolean subsetSum(int n, int[] set) {
    return subsetSum(n, set, 0);
  }

  private boolean subsetSum(int n, int[] set, int index) {
    if (n == 0) {
      return true;
    } else if (n < 0 || index >= set.length) {
      return false;
    } else {
      return subsetSum(n - set[index], set, index + 1) || subsetSum(n, set, index + 1);
    }
  }

  public boolean subsetSumDP(int n, int[] set) {
    boolean[][] memo = new boolean[set.length + 1][n + 1];
    for (int i = 0; i < set.length + 1; i++) {
      memo[i][0] = true;
    }

    for (int i = 1; i < memo.length; i++) {
      int val = set[i - 1];
      for (int j = 1; j < memo[0].length; j++) {
        if (j >= val) {
          memo[i][j] = memo[i - 1][j] || memo[i - 1][j - val];
        } else {
          memo[i][j] = memo[i - 1][j];
        }
      }
    }

    return memo[set.length][n];
  }
}
