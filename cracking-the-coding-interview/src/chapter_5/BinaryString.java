package chapter_5;

public class BinaryString {
  public String toBinaryString(double num) {
    StringBuilder builder = new StringBuilder();
    builder.append("0.");
    int counter = 0;
    while (num > 0) {
      if (counter > 32) {
        return "ERROR";
      }
      num = num * 2;
      if (num >= 1) {
        builder.append(1);
        num -= 1;
      } else {
        builder.append(0);
      }
      counter++;
    }
    return builder.toString();
  }
}
