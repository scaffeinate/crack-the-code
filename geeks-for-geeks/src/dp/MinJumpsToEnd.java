package dp;

import java.util.Arrays;

/**
 * Question: http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * Solution: https://www.youtube.com/watch?v=cETfFsSTGJI
 */
public class MinJumpsToEnd {
    public int minJumps(int[] arr) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return minJumps(arr, 0, memo);
    }

    public int minJumpsBottomUp(int[] arr) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, Integer.MAX_VALUE);

        for (int i = memo.length - 1; i >= 0; i--) {
            if (i == memo.length - 1) {
                memo[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                int n = Math.min(arr[i], memo.length - 1 - i);
                for (int j = 1; j <= n; j++) {
                    min = Math.min(min, memo[i + j]);
                }
                memo[i] = (min == Integer.MAX_VALUE) ? min : min + 1;
            }
        }

        return memo[0];
    }

    private int minJumps(int[] arr, int index, int[] memo) {
        if (index == arr.length - 1) {
            return 0;
        } else if (memo[index] == -1) {
            int min = Integer.MAX_VALUE;
            int n = Math.min(arr[index], arr.length - 1 - index);

            for (int i = 1; i <= n; i++) {
                min = Math.min(min, minJumps(arr, index + i, memo));
            }

            memo[index] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1;
        }
        return memo[index];
    }
}
