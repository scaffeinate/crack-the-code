package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 * Solution: https://www.youtube.com/watch?v=yCQN096CwWM
 */
public class MaximumSumRectangularSubMatrix {
    public int[] maximumSum(int[][] matrix) {
        int[] memo = new int[matrix.length];
        int[] result = new int[5];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    memo[k] += matrix[k][j];
                }

                int[] res = kadane(memo);
                if (res[0] > maxSum) {
                    maxSum = result[0] = res[0];
                    result[1] = res[1];
                    result[2] = res[2];
                    result[3] = i;
                    result[4] = j;
                }
            }
            memo = new int[memo.length];
        }

        return result;
    }

    private int[] kadane(int[] arr) {
        int sum = arr[0], max = arr[0], j = 0;
        int[] result = {sum, 0, 0};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > (arr[i] + sum)) {
                sum = arr[i];
                j = i;
            } else {
                sum = (arr[i] + sum);
            }

            if (sum > max) {
                result[0] = sum;
                result[1] = j;
                result[2] = i;
            }
        }
        return result;
    }
}
