package chapter_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Question 1.1 : Implement an algorithm to determine if a string has all unique
 * characters What if you can not use additional data structures?
 *
 * @author Sudharsanan Muralidharan
 */
public class StringUnique {

    /**
     * Check if characters are unique: Compare each character with one another:
     * Complexity O(n2)
     *
     * @param word
     * @return isUniqueChars
     */
    public boolean checkUniqueChars(String word) {
        char[] characters = word.toCharArray();

        for (int i = 0; i < characters.length - 1; i++) {
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if characters are unique: Sort the characters using Arrays.sort()
     * then compare successive characters: Complexity O(nlogn)
     *
     * @param word
     * @return isUniqueChars
     */
    public boolean checkUniqueCharsSorted(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);

        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if characters are unique: Use a counter for each character and
     * increment If at least 1 counter element > 1 then return false: Complexity:
     * O(n), Space: O(1)
     *
     * @param word
     * @return isUniqueChars
     */
    public boolean checkUniqueCharsArray(String word) {
        int counter[] = new int[128];
        char[] characters = word.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            counter[characters[i] - 1]++;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if characters are unique: Using a bit vector of length 32 instead of
     * using a counter array. Manipulate the bits for each character. If bit is
     * set to 1 already then character is already present -> return false Only
     * works for characters a to z, Complexity: O(n), Space: O(1)
     *
     * @param word
     * @return isUniqueChars
     */
    public boolean checkUniqueCharsBits(String word) {
        int checker = 0;
        char[] characters = word.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            int val = characters[i] - 'a';

      /*
       * Set the bit at character[i]+1 to 1. Perform bitwise & with checker
       * value If value is greater than 0 then it is already set -> return false
       */
            if ((checker & (1 << val)) > 0) {
                return false;
            }

      /*
       * Do bitwise OR with already existing checker value
       */
            checker |= 1 << val;
        }

        return true;
    }

    /**
     * Check if characters are unique: Add characters to Hash Set and check if it
     * exists in Set
     * <p>
     * Complexity: O(n), Extra Space: O(n)
     *
     * @param word
     * @return isUniqueChars
     */
    public boolean checkUniqueCharsSet(String word) {
        Set<Character> characterSet = new HashSet<Character>();
        char[] characters = word.toCharArray();

        for (char c : characters) {
            if (characterSet.contains(c)) {
                return false;
            }
            characterSet.add(c);
        }

        return true;
    }
}
