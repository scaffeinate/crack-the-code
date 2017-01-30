package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/kaprekar-numbers
 * 
 * @author Sudharsanan Muralidharan
 */
public class ModifiedKaprekarNumbers {

  private static boolean splitAndCheck(int n, int q) {
    long square = (long) Math.pow(n, 2);
    long temp = square;
    long mod = 0;
    int div = 1;

    int d = Integer.toString(n).length();
    for (int i = 0; i < d; i++) {
      div *= 10;
    }
    temp = square / div;
    mod = square % div;

    return (div <= q) && ((temp + mod) == n);
  }

  private static int base(int n) {
    int base = 1;
    while (n > 1) {
      n = n / 10;
      base *= 10;
    }

    return base;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    int q = in.nextInt();
    List<Integer> results = new ArrayList<Integer>();

    for (int i = p; i <= q; i++) {
      if (splitAndCheck(i, base(q))) {
        results.add(i);
      }
    }

    if (results.isEmpty()) {
      System.out.println("INVALID RANGE");
    } else {
      for (Integer result : results) {
        System.out.print(result + " ");
      }
    }
    in.close();
  }
}
