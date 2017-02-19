/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/camelcase
 * 
 * @author Sudharsanan Muralidharan
 */
public class CamelCase {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    int count = 1;
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(c >= 65 && c <= 90) {
        count++;
      }
    }
    
    System.out.println(count);

    in.close();
  }
}
