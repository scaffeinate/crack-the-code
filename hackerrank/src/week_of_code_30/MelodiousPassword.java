package week_of_code_30;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MelodiousPassword {

  private static char[] consonants = new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r',
      's', 't', 'v', 'w', 'x', 'z' };
  private static char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };

  private static void generate(int n) {
    List<String> results = new ArrayList<String>();
    if (n == 1 || (n % 2 == 0)) {
      generate(0, n, new StringBuilder(), true, results);
      generate(0, n, new StringBuilder(), false, results);
    } else {
      generate(0, n, new StringBuilder(), false, results);
    }
  }

  private static void generate(int index, int n, StringBuilder builder, boolean isVowel, List<String> results) {
    if (index == n) {
      System.out.println(builder.toString());
      return;
    }

    if (isVowel) {
      for (int i = 0; i < vowels.length; i++) {
        builder.append(vowels[i]);
        generate(index + 1, n, builder, !isVowel, results);
        builder.setLength(builder.length() - 1);
      }
    } else {
      for (int i = 0; i < consonants.length; i++) {
        builder.append(consonants[i]);
        generate(index + 1, n, builder, !isVowel, results);
        builder.setLength(builder.length() - 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    generate(n);
    in.close();
  }
}
