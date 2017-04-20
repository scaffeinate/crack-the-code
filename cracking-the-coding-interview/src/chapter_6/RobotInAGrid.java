package chapter_6;

public class RobotInAGrid {

  public int numPaths(int[][] grid) {
    int[][] results = new int[grid.length][grid[0].length];
    for (int i = 0; i < results.length; i++) {
      for (int j = 0; j < results[0].length; j++) {
        results[i][j] = -1;
      }
    }

    return numPaths(grid, 0, 0, results);
  }

  private int numPaths(int[][] grid, int i, int j, int[][] results) {
    if (i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
      return 0;
    } else if (i == grid.length - 1 && j == grid[0].length - 1) {
      return 1;
    } else if (results[i][j] == -1) {
      results[i][j] = numPaths(grid, i + 1, j, results) + numPaths(grid, i, j + 1, results);
    }

    return results[i][j];
  }
}
