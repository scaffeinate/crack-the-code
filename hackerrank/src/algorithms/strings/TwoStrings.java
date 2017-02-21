/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/two-strings
 * 
 * @author Sudharsanan Muralidharan
 */
public class TwoStrings {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int p = in.nextInt();
    while (p-- > 0) {
      String a = in.next();
      String b = in.next();
      int[] arr = new int[26];
      boolean contains = false;

      for (int i = 0; i < a.length(); i++) {
        int index = a.charAt(i) - 'a';
        if (arr[index] <= 1) {
          arr[index]++;
        }
      }
      
      for (int i = 0; i < b.length(); i++) {
        int index = b.charAt(i) - 'a';
        if (arr[index] > 0) {
          contains = true;
          break;
        }
      }
      
      System.out.println(contains ? "YES" : "NO");
    }
    in.close();
  }
}
