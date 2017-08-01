package dp;

/**
 * Question: http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 */
public class CountBinaryWithoutConsecutiveOnes {
    public int count(int N) {
        int[][] memo = new int[N + 1][2];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return countBinary(N, false, memo);
    }

    private int countBinary(int N, boolean prevSet, int[][] memo) {
        if (N == 0) return 1;
        int i = (prevSet) ? 1 : 0;
        if (memo[N][i] == -1) {
            memo[N][i] = countBinary(N - 1, false, memo);
            if (!prevSet) {
                memo[N][i] += countBinary(N - 1, true, memo);
            }
        }
        return memo[N][i];
    }

    public int countBottomUp(int N) {
        int a = 1, b = 1, c = 0;
        for (int i = 1; i <= N; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
