/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/caesar-cipher-1
 * 
 * @author Sudharsanan Muralidharan
 */
public class CaesarCipher {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String s = in.next();
    int k = in.nextInt();

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      int val = 0;
      k = (k > 26) ? (k % 26) : k;
      if (c >= 65 && c <= 90) {
        val = ((c + k) > 90) ? ((c + k) % 90 + 64) : (c + k);
      } else if (c >= 97 && c <= 122) {
        val = ((c + k) > 122) ? ((c + k) % 122 + 96) : (c + k);
      } else {
        val = (int) c;
      }

      builder.append(Character.toString((char) val));
    }

    System.out.println(builder.toString());
    in.close();
  }
}
