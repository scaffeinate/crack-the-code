/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/funny-string
 * 
 * @author Sudharsanan Muralidharan
 */
public class FunnyString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      String s = in.next();
      boolean funny = true;
      for (int i = 1, j = s.length() - 2; i <= j; i++, j--) {
        if (Math.abs(s.charAt(i) - s.charAt(i - 1)) != Math.abs(s.charAt(j) - s.charAt(j + 1))) {
          funny = false;
          break;
        }
      }

      System.out.println(funny ? "Funny" : "Not Funny");
    }
    in.close();
  }
}
