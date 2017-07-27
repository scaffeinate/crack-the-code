package dp;

/**
 * Question: http://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
 * Solution: https://www.youtube.com/watch?v=vi_1eHCsR9A
 */
public class LargestSubsquareXO {
    public int maxSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0) return max;

        int[][][] memo = new int[matrix.length][matrix[0].length][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'X') {
                    memo[i][j][0] = ((i == 0) ? 0 : memo[i - 1][j][0]) + 1;
                    memo[i][j][1] = ((j == 0) ? 0 : memo[i][j - 1][1]) + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                int size = Math.min(memo[i][j][0], memo[i][j][1]);
                while (size > max) {
                    if ((i - size + 1 >= 0 && memo[i - size + 1][j][1] >= size) &&
                            (j - size + 1 >= 0 && memo[i][j - size + 1][0] >= size)) {
                        max = size;
                    }
                    size--;
                }
            }
        }

        return max;
    }
}
