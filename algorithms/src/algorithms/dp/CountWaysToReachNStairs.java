package algorithms.dp;

/**
 * Question: http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * 
 * @author Sudharsanan Muralidharan
 */
public class CountWaysToReachNStairs {
  public int countWays(int n, int m) {
    return countWays(n, m, new int[n + 1]);
  }

  private int countWays(int n, int m, int[] results) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else if (results[n] == 0) {
      for (int i = 1; i <= m; i++) {
        results[n] += countWays((n - i), m, results);
      }
    }
    return results[n];
  }
}
