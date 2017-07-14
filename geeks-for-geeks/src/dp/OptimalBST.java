package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 * Solution: https://www.youtube.com/watch?v=hgA4xxlVvfQ
 */
public class OptimalBST {
    public int optimalWeight(int[] keys, int[] frequencies) {
        int[][] matrix = new int[keys.length][keys.length];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = frequencies[i];
        }

        int len = 2;
        while (len <= matrix.length) {
            for (int i = 0; i < matrix.length - len + 1; i++) {
                int r = i + len - 1;
                int freqSum = frequencies[i], min = matrix[i + 1][r];
                for (int j = i + 1; j <= r; j++) {
                    min = Math.min(min, (matrix[i][j - 1] + ((j < r ? matrix[j + 1][r] : 0))));
                    freqSum += frequencies[j];
                }
                matrix[i][r] = min + freqSum;
            }
            len++;
        }

        return matrix[0][keys.length - 1];
    }

    public int optimalWeightRecursive(int[] keys, int[] frequencies) {
        int[][] memo = new int[keys.length][keys.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }

        return optimalWeightRecursive(keys, frequencies, memo, 0, keys.length - 1);
    }

    private int optimalWeightRecursive(int[] keys, int[] frequencies, int[][] memo, int start, int end) {
        if (start > end) {
            return 0;
        } else if (start == end) {
            return frequencies[start];
        } else if (memo[start][end] == -1) {
            int min = Integer.MAX_VALUE, base = 0;
            for (int i = start; i <= end; i++) {
                base += frequencies[i];
            }

            for (int i = start; i <= end; i++) {
                int val = optimalWeightRecursive(keys, frequencies, memo, start, i - 1) +
                        optimalWeightRecursive(keys, frequencies, memo, i + 1, end);
                min = Math.min(min, (val + base));
            }
            memo[start][end] = min;
        }

        return memo[start][end];
    }
}
