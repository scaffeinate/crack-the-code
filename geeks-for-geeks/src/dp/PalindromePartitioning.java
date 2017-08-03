package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 * Solution: https://www.youtube.com/watch?v=lDYIvtBVmgo
 */
public class PalindromePartitioning {
    public int minCuts(String s) {
        if (s.length() == 0) return 0;
        int[][] memo = new int[s.length()][s.length()];
        int len = 2;
        while (len <= s.length()) {
            for (int start = 0, end = start + len - 1; end < s.length(); start++, end++) {
                if (s.charAt(start) == s.charAt(end) && memo[start + 1][end - 1] == 0) {
                    memo[start][end] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int r = start; r < end; r++) {
                        min = Math.min(min, (memo[start][r] + memo[r + 1][end] + 1));
                    }
                    memo[start][end] = min;
                }
            }
            len++;
        }
        return memo[0][s.length() - 1];
    }
}
