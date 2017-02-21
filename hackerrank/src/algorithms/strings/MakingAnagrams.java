/**
 * 
 */
package algorithms.strings;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/making-anagrams
 * 
 * @author Sudharsanan Muralidharan
 */
public class MakingAnagrams {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    int[] arr = new int[26];

    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      int index = c - 'a';
      arr[index]++;
    }

    int[] arr2 = new int[26];
    for (int i = 0; i < b.length(); i++) {
      char c = b.charAt(i);
      int index = c - 'a';
      arr2[index]++;
    }

    int count = 0;
    for (int i = 0; i < 26; i++) {
      count += Math.abs(arr[i] - arr2[i]);
    }

    System.out.println(count);
    in.close();
  }
}
