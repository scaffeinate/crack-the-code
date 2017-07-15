package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    public String longestPS(String input) {
        StringBuilder outputBuilder = new StringBuilder();
        int[][] matrix = new int[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) matrix[i][i] = 1;

        int len = 2;
        while (len <= input.length()) {
            for (int start = 0, end = start + len - 1; end < input.length(); start++, end++) {
                if (input.charAt(start) == input.charAt(end)) {
                    matrix[start][end] = matrix[start + 1][end - 1] + 2;
                } else {
                    matrix[start][end] = Math.max(matrix[start + 1][end], matrix[start][end - 1]);
                }
            }
            len++;
        }

        int i = 0, j = input.length() - 1;
        while (matrix[i][j] != 0) {
            if (input.charAt(i) == input.charAt(j)) {
                char c = input.charAt(i);
                int middle = outputBuilder.length() / 2;
                outputBuilder.insert(middle, c);
                if (i != j) {
                    outputBuilder.insert(middle + 1, c);
                }
                i++;
                j--;
            } else if (matrix[i][j] == matrix[i + 1][j]) {
                i++;
            } else if (matrix[i][j] == matrix[i][j - 1]) {
                j--;
            }
        }

        return outputBuilder.toString();
    }
}
