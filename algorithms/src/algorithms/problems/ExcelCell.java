package algorithms.problems;

import java.util.Scanner;

public class ExcelCell {

  public static String computeCell(int n) {
    return computeCell(n, (n % 26) == 0);
  }

  public static String computeCell(int n, boolean modZero) {
    StringBuilder builder = new StringBuilder();
    if (n < 26) {
      return String.valueOf((Character.valueOf((char) (n + 'A' - (modZero ? 2 : 1)))));
    } else {
      if (n / 26 == 1) {
        return "Z";
      } else {
        builder.append(computeCell((n / 26), (n % 26) == 0))
            .append((n % 26) == 0 ? 'Z' : Character.valueOf((char) ((n % 26) + 'A' - 1)));
      }
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(computeCell(n));
    in.close();
  }
}
