package string;

import java.util.Arrays;

/**
 * Question:
 * http://www.geeksforgeeks.org/count-substrings-with-same-first-and-last-characters/
 * 
 * @author Sudharsanan Muralidharan
 */
public class CountSubstringsFirstLastCharacters {

  public int countSubstrings(String s) {
    int[] countArr = new int[26];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      countArr[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < countArr.length; i++) {
      count += ((countArr[i]) * (countArr[i] + 1)) / 2;
    }

    return count;
  }

  public int countSubstrings2(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(i) == s.charAt(j)) {
          count++;
        }
      }
    }
    return count;
  }

  public int countSubstrings3(String s) {
    int count = 0, charCount = 1;
    char[] arr = s.toCharArray();
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] != arr[i + 1]) {
        count += (charCount * (charCount + 1)) / 2;
        charCount = 1;
      } else {
        charCount++;
      }
    }

    count += (charCount * (charCount + 1)) / 2;

    return count;
  }
}
