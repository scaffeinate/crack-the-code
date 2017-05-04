package chapter_6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PaintFill {

  public void fill(Point[][] display, Point point, Color newColor) {
    if (liesWithin(display, point.x, point.y)) {
      fill(display, point, point.color, newColor, new HashSet<Point>());
    }
  }

  private void fill(Point[][] display, Point point, Color originalColor, Color newColor, Set<Point> visited) {
    if (point.color.colorCode != originalColor.colorCode) {
      return;
    }
    point.color = newColor;

    visited.add(point);

    int x = point.x;
    int y = point.y;

    if (liesWithin(display, x + 1, y) && !visited.contains(display[x + 1][y])) {
      fill(display, display[x + 1][y], originalColor, newColor, visited);
    }

    if (liesWithin(display, x, y + 1) && !visited.contains(display[x][y + 1])) {
      fill(display, display[x][y + 1], originalColor, newColor, visited);
    }

    if (liesWithin(display, x - 1, y) && !visited.contains(display[x - 1][y])) {
      fill(display, display[x - 1][y], originalColor, newColor, visited);
    }

    if (liesWithin(display, x, y - 1) && !visited.contains(display[x][y - 1])) {
      fill(display, display[x][y - 1], originalColor, newColor, visited);
    }
  }

  public void fill2(Point[][] display, Point point, Color newColor) {
    Set<Point> visited = new HashSet<Point>();
    Queue<Point> queue = new LinkedList<Point>();
    Color originalColor = point.color;
    
    queue.add(point);
    while (!queue.isEmpty()) {
      Point current = queue.poll();
      int x = current.x;
      int y = current.y;
      visited.add(current);

      if (current.color.colorCode == originalColor.colorCode) {
        current.color = newColor;
      } else {
        continue;
      }

      if (liesWithin(display, x + 1, y) && !visited.contains(display[x + 1][y])) {
        queue.add(display[x + 1][y]);
      }

      if (liesWithin(display, x, y + 1) && !visited.contains(display[x][y + 1])) {
        queue.add(display[x][y + 1]);
      }

      if (liesWithin(display, x - 1, y) && !visited.contains(display[x - 1][y])) {
        queue.add(display[x - 1][y]);
      }

      if (liesWithin(display, x, y - 1) && !visited.contains(display[x][y - 1])) {
        queue.add(display[x][y - 1]);
      }
    }
  }

  private boolean liesWithin(Point[][] display, int x, int y) {
    return x < display.length && x >= 0 && y < display[0].length && y >= 0;
  }
}