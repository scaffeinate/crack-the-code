/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/beautiful-binary-string
 * 
 * @author Sudharsanan Muralidharan
 */
public class BeautifulBinaryString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String b = in.next();

    int i = 0, count = 0;
    while (i < (n - 2)) {
      if (b.charAt(i) == '0' && b.charAt(i + 1) == '1' && b.charAt(i + 2) == '0') {
        count++;
        i += 3;
      } else {
        i++;
      }
    }

    System.out.println(count);
    in.close();
  }
}
