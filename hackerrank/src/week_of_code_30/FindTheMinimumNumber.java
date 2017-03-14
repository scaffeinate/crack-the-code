package week_of_code_30;

import java.util.Scanner;

public class FindTheMinimumNumber {

  private static String findMin(int n) {
    return findMin(0, n);
  }

  private static String findMin(int i, int n) {
    StringBuilder builder = new StringBuilder();
    if (i == n - 1) {
      return "int";
    } else {
      builder.append("min(int, ").append(findMin(i + 1, n)).append(")");
      return builder.toString();
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(findMin(n));
    in.close();
  }
}
