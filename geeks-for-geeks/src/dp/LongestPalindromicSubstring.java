package dp;

/**
 * Question: http://www.geeksforgeeks.org/?p=25463
 */
public class LongestPalindromicSubstring {
    public String longestPS(String input) {
        StringBuilder outputBuilder = new StringBuilder();
        String reverse = new StringBuilder(input).reverse().toString();
        int[][] matrix = new int[input.length() + 1][input.length() + 1];
        Tuple max = new Tuple(0, 0, Integer.MIN_VALUE);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (input.charAt(i - 1) == reverse.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (matrix[i][j] > max.val) {
                        max.i = i;
                        max.j = j;
                        max.val = matrix[i][j];
                    }
                }
            }
        }

        for (int i = max.i, j = max.j; matrix[i][j] > 0; i--, j--) {
            outputBuilder.append(input.charAt(i - 1));
        }

        return outputBuilder.toString();
    }

    class Tuple {
        int i, j;
        int val;

        public Tuple(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

    }
}
