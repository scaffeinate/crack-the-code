package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 * Solution: https://www.youtube.com/watch?v=yCQN096CwWM
 */
public class MaximumSumRectangularSubMatrix {
    public int maximumSum(int[][] matrix) {
        int[] memo = new int[matrix.length];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    memo[k] += matrix[k][j];
                }

                maxSum = Math.max(maxSum, kadane(memo));
            }
            memo = new int[memo.length];
        }

        return maxSum;
    }

    private int kadane(int[] arr) {
        int sum = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}
