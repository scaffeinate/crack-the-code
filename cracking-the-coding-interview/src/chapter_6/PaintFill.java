package chapter_6;

import java.util.HashSet;
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

  public static String printDisplay(Point[][] display) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < display.length; i++) {
      for (int j = 0; j < display[0].length; j++) {
        builder.append(display[i][j].color.colorCode).append(" ");
      }
      builder.append("\n");
    }

    return builder.toString();
  }

  private boolean liesWithin(Point[][] display, int x, int y) {
    return x < display.length && x >= 0 && y < display[0].length && y >= 0;
  }
}