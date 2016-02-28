package chapter_1;

import java.util.Scanner;

/**
 * Question 1.5: There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check of they are one edit(or zero
 * edits) away.
 * 
 * EXAMPLE
 * 
 * pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false
 * 
 * @author Sudharsanan Muralidharan
 */
public class OneAway {

  /**
   * Check if input1 is one insert or delete away from input2
   * 
   * @param input1
   * @param input2
   * @return isOneInsertAway
   */
  private boolean isEditInsert(String input1, String input2) {
    int i = 0, j = 0, changes = 0;

    /*
     * input1 is longer than input2. So loop till input2.length
     */
    while (j < input2.length()) {
      // if number of character changes is greater than 1 then return false
      if (changes > 1) {
        return false;
      } else {
        // if the character at i and j are equal then move to the next
        if (input1.charAt(i) == input2.charAt(j)) {
          j++;
        } else {
          // increase the number of changes for mismatch
          changes++;
        }
      }
      i++;
    }

    // Handle last character change
    if (input1.charAt(input1.length() - 1) != input2.charAt(input2.length() - 1)) {
      changes++;
    }

    return changes <= 1;
  }

  /**
   * Check if input1 is one replace away from input2
   * 
   * @param input1
   * @param input2
   * @return isOneReplaceAway
   */
  private boolean isEditReplace(String input1, String input2) {
    int i = 0, changes = 0;
    while (i < input1.length()) {
      // For mismatch in characters increment changes
      if (input1.charAt(i) != input2.charAt(i)) {
        changes++;

        // if number of changes is more than 1 return false
        if (changes > 1) {
          return false;
        }
      }
      i++;
    }

    return true;
  }

  /**
   * Check if input1 is one insert or delete away from input2. This is the Book
   * solution.
   * 
   * @param input1
   * @param input2
   * @return isOneInsertAway
   */
  private boolean isEditInsert2(String input1, String input2) {
    int i = 0, j = 0;

    /*
     * loop till the end of the shorter string
     */
    while (i < input1.length() && j < input2.length()) {
      // if there is a mismatch in characters check for the indexes. if i != j
      // then character has been inserted or deleted at the position
      if (input1.charAt(i) != input2.charAt(j)) {
        if (i != j) {
          return false;
        }
      } else {
        j++;
      }
      i++;
    }
    return true;
  }

  /**
   * Check if input1 is one replace away from input2
   * 
   * @param input1
   * @param input2
   * @return isOneReplaceAway
   */
  private boolean isEditReplace2(String input1, String input2) {
    int i = 0;
    boolean isChanged = false;

    while (i < input1.length()) {
      // set a flag when character mismatch happens. if edits are greater than 1
      // then the flag is checked and return is false.
      if (input1.charAt(i) != input2.charAt(i)) {
        if (isChanged) {
          return false;
        }
        isChanged = true;
      }

      i++;
    }

    return true;
  }

  /**
   * Check if input1 is one edit away from input2. Complexity: O(n-1) where n is
   * the length of longer input. Since the strings length should be one away we
   * check n-1 times.
   * 
   * @param input1
   * @param input2
   * @return isOneAway
   */
  private boolean checkOneAway(String input1, String input2) {
    int len1 = input1.length();
    int len2 = input2.length();

    /*
     * For equal length strings check for edit. Otherwise check for insert or
     * delete
     */
    if (len1 == len2) {
      return isEditReplace(input1, input2);
    } else {
      /*
       * Suppose input1 can be obtained by adding one character to input2 check
       * for insert. If input2 can be obtained by removing one character from
       * input1 check for delete. Since these are similar we can swap the inputs
       * based on the conditions.
       */
      if (len1 == len2 + 1) {
        return isEditInsert(input1, input2);
      } else if (len2 == len1 + 1) {
        return isEditInsert(input2, input1);
      }
    }

    return false;
  }

  /**
   * Check if input1 is one edit away from input2. Complexity: O(n-1) where n is
   * the length of longer input. Since the strings length should be one away we
   * check n-1 times. This is the Book solution.
   * 
   * @param input1
   * @param input2
   * @return isOneAway
   */
  private boolean checkOneAway2(String input1, String input2) {
    int len1 = input1.length();
    int len2 = input2.length();

    /*
     * For equal length strings check for edit. Otherwise check for insert or
     * delete. Suppose input1 can be obtained by adding one character to input2
     * check for insert. If input2 can be obtained by removing one character
     * from input1 check for delete. Since these are similar we can swap the
     * inputs based on the conditions.
     */
    if (len1 == len2) {
      return isEditReplace2(input1, input2);
    } else if (len1 + 1 == len2) {
      return isEditInsert2(input2, input1);
    } else if (len1 - 1 == len2) {
      return isEditInsert2(input1, input2);
    }

    return false;
  }

  /**
   * Check if input1 is one edit away from input2. Complexity: O(n-1) where n is
   * the length of longer input. Since the strings length should be one away we
   * check n-1 times. Combined method as given in the Book.
   * 
   * @param input1
   * @param input2
   * @return isOneAway
   */
  private boolean checkOneAway3(String input1, String input2) {
    int i = 0, j = 0;
    boolean isChanged = false;

    // check for the condition if the strings are one or zero edits away
    if (Math.abs(input1.length() - input2.length()) > 1) {
      return false;
    }

    // get the longer and shorter strings
    String longer = (input1.length() > input2.length()) ? input1 : input2;
    String shorter = (input1.length() > input2.length()) ? input2 : input1;

    while (i < longer.length() && j < shorter.length()) {
      // if isChanged is already set then there was a mismatch already
      if (longer.charAt(i) != shorter.charAt(j)) {
        if (isChanged) {
          return false;
        }
        isChanged = true;

        // for insert and delete the lengths are different. so increment the
        // shorter string length by 1
        if (longer.length() == shorter.length()) {
          j++;
        }

      } else {
        j++;
      }
      i++;
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    OneAway oneAway = new OneAway();

    String input1 = scanner.nextLine();
    String input2 = scanner.nextLine();

    if (input1 != null && input2 != null) {
      System.out.println(oneAway.checkOneAway(input1, input2));
      System.out.println(oneAway.checkOneAway2(input1, input2));
      System.out.println(oneAway.checkOneAway3(input1, input2));
    }

    scanner.close();
  }
}
