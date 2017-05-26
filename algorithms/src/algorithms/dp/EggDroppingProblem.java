package algorithms.dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 */
public class EggDroppingProblem {
  public int minAttemptsRecursive(int floors, int eggs) {
    if (floors == 0 || floors == 1) {
      return floors;
    } else if (eggs == 1) {
      return floors;
    } else {
      int min = Integer.MAX_VALUE;
      for (int i = 1; i <= floors; i++) {
        min = Math.min(min, Math.max(1 + minAttemptsRecursive(i - 1, eggs - 1),
                1 + minAttemptsRecursive(floors - i, eggs)));
      }
      return min;
    }
  }

  public int minAttemptsDP(int floors, int eggs) {
    int[][] results = new int[eggs + 1][floors + 1];
    for (int i = 1; i < results[0].length; i++) {
      results[1][i] = i;
    }

    for (int i = 2; i < (eggs + 1); i++) {
      for (int j = 1; j < (floors + 1); j++) {
        if (i > j) {
          results[i][j] = j;
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = 1; k <= j; k++) {
            min = Math.min(min, Math.max((1 + results[i - 1][k - 1]), (1 + results[i][j - k])));
          }
          results[i][j] = min;
        }
      }
    }

    return results[eggs][floors];
  }
}
