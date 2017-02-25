/**
 * 
 */
package algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * 
 * @author Sudharsanan Muralidharan
 */
public class SherlockAndAnagrams {
  private static boolean checkAnagram(String str, String str2) {
    int[] arr = new int[26];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int val = c - 'a';
      arr[val]++;
    }

    for (int i = 0; i < str2.length(); i++) {
      char c = str2.charAt(i);
      int val = c - 'a';
      arr[val]--;
    }

    for (int i = 0; i < 26; i++) {
      if (arr[i] > 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s = in.next();
      List<String> subStrings = new ArrayList<String>();
      for (int i = 0; i < s.length(); i++) {
        StringBuilder builder = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
          builder.append(s.charAt(j));
          subStrings.add(builder.toString());
        }
      }

      Collections.sort(subStrings, new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
        }
      });

      int count = 0;
      for (int i = 0; i < subStrings.size(); i++) {
        int j = i + 1;
        String str = subStrings.get(i), str2 = null;
        while (j < subStrings.size() - 1 && str.length() == (str2 = subStrings.get(j)).length()) {
          if (checkAnagram(str, str2)) {
            count++;
          }
          j++;
        }
      }

      System.out.println(count);
    }
    in.close();
  }
}
