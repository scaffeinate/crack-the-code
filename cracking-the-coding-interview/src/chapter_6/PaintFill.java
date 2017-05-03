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

  public String printDisplay(Point[][] display) {
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < display.length; i++) {
      for (int j = 0; j < display[0].length; j++) {
        builder.append(display[i][j].color.toString()).append(" ");
      }
      builder.append("\n");
    }

    return builder.toString();
  }

  private boolean liesWithin(Point[][] display, int x, int y) {
    return x < display.length && x >= 0 && y < display[0].length && y >= 0;
  }

  class Color {
    private int colorCode = 0;
    private String color;

    public Color(int colorCode, String color) {
      this.colorCode = colorCode;
      this.color = color;
    }

    @Override
    public String toString() {
      return this.colorCode + ":" + this.color;
    }
  }

  class Point {
    int x = 0, y = 0;
    Color color;

    public Point(int x, int y, Color color) {
      this.x = x;
      this.y = y;
      this.color = color;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((color == null) ? 0 : color.hashCode());
      result = prime * result + x;
      result = prime * result + y;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Point other = (Point) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (color == null) {
        if (other.color != null)
          return false;
      } else if (!color.equals(other.color))
        return false;
      if (x != other.x)
        return false;
      if (y != other.y)
        return false;
      return true;
    }

    @Override
    public String toString() {
      return "[" + x + ", " + y + "] => " + color.toString();
    }

    private PaintFill getOuterType() {
      return PaintFill.this;
    }
  }
}
