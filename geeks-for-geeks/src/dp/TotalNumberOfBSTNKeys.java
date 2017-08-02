package dp;

/**
 * Question: http://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
 * Solution: https://www.youtube.com/watch?v=YDf982Lb84o
 */
public class TotalNumberOfBSTNKeys {
    public long totalWays(int N) {
        long[] memo = new long[N + 1];
        memo[0] = 1;
        for (int i = 1; i <= N; i++) {
            long sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += (memo[j - 1] * memo[i - j]);
            }
            memo[i] = sum;
        }

        return memo[N];
    }
}
