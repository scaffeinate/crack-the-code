/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/mars-exploration
 * 
 * @author Sudharsanan Muralidharan
 */
public class MarsExploration {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int numSOS = s.length() / 3;
    int count = 0;
    for (int i = 0; i < numSOS; i++) {
      int index = (i * 3);
      if (s.charAt(index) != 'S') {
        count++;
      }

      if (s.charAt(index + 1) != 'O') {
        count++;
      }

      if (s.charAt(index + 2) != 'S') {
        count++;
      }
    }

    System.out.println(count);

    in.close();
  }
}
