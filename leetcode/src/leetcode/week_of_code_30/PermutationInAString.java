package leetcode.week_of_code_30;

import java.util.Scanner;

public class PermutationInAString {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s1 = in.next();
    String s2 = in.next();
    System.out.println(checkInclusion(s1, s2));
    in.close();
  }

  public static boolean checkInclusion(String s1, String s2) {
    int[] counter1 = new int[26];
    int[] counter2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      counter1[s1.charAt(i) - 'a']++;
      counter2[s2.charAt(i) - 'a']++;
    }

    if (compareCounters(counter1, counter2)) {
      return true;
    }

    for (int i = s1.length(), j = 0; i < s2.length(); i++, j++) {
      printCounters(counter1, counter2);
      if (compareCounters(counter1, counter2)) {
        return true;
      }
      counter2[s2.charAt(j) - 'a']--;
      counter2[s2.charAt(i) - 'a']++;
    }

    return compareCounters(counter1, counter2);
  }

  private static boolean compareCounters(int[] c1, int[] c2) {
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] != c2[i]) {
        return false;
      }
    }

    return true;
  }

  private static void printCounters(int[] c1, int[] c2) {
    for (int i = 0; i < 26; i++) {
      System.out.print(c1[i] + " ");
    }

    System.out.println();

    for (int i = 0; i < 26; i++) {
      System.out.print(c2[i] + " ");
    }
    System.out.println("\n");
  }
}
