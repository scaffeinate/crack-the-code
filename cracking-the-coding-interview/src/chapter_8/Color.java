package chapter_8;

public class Color {
  public int colorCode = 0;
  public String color;

  public Color(int colorCode, String color) {
    this.colorCode = colorCode;
    this.color = color;
  }

  @Override
  public String toString() {
    return this.colorCode + ":" + this.color;
  }
}
