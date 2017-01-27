package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 * 
 * @author Sudharsanan Muralidharan
 */
public class BeautifulDaysAtTheMovies {

  private static int reverse(int x, int base) {
    if (base == 0) {
      return x;
    }

    int digit = (x % 10);
    int num = (x / 10);

    return (digit * base) + reverse(num, base / 10);
  }

  private static int base(int x) {
    int base = 1;
    while (x / (base * 10) > 0) {
      base *= 10;
    }
    return base;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i = in.nextInt();
    int j = in.nextInt();
    int k = in.nextInt();
    int count = 0;

    for (int x = i; x <= j; x++) {
      if ((Math.abs(x - reverse(x, base(x))) % k) == 0) {
        count++;
      }
    }

    System.out.println(count);
    in.close();
  }
}
