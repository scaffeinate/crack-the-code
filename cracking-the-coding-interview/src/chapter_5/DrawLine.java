package chapter_5;

public class DrawLine {

  public String drawLine(byte[] screen, int width, int x1, int x2, int y) {
    if (x1 >= width || x2 >= width) {
      return printScreen(screen, width);
    }

    int startIndex = (x1 % 8);
    int startArrIndex = ((y * width) + x1) / 8;
    int lineLength = (x2 - x1) + 1;
    while (lineLength > 0) {
      int j = (8 - startIndex - 1), i = 0;
      if ((startIndex + lineLength) >= 8) {
        i = 0;
        lineLength -= (8 - startIndex);
      } else {
        i = lineLength - 1;
        lineLength = 0;
      }
      screen[startArrIndex] = (byte) (screen[startArrIndex] | fetchMask(i, j));
      startIndex = 0;
      startArrIndex++;
    }

    return printScreen(screen, width);
  }

  private String printScreen(byte[] screen, int width) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < screen.length; i++) {
      builder.append(Integer.toBinaryString(screen[i] & 255 | 256).substring(1));
      if ((((i + 1) * 8) % width) == 0) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }

  private byte fetchMask(int i, int j) {
    return (byte) ((~0 << i) & ((1 << (j + 1)) - 1));
  }

  public static void main(String[] args) {
    // System.out.println(Integer.toBinaryString(fetchMask(0, 6)));
    new DrawLine().drawLine(new byte[8], 16, 0, 7, 2);
  }
}
