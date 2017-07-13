package dp;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 * Solution: https://www.youtube.com/watch?v=TWHytKnOPaQ
 */
public class LongestBitonicSubsequence {
    public int longest(int[] arr) {
        int longest = 1;
        int[] memo = new int[arr.length];
        int[] reverseMemo = new int[arr.length];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
            reverseMemo[memo.length - i - 1] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    reverseMemo[i] = Math.max(reverseMemo[i], reverseMemo[j] + 1);
                }
            }
        }

        for (int i = 0; i < memo.length; i++) {
            longest = Math.max(longest, memo[i] + reverseMemo[i] - 1);
        }

        return longest;
    }
}
