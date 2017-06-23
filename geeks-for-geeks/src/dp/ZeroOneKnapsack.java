package dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 */
public class ZeroOneKnapsack {
    public int knapsack(int n, List<Integer[]> items) {
        return knapsack(n, items, 0);
    }

    private int knapsack(int n, List<Integer[]> items, int index) {
        if (n <= 0 || index >= items.size()) {
            return 0;
        }

        Integer[] item = items.get(index);
        if (item[0] > n) {
            return knapsack(n, items, index + 1);
        } else {
            return Math.max(item[1] + knapsack(n - item[0], items, index + 1),
                    knapsack(n, items, index + 1));
        }
    }

    public int knapsackMemoized(int n, List<Integer[]> items) {
        return knapsackMemoized(n, items, 0, new HashMap<String, Integer>());
    }

    private int knapsackMemoized(int n, List<Integer[]> items, int index, Map<String, Integer> memo) {
        if (index >= items.size() || n <= 0) {
            return 0;
        } else {
            Integer[] item = items.get(index);
            int max = 0;
            String key = new StringBuilder().append(items.size() - index - 1).append(":").append(n).toString();
            if (!memo.containsKey(key)) {
                if (item[0] > n) {
                    max = knapsackMemoized(n, items, index + 1, memo);
                } else {
                    max = Math.max(item[1] + knapsackMemoized(n - item[0], items, index + 1, memo),
                            knapsackMemoized(n, items, index + 1, memo));
                }
                memo.put(key, max);
            }
            return memo.get(key);
        }
    }

    public int knapsackDP(int n, List<Integer[]> items) {
        int[][] memo = new int[items.size() + 1][n + 1];

        for (int i = 1; i < memo.length; i++) {
            Integer[] item = items.get(i - 1);
            for (int j = 1; j < memo[i].length; j++) {
                if (j < item[0]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = Math.max(item[1] + memo[i - 1][j - item[0]], memo[i - 1][j]);
                }
            }
        }

        return memo[items.size()][n];
    }
}
