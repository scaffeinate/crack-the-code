package string;

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
}
