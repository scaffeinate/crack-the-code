package chapter_8;

public class Box {
  public int width = 0, height = 0, depth = 0;

  public Box(int width, int height, int depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
  }

  public boolean greaterThan(Box box) {
    return (this.width >= box.width && this.height >= box.height && this.depth >= box.depth);
  }
  
  

  @Override
  public String toString() {
    return "Box [width=" + width + ", height=" + height + ", depth=" + depth + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + depth;
    result = prime * result + height;
    result = prime * result + width;
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
    Box other = (Box) obj;
    if (depth != other.depth)
      return false;
    if (height != other.height)
      return false;
    if (width != other.width)
      return false;
    return true;
  }
}
