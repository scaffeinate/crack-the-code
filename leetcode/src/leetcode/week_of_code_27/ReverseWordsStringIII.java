package leetcode.week_of_code_27;
import java.util.Scanner;

public class ReverseWordsStringIII {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    System.out.println(reverseWords(s));
    in.close();
  }

  private static void reverseWord(String s, int i, StringBuilder builder) {
    if (i == s.length()) {
      return;
    }
    reverseWord(s, i + 1, builder);
    builder.append(s.charAt(i));
  }

  private static String reverseWords(String s) {
    String[] sArr = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (String str : sArr) {
      reverseWord(str, 0, builder);
      builder.append(" ");
    }
    return builder.toString();
  }
}
