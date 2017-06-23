package chapter_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotInAGrid2 {

    public List<Cell> findPath(int[][] grid) {
        Map<Cell, List<Cell>> cache = new HashMap<Cell, List<Cell>>();
        List<Cell> path = findPath(grid, grid.length - 1, grid[0].length - 1, cache);
        return path == null ? new ArrayList<>() : path;
    }

    private List<Cell> findPath(int[][] grid, int i, int j, Map<Cell, List<Cell>> cache) {
        Cell currentCell = new Cell(i, j);
        List<Cell> path = new ArrayList<>();
        if (i < 0 || j < 0 || grid[i][j] == -1) {
            return null;
        } else if (i == 0 && j == 0) {
            path.add(new Cell(i, j));
            cache.put(currentCell, path);
        } else if (!cache.containsKey(currentCell)) {
            if ((path = findPath(grid, i, j - 1, cache)) != null || (path = findPath(grid, i - 1, j, cache)) != null) {
                path.add(new Cell(i, j));
                cache.put(currentCell, path);
            } else {
                cache.put(currentCell, null);
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
