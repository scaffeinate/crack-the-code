package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 * Solution: https://www.youtube.com/watch?v=WxpIHvsu1RI
 */
public class OptimalStrategyGamePicks {
    public int maxValue(int[] arr) {
        int n = arr.length, len = 2;
        int[][][] memo = new int[n][n][2];
        for (int i = 0; i < n; i++) memo[i][i][0] = arr[i];
        while (len <= n) {
            for (int start = 0, end = start + len - 1; end < n; start++, end++) {
                int p1 = memo[start][start][0] + memo[start + 1][end][1];
                int p2 = memo[start + 1][end][0] + memo[start][start][1];

                if ((memo[end][end][0] + memo[start][end - 1][1]) > p1) {
                    p1 = memo[end][end][0] + memo[start][end - 1][1];
                    p2 = memo[start][end - 1][0] + memo[end][end][1];
                }
                memo[start][end][0] = p1;
                memo[start][end][1] = p2;
            }
            len++;
        }

        return memo[0][n - 1][0];
    }
}
