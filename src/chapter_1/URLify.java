package chapter_1;

import java.util.Scanner;

/**
 * Question 1.3: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end of the string
 * to hold the additional characters, and that you are given the "true" length
 * of the string. (Note: if implementing in Java, please use a character array
 * so that you can perform this operation in place.)
 *
 * This implementation works even without adding spaces at the end.
 *
 * EXAMPLE
 *
 * Input: "Mr John Smith" Output: "Mr%20John%20Smith"
 *
 * @author Sudharsanan Muralidharan
 */
public class URLify {

  /**
   * Returns the number of spaces in a string
   *
   * @param input
   * @param len
   * @return spaces
   */
  private int countSpaces(String input, int len) {
    int spaces = 0;

    for (int i = 0; i < len; i++) {
      if (input.charAt(i) == ' ') {
        spaces++;
      }
    }

    return spaces;
  }

  /**
   * Copy the input string to a character array of size to accommodate %20 for
   * each space
   *
   * @param input
   * @param len
   * @return charArr
   */
  private char[] copyString(String input, int len) {

    int spaces = countSpaces(input, len);
    char[] inputArr = new char[len + (spaces * 2)];

    for (int i = 0; i < input.length(); i++) {
      inputArr[i] = input.charAt(i);
    }

    return inputArr;
  }

  /**
   * Given the character array and actual length without spaces construct the
   * URL version of the string
   *
   * @param inputArr
   * @param actualLen
   * @return url
   */
  private String getURL(char[] inputArr, int actualLen) {
    int len = inputArr.length;

    for (int i = actualLen - 1, j = len - 1; i >= 0; i--, j--) {
      if (inputArr[i] != ' ') {
        inputArr[j] = inputArr[i];
      } else {
        inputArr[j] = '0';
        inputArr[--j] = '2';
        inputArr[--j] = '%';
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < inputArr.length; i++) {
      builder.append(String.valueOf(inputArr[i]));
    }

    return builder.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    URLify urlify = new URLify();

    String input = scanner.nextLine();
    if (input != null && !input.isEmpty()) {
      int len = input.length();
      System.out.println(urlify.getURL(urlify.copyString(input, len), len));
    }

    scanner.close();
  }
}
