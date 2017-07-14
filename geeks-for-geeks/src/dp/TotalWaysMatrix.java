package dp;

/**
 * Question: http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * Solution: https://www.youtube.com/watch?v=GO5QHC_BmvM
 */
public class TotalWaysMatrix {
    public int totalWays(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return totalWays(m, n, 0, 0, memo);
    }

    public int totalWaysBottomUp(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = ((i < m - 1) ? memo[i + 1][j] : 0) +
                            ((j < n - 1) ? memo[i][j + 1] : 0);
                }
            }
        }

        return memo[0][0];
    }

    private int totalWays(int m, int n, int i, int j, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        } else if (i >= m || i < 0 || j >= n || j < 0) {
            return 0;
        } else if (memo[i][j] == -1) {
            memo[i][j] = totalWays(m, n, i + 1, j, memo) + totalWays(m, n, i, j + 1, memo);
        }

        return memo[i][j];
    }
}
