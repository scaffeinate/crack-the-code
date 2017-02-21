/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/game-of-thrones
 * 
 * @author Sudharsanan Muralidharan
 */
public class GameOfThrones1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int bit = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      int index = (c - 'a');
      int val = (1 << index);
      if((bit & val) == 0) {
        bit |= val;
      } else {
        bit &= (Integer.MAX_VALUE - (int) Math.pow(2, index));
      }
    }

    System.out.println((bit & (bit - 1)) == 0 ? "YES" : "NO");
    in.close();
  }
}
