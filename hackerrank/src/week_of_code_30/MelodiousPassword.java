package week_of_code_30;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MelodiousPassword {

  private char[] consonants = null;
  private char[] vowels = null;
  private BufferedWriter log = null;

  public MelodiousPassword() {
    log = new BufferedWriter(new OutputStreamWriter(System.out));
    consonants = new char[] { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
        'x', 'z' };
    vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };
  }

  private void generate(int n) throws IOException {
    generate(0, n, new StringBuilder(), true);
    generate(0, n, new StringBuilder(), false);
    log.flush();
  }

  private void generate(int index, int n, StringBuilder builder, boolean isVowel) throws IOException {
    if (index == n) {
      log.append(builder.toString()).append("\n");
      return;
    }

    if (isVowel) {
      for (int i = 0; i < vowels.length; i++) {
        builder.append(vowels[i]);
        generate(index + 1, n, builder, !isVowel);
        builder.setLength(builder.length() - 1);
      }
    } else {
      for (int i = 0; i < consonants.length; i++) {
        builder.append(consonants[i]);
        generate(index + 1, n, builder, !isVowel);
        builder.setLength(builder.length() - 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    MelodiousPassword melodiousPassword = new MelodiousPassword();
    melodiousPassword.generate(n);
    in.close();
  }
}
