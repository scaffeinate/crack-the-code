package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    public String longestPS(String input) {
        StringBuilder outputBuilder = new StringBuilder();
        int[][] matrix = new int[input.length()][input.length()];
        int len = 2;

        for (int i = 0; i < input.length(); i++) {
            matrix[i][i] = 1;
        }

        while (len <= input.length()) {
            for (int i = 0; (i + len - 1) < input.length(); i++) {
                int j = (i + len - 1);
                if (input.charAt(i) == input.charAt(j)) {
                    matrix[i][j] = 2 + matrix[i + 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i + 1][j]);
                }
            }
            len++;
        }

        int i = 0, j = input.length() - 1;
        while (matrix[i][j] != 0) {
            if (matrix[i][j] == matrix[i][j - 1]) {
                j--;
            } else if (matrix[i][j] == matrix[i + 1][j]) {
                i++;
            } else if (matrix[i][j] == (matrix[i + 1][j - 1] + 2)) {
                char c1 = input.charAt(i);
                char c2 = input.charAt(j);
                String temp = (c1 + "" + c2);
                if (outputBuilder.length() == 0) {
                    outputBuilder.append(temp);
                } else {
                    outputBuilder.insert(outputBuilder.length() / 2, temp);
                }
                i++;
                j--;
            } else {
                outputBuilder.insert(outputBuilder.length() / 2, input.charAt(i));
                break;
            }
        }

        return outputBuilder.toString();
    }
}
