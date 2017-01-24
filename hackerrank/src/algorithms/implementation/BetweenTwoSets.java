package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/between-two-sets
 * 
 * @author Sudharsanan Muralidharan
 */
public class BetweenTwoSets {

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, (a % b));
  }

  private static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
  }

  private static int getNumFactors(int n) {
    int count = 0;
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n / i == i) {
        count++;
      } else if (n % i == 0) {
        count += 2;
      }
    }

    return count;
  }

  private static int lcmOf(int[] arr) {
    int temp = arr[0];
    for (int i = 1; i < arr.length; i++) {
      temp = lcm(temp, arr[i]);
    }

    return temp;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int[] b = new int[m];

    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int lcm = lcmOf(a);

    for (int i = 0; i < m; i++) {
      int x = in.nextInt();
      if (x % lcm == 0) {
        b[i] = x / lcm;
      }
    }

    int gcd = b[0];
    for (int i = 1; i < m; i++) {
      gcd = gcd(gcd, b[i]);
    }

    System.out.println(getNumFactors(gcd));
    in.close();
  }
}
