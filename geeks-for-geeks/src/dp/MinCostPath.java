package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 * Solution: https://www.youtube.com/watch?v=fMZMm_0ZhK4
 */
public class MinCostPath {
    public int minCost(int[][] matrix, int m, int n) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                memo[i][j] = -1;
            }
        }

        return minCost(matrix, 0, 0, m, n, memo);
    }

    private int minCost(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if (i == m && j == n) {
            return matrix[i][j];
        } else if (i >= matrix.length || i < 0 || j >= matrix[i].length || j < 0) {
            return Integer.MAX_VALUE;
        } else if (memo[i][j] == -1) {
            int min = minOf(minCost(matrix, i, j + 1, m, n, memo), minCost(matrix, i + 1, j, m, n, memo),
                    minCost(matrix, i + 1, j + 1, m, n, memo));
            memo[i][j] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + matrix[i][j];
        }

        return memo[i][j];
    }

    public int minCostBottomup(int[][] matrix, int m, int n) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    memo[i][j] = matrix[i][j];
                } else {
                    int min = minOf(
                            helper(memo, i + 1, j, m, n),
                            helper(memo, i, j + 1, m, n),
                            helper(memo, i + 1, j + 1, m, n));
                    memo[i][j] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + matrix[i][j];
                }
            }
        }

        return memo[0][0];
    }

    private int helper(int[][] memo, int i, int j, int m, int n) {
        if (i > m || i < 0 || j > n || j < 0) {
            return Integer.MAX_VALUE;
        }

        return memo[i][j];
    }

    private int minOf(int... values) {
        int min = Integer.MAX_VALUE;
        for (int val : values) {
            min = Math.min(min, val);
        }

        return min;
    }
}
