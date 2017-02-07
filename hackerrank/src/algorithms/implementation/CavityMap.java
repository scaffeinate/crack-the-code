/**
 * 
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/cavity-map
 * 
 * @author Sudharsanan Muralidharan
 */
public class CavityMap {

  private static boolean compare(char c, char c2) {
    return Integer.parseInt(String.valueOf(c)) > Integer.parseInt(String.valueOf(c2));
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    char[] characters = new char[n * n];

    for (int i = 0; i < n; i++) {
      String input = in.next();
      for (int j = 0; j < input.length(); j++) {
        characters[(i * n) + j] = input.charAt(j);
      }
    }

    List<Integer> indexes = new ArrayList<Integer>();

    for (int i = 1; i < characters.length - 1; i++) {
      if (i % n == 0 || ((i + 1) % n) == 0) {
        continue;
      }
      int top = i - n;
      int bottom = i + n;
      boolean greater = false;

      if (top > 0 && bottom < characters.length) {
        greater = compare(characters[i], characters[top]);
        greater = greater && compare(characters[i], characters[bottom]);
        greater = greater && compare(characters[i], characters[i - 1]);
        greater = greater && compare(characters[i], characters[i + 1]);
      }

      if (greater) {
        indexes.add(i);
      }
    }

    for (Integer index : indexes) {
      characters[index] = 'X';
    }

    for (int i = 0; i < characters.length; i++) {
      if (i > 0 && i % n == 0) {
        System.out.println();
      }
      System.out.print(characters[i]);
    }

    in.close();
  }
}
