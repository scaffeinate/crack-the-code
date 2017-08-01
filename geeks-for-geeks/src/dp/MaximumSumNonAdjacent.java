package dp;

/**
 * Question: http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class MaximumSumNonAdjacent {
    public int maxSum(int[] arr) {
        int[][] memo = new int[arr.length + 1][arr.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return maxSum(arr, 0, arr.length, memo);
    }

    public int maxSumBottomUp(int[] arr) {
        int[] memo = new int[arr.length + 1];
        memo[1] = Math.max(0, arr[0]);
        for (int i = 2; i < memo.length; i++) {
            memo[i] = Math.max(arr[i - 1], Math.max(memo[i - 1], arr[i - 1] + memo[i - 2]));
        }
        return memo[arr.length];
    }

    private int maxSum(int[] arr, int index, int prev, int[][] memo) {
        if (index == arr.length) return 0;
        if (memo[prev][index] == -1) {
            int max = maxSum(arr, index + 1, prev, memo);
            if ((index) != prev + 1) {
                max = Math.max(max, maxSum(arr, index + 1, index, memo) + arr[index]);
            }
            memo[prev][index] = max;
        }
        return memo[prev][index];
    }
}
