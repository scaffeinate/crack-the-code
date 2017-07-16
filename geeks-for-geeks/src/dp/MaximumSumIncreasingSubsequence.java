package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * Solution: https://www.youtube.com/watch?v=99ssGWhLPUE
 */
public class MaximumSumIncreasingSubsequence {
    public int maximumSum(int[] arr) {
        int maxSum = 0, maxIndex = 0;
        int[] memo = new int[arr.length];
        int[] sources = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            memo[i] = arr[i];
            sources[i] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && (memo[j] + arr[i] > memo[i])) {
                    memo[i] = memo[j] + arr[i];
                    sources[i] = j;
                }
            }
        }

        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > maxSum) {
                maxSum = memo[i];
                maxIndex = i;
            }
        }

        while (maxIndex != sources[maxIndex]) {
            System.out.print(arr[maxIndex] + " ");
            maxIndex = sources[maxIndex];
        }
        System.out.println(arr[maxIndex]);

        return maxSum;
    }

    public int maximumSumTopDown(int[] arr) {
        int[][] memo = new int[arr.length + 1][arr.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        return maximumSumTopDown(arr, 0, arr.length, memo);
    }

    private int maximumSumTopDown(int[] arr, int index, int prev, int[][] memo) {
        if (index == arr.length) return 0;
        if (memo[prev][index] == -1) {
            int max = 0;
            if (prev == arr.length || arr[prev] < arr[index]) {
                max = arr[index] + maximumSumTopDown(arr, index + 1, index, memo);
            }

            max = Math.max(max, maximumSumTopDown(arr, index + 1, prev, memo));
            memo[prev][index] = max;
        }
        return memo[prev][index];
    }
}
