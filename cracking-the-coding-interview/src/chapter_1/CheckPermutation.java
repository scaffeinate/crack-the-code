package chapter_1;

import java.util.Arrays;

/**
 * Question 1.2: Given two strings, write a method to determine whether one is a
 * permutation of the other.
 *
 * @author Sudharsanan Muralidharan
 */
public class CheckPermutation {

    /**
     * Check if first string is a permutation of the second: Sort the strings and
     * compare each character: Complexity: O(nlogn)
     *
     * @param first
     * @param second
     * @return isPermuatation
     */
    public boolean isPermutationSorted(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        } else {
            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();

            Arrays.sort(firstChars);
            Arrays.sort(secondChars);

            return Arrays.equals(firstChars, secondChars);
        }
    }

    /**
     * Check if first string is a permutation of the second: Use an Array[128] to
     * maintain a counter for each character, decrement while checking the second
     * String. If any value < 0 -> return false: Complexity: O(n), Space: O(1)
     *
     * @param first
     * @param second
     * @return isPermutation
     */
    public boolean isPermutationArray(String first, String second) {
        int[] counter = new int[128];

        if (first.length() != second.length()) {
            return false;
        } else {
            int len = first.length();
            for (int i = 0; i < len; i++) {
                counter[first.charAt(i)]++;
            }

            for (int i = 0; i < len; i++) {
                counter[second.charAt(i)]--;
            }

            for (int i = 0; i < counter.length; i++) {
                if (counter[i] < 0) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if first string is a permutation of the second: Use 2 bit vectors of
     * length 32 to maintain a counter for each character. XOR of the bit vectors
     * value != 0 -> return false:
     * <p>
     * Complexity: O(n), Space: O(1)
     *
     * @param first
     * @param second
     * @return isPermutation
     */
    public boolean isPermutationBitWise(String first, String second) {
        int checker = 0, checker2 = 0;

        if (first.length() != second.length()) {
            return false;
        }

        int len = first.length();
        for (int i = 0; i < len; i++) {
            checker |= (1 << (first.charAt(i) - 'a'));
        }

        for (int i = 0; i < len; i++) {
            checker2 |= (1 << (second.charAt(i) - 'a'));
        }

        return (checker ^ checker2) == 0;
    }
}
