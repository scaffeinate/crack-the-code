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
}
