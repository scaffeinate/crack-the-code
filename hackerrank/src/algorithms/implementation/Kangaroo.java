package algorithms.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo
 * 
 * @author Sudharsanan Muralidharan
 */
public class Kangaroo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x1 = in.nextInt();
    int v1 = in.nextInt();
    int x2 = in.nextInt();
    int v2 = in.nextInt();

    double val = ((double) (x2 - x1) / (v1 - v2));

    System.out.println(((val > 0) && (val % 1 == 0.0)) ? "YES" : "NO");

    in.close();
  }
}
