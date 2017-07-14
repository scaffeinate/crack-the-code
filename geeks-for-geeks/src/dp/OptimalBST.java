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
            for (int start = 0, end = start + len - 1; end < matrix.length; start++, end++) {
                int min = Integer.MAX_VALUE, base = 0;
                for (int r = start; r <= end; r++) {
                    min = Math.min(min, ((start == r) ? 0 : matrix[start][r - 1]) + ((r == end) ? 0 : matrix[r + 1][end]));
                    base += frequencies[r];
                }
                matrix[start][end] = min + base;
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
                int val = optimalWeightRecursive(keys, frequencies, memo, start, i - 1) +
                        optimalWeightRecursive(keys, frequencies, memo, i + 1, end);
                min = Math.min(min, val);
                base += frequencies[i];
            }
            memo[start][end] = min + base;
        }

        return memo[start][end];
    }
}
