package chapter_1;

import java.io.FileNotFoundException;

import util.InputUtil;

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
   * Append Spaces at the end to accommodate the replaced characters 
   *
   * @param input
   * @param len
   * @return charArr
   */
  private char[] appendSpace(String input) {
    int len = input.length();
    int spaces = countSpaces(input, len);
    char[] inputArr = new char[len + (spaces * 2)];
    System.arraycopy(input.toCharArray(), 0, inputArr, 0, len);
    return inputArr;
  }
  
  /**
   * Prepend Spaces at the end to accommodate the replaced characters
   * 
   * @param input
   * @return
   */
  private char[] prependSpace(String input) {
    int len = input.length();
    int spaces = countSpaces(input, len);
    char[] inputArr = new char[len + (spaces * 2)];
    System.arraycopy(input.toCharArray(), 0, inputArr, (spaces * 2), len);   
    return inputArr;
  }

  /**
   * Given the character array and actual length without spaces construct the
   * URL version of the string bottom up approach
   *
   * Complexity: O(n), Extra Space: O(1)
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
  
  /**
   * Given the character array and actual length without spaces construct the
   * URL version of the string
   * 
   * Complexity: O(n), Extra Space: O(1)
   * @param inputArr
   * @param actualLen
   * @return url
   */
  private String getURLForward(char[] inputArr, int actualLen) {
    StringBuilder builder = new StringBuilder();
    
    for(int i = (inputArr.length - actualLen), j = 0; i < inputArr.length; i++, j++) {
      if(inputArr[i] == ' ') {
        inputArr[j] = '%';
        inputArr[++j] = '2';
        inputArr[++j] = '0';
      } else {
        inputArr[j] = inputArr[i];
      }
    }
    
    for(char c:inputArr) {
      builder.append(c);
    }
    
    return builder.toString();
  }

  public static void main(String[] args) throws FileNotFoundException {

    URLify urlify = new URLify();
    String[] input = InputUtil.readContents(1, "urlify");

    for (String line : input) {
      int originalLen = line.length();
      System.out.println("Input: " + line);
      System.out.println("URL: " + urlify.getURL(urlify.appendSpace(line), originalLen));
      System.out.println("URL: " + urlify.getURLForward(urlify.prependSpace(line), originalLen));
      System.out.println();
    }
  }
}
