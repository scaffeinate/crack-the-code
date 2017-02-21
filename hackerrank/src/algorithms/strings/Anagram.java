/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/anagram
 * 
 * @author Sudharsanan Muralidharan
 */
public class Anagram {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      int[] arr = new int[26];
      if (s.length() % 2 != 0) {
        System.out.println(-1);
      } else {
        for (int i = 0; i < s.length() / 2; i++) {
          char c = s.charAt(i);
          int index = c - 'a';
          arr[index]++;
        }

        for (int i = (s.length() / 2); i < s.length(); i++) {
          char c = s.charAt(i);
          int index = c - 'a';
          if (arr[index] > 0) {
            arr[index]--;
          }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
          count += arr[i];
        }

        System.out.println(count);
      }
    }
    in.close();
  }
}
