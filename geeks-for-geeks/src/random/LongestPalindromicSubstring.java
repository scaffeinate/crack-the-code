package random;

/**
 * Question: http://www.geeksforgeeks.org/?p=25714
 */
public class LongestPalindromicSubstring {
    public String longestPS(String input) {
        int maxLength = 1, start = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int x = i - 1, y = i + 1; x >= 0 && y < input.length() && input.charAt(x) == input.charAt(y); x--, y++) {
                int length = y - x + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = x;
                }
            }

            for (int x = i, y = i + 1; x >= 0 && y < input.length() && input.charAt(x) == input.charAt(y); x--, y++) {
                int length = y - x + 1;
                if (length > maxLength) {
                    maxLength = length;
                    start = x;
                }
            }
        }

        return input.substring(start, (start + maxLength));
    }
}