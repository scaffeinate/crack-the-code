/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge:
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 * 
 * @author Sudharsanan Muralidharan
 */
public class JumpingOnTheClouds {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int c[] = new int[n];
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
    }

    int i = 0;
    int E = 100;
    do {
      i = ((i + k) % n);
      E = E - ((c[i] == 0) ? 1 : 3);
    } while (i != 0);

    System.out.println(E);
    in.close();
  }
}
