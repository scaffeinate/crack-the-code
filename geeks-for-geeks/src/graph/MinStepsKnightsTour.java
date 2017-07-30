package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Question: http://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
 */
public class MinStepsKnightsTour {
    public int minSteps(int[] position, int[] target, int N) {
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) board[i][j] = -1;
        board[position[0]][position[1]] = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{position[0], position[1]});
        int[][] directions = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int x = current[0], y = current[1];
            if (x == target[0] && y == target[1]) return board[x][y];
            for (int[] direction : directions) {
                int i = x + direction[0], j = y + direction[1];
                if (i >= 0 && i < N && j >= 0 && j < N && board[i][j] == -1) {
                    board[i][j] = 1 + board[x][y];
                    queue.offer(new Integer[]{i, j});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
