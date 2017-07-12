package dp;

/**
 * Question:
 * Solution:
 */
public class MatrixMultiplication {
    public int minOperations(int[][] matrices) {
        int[][] memo = new int[matrices.length][matrices.length];
        int len = 2;

        while (len <= matrices.length) {
            for (int start = 0, end = start + len - 1; end < matrices.length; start++, end++) {
                int min = Integer.MAX_VALUE;
                for (int r = start; r < end; r++) {
                    int total = memo[start][r] + memo[r + 1][end] + (matrices[start][0] * matrices[r][1] * matrices[end][1]);
                    min = Math.min(min, total);
                }
                memo[start][end] = min;
            }
            len++;
        }

        return memo[0][matrices.length - 1];
    }
}
