package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/angry-professor/
 * @author Sudharsanan Muralidharan
 */
public class AngryProfessor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int k = in.nextInt();
      int count = 0;
      for (int i = 0; i < n; i++) {
        int input = in.nextInt();
        count += (input > 0) ? 0 : 1;
      }
      System.out.println((count < k) ? "YES" : "NO");
    }
    in.close();
  }
}
