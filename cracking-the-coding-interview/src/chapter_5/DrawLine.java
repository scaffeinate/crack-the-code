package chapter_5;

public class DrawLine {

  public byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
    int rows = ((screen.length * 8) / width);
    if (x1 >= width || x2 >= width || (y >= rows)) {
      return screen;
    }

    int startArrIndex = ((y * width) + x1) / 8;
    int startPos = (x1 % 8), endPos = (x2 > 8) ? 7 : x2;
    int lineLengthLeft = (x2 - x1) + 1;

    while (lineLengthLeft > 0) {
      screen[startArrIndex] |= fetchMask(startPos, endPos);

      if ((startPos + lineLengthLeft) < 8) {
        endPos = lineLengthLeft;
        lineLengthLeft = 0;
      } else {
        lineLengthLeft -= ((endPos - startPos) + 1);
        startPos = 0;
        endPos = (lineLengthLeft > 8) ? 7 : (lineLengthLeft - 1);
      }

      startArrIndex++;
    }

    return screen;
  }

  public String printScreen(byte[] screen, int width) {
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
    byte leftMask = (byte) ((~0) << (8 - j - 1));
    byte rightMask = (byte) ((1 << (8 - i)) - 1);
    return (byte) (leftMask & rightMask);
  }
}
