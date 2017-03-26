package algorithms.sort;

import java.util.Scanner;

public class Staircase {

  static long numCombinations(int n) {
    long sum = 0;
    if (n == 0) {
      return 1;
    } else if (n > 0) {
      for (int j = 1; j <= 3; j++) {
        sum += numCombinations(n - j);
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(numCombinations(n));
    in.close();
  }
}
