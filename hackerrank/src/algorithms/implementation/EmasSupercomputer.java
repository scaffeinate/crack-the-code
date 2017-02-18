/**
 * 
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/two-pluses
 * 
 * @author Sudharsanan Muralidharan
 */
public class EmasSupercomputer {

  static class Cell {
    int i = 0;
    int j = 0;

    Cell(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + i;
      result = prime * result + j;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      Cell other = (Cell) obj;
      return this.i == (other.i) && this.j == (other.j);
    }
  }

  private static List<Set<Cell>> crossesList = new ArrayList<Set<Cell>>();

  private static void findCrosses(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 'G') {
          Cell cell = new Cell(i, j);
          crossesList.addAll(contructCrosses(cell, grid));
        }
      }
    }

    int max = 0;
    for (int i = 0; i < crossesList.size(); i++) {
      for (int j = i + 1; j < crossesList.size(); j++) {
        Set<Cell> set1 = crossesList.get(i);
        Set<Cell> set2 = crossesList.get(j);
        int product = 0;

        if (!intersects(set1, set2)) {
          product = set1.size() * set2.size();
        }

        if (product > max) {
          max = product;
        }
      }
    }

    System.out.println(max);
  }

  private static boolean intersects(Set<Cell> set1, Set<Cell> set2) {
    Set<Cell> larger = (set1.size() > set2.size()) ? set1 : set2;
    Set<Cell> smaller = (set1.size() > set2.size()) ? set2 : set1;
    for (Cell cell : smaller) {
      if (larger.contains(cell)) {
        return true;
      }
    }

    return false;
  }

  private static List<Set<Cell>> contructCrosses(Cell cell, char[][] grid) {
    int i = cell.i, j = cell.j, x = 0;
    List<Set<Cell>> cellsList = new ArrayList<Set<Cell>>();
    Set<Cell> crossList = new HashSet<Cell>();
    crossList.add(new Cell(i, j));
    cellsList.add(crossList);

    while ((i - x) > 0 && (i + x) < grid.length - 1 && (j - x) > 0 && (j + x) < grid[0].length - 1) {
      x++;
      if (grid[i][j - x] == 'G' && grid[i][j + x] == 'G' && grid[i - x][j] == 'G' && grid[i + x][j] == 'G') {
        crossList.add(new Cell(i, j - x));
        crossList.add(new Cell(i, j + x));
        crossList.add(new Cell(i - x, j));
        crossList.add(new Cell(i + x, j));
      } else {
        break;
      }

      cellsList.add(new HashSet<Cell>(crossList));
    }
    return cellsList;

  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    char[][] grid = new char[n][m];

    for (int i = 0; i < n; i++) {
      String line = in.next();
      for (int j = 0; j < line.length(); j++) {
        grid[i][j] = line.charAt(j);
      }
    }

    findCrosses(grid);

    in.close();
  }
}
