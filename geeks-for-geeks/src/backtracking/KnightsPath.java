package backtracking;

/**
 * Question: http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */
public class KnightsPath {
    public void path(int[][] board, int[] position) {
        int[][] directions = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        path(board, position[0], position[1], directions, 1);
    }

    private boolean path(int[][] board, int i, int j, int[][] directions, int number) {
        board[i][j] = number;

        if (number == 64) return true;

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (isSafe(board, x, y) && path(board, x, y, directions, number + 1)) {
                return true;
            }
        }

        board[i][j] = 0;
        return false;
    }

    private boolean isSafe(int[][] board, int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] == 0;
    }

    public static void main(String[] args) {
        KnightsPath knightsPath = new KnightsPath();
        int[][] board = new int[8][8];
        knightsPath.path(board, new int[]{0, 0});
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(String.format("%2d", board[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
