package chapter_8;

public class Box {
  public int width = 0, height = 0, depth = 0;

  public Box(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
  }

  public boolean greaterThan(Box box) {
    return (this.width > box.width && this.height > box.height && this.depth > box.depth);
  }
}
