package chapter_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotInAGrid2 {

  public List<Cell> findPath(int[][] grid) {
    List<Cell> path = new ArrayList<Cell>();
    Map<Cell, Boolean> cache = new HashMap<Cell, Boolean>();
    findPath(grid, grid.length - 1, grid[0].length - 1, cache, path);
    return path;
  }

  private boolean findPath(int[][] grid, int i, int j, Map<Cell, Boolean> cache, List<Cell> path) {
    Cell currentCell = new Cell(i, j);
    if (i < 0 || j < 0 || grid[i][j] == -1) {
      return false;
    } else if (i == 0 && j == 0) {
      path.add(new Cell(i, j));
      cache.put(currentCell, true);
    } else if (!cache.containsKey(currentCell)) {
      if (findPath(grid, i, j - 1, cache, path) || findPath(grid, i - 1, j, cache, path)) {
        path.add(new Cell(i, j));
        cache.put(currentCell, true);
      } else {
        cache.put(currentCell, false);
      }
    }

    return cache.get(currentCell);
  }

  public class Cell {
    int i, j;

    public Cell(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + RobotInAGrid2.this.hashCode();
      result = prime * result + i;
      result = prime * result + j;
      return result;
    }

    @Override
    public String toString() {
      return i + "," + j;
    }
  }
}
