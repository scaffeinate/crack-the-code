package dp;

import java.util.Arrays;

/**
 * Created by sudharti on 7/15/17.
 */
public class MinJumpsToEnd {
    public int minJumps(int[] arr) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return minJumps(arr, 0, memo);
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
