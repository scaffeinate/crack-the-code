package chapter_6;

public class RobotInAGrid {

  public int numPaths(int[][] grid) {
    int[][] table = new int[grid.length][grid[0].length];
    initTable(table);
    return numPaths(grid, 0, 0, table);
  }

  private int numPaths(int[][] grid, int i, int j, int[][] table) {
    if (i >= grid.length || j >= grid[0].length || grid[i][j] == -1) {
      return 0;
    } else if (i == grid.length - 1 && j == grid[0].length - 1) {
      return 1;
    } else if (table[i][j] == -1) {
      table[i][j] = numPaths(grid, i + 1, j, table) + numPaths(grid, i, j + 1, table);
    }

    return table[i][j];
  }

  public int numPathsMemoized(int[][] grid) {
    int[][] results = new int[grid.length][grid[0].length];
    initTable(results);
    return numPathsMemoized(grid, grid.length - 1, grid[0].length - 1, results);
  }

  private int numPathsMemoized(int[][] grid, int i, int j, int[][] results) {
    if (i < 0 || j < 0 || grid[i][j] == -1) {
      return 0;
    } else if (i == 0 && j == 0) {
      return 1;
    } else if (results[i][j] == -1) {
      results[i][j] = numPathsMemoized(grid, i, j - 1, results) + numPathsMemoized(grid, i - 1, j, results);
    }

    return results[i][j];
  }

  private void initTable(int[][] table) {
    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table[0].length; j++) {
        table[i][j] = -1;
      }
    }
  }
}