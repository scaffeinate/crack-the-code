package algorithms.implementation;

import java.util.Scanner;

/**
 * Solution: https://www.hackerrank.com/challenges/utopian-tree
 * 
 * @author Sudharsanan Muralidharan
 */
public class UtopianTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int height = (int) Math.pow(2, (n - ((n / 2) - 1))) - ((n % 2 == 0) ? 1 : 2);
      System.out.println(height);
    }
    in.close();
  }
}
