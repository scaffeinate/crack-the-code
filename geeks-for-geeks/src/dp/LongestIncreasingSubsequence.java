package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * Solution: https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LongestIncreasingSubsequence {
    public int longestSeqTopDown(int[] arr) {
        int[][] memo = new int[arr.length + 1][arr.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return longestSeqTopDown(arr, 0, arr.length, memo);
    }

    private int longestSeqTopDown(int[] arr, int index, int prev, int[][] memo) {
        if (index == arr.length) return 0;

        if (memo[prev][index] == -1) {
            int max = 0;
            if (prev == arr.length || arr[prev] < arr[index]) {
                max = 1 + longestSeqTopDown(arr, index + 1, index, memo);
            }

            max = Math.max(max, longestSeqTopDown(arr, index + 1, prev, memo));
            memo[prev][index] = max;
        }

        return memo[prev][index];
    }


    public int longestSeqDP(int[] arr) {
        int[] memo = new int[arr.length];
        int[] trace = new int[arr.length];
        int j = 1;
        while (j < arr.length) {
            for (int i = 0; i < j; i++) {
                if ((arr[i] < arr[j]) && (memo[i] + 1 > memo[j])) {
                    memo[j] = memo[i] + 1;
                    trace[j] = i;
                }
            }
            j++;
        }

        int max = memo[0];
        for (int i = 1; i < memo.length; i++) {
            max = Math.max(max, memo[i]);
        }

        return max + 1;
    }
}
