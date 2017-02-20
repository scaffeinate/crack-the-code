/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/the-love-letter-mystery
 * 
 * @author Sudharsanan Muralidharan
 */
public class LoveLetterMystery {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      int count = 0;
      for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
        count += Math.abs(s.charAt(i) - s.charAt(j));
      }
      System.out.println(count);
    }
    in.close();
  }
}
