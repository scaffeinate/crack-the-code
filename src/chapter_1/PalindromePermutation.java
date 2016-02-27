package chapter_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Question 1.4: Given a string, write a function to check if it is a
 * permutation of a palindrome. A palindrome is a word or phrase that is the
 * same forwards and backwards. A permutation is a rearrangement of letters. The
 * palindrome does not need to be limited to just dictionary words.
 * 
 * EXAMPLE Input: Tact Coa, Output: True (permutations: "taco cat", "atco cta",
 * etc.)
 * 
 * @author Sudharsanan Muralidharan
 */
public class PalindromePermutation {

	/**
	 * Check if a palindrome exists in the permutation of words. Using a HashMap
	 * to check if there is a corresponding character for each to satisfy the
	 * palindrome condition with an exception in case of odd length palindrome.
	 * Odd length palindrome will have 1 middle character. Time Complexity: O(n),
	 * Additional Space: O(n)
	 * 
	 * @param input
	 * @return isPalindromePermutation
	 */
	private boolean isPalindromePermutationMap(String input) {
		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
		char[] characters = input.toCharArray();
		int sum = 0;

		for (char ch : characters) {
			if (ch != ' ') {
				// Toggle the value for each character
				if (characterMap.containsKey(ch)) {
					int count = characterMap.get(ch);
					characterMap.put(ch, (count == 1) ? 0 : 1);
				} else {
					characterMap.put(ch, 1);
				}
			}
		}

		for (Character key : characterMap.keySet()) {
			sum += characterMap.get(key).intValue();
		}

		// sum should be either 0 or 1 for it to be a palindrome
		return sum <= 1;
	}

	/**
	 * Check if a palindrome exists in the permutation of words. Using an array of
	 * length 26 for each character to satisfy palindrome condition. Complexity:
	 * O(n), Space: O(1) [26 characters fixed]. Works for all alphabets.
	 * 
	 * @param input
	 * @return isPalindromePermutation
	 */
	private boolean isPalindromePermutationArr(String input) {
		int[] counter = new int[26];
		char[] characters = input.toCharArray();
		int sum = 0;

		for (char ch : characters) {
			if (ch != ' ') {
				// Toggle values in the array between 0 and 1 for each character
				int val = counter[ch - 'a'];
				counter[ch - 'a'] = (val == 1) ? 0 : 1;
			}
		}

		for (int i = 0; i < counter.length; i++) {
			sum += counter[i];
		}

		// sum should be either 0 or 1 for it to be a palindrome
		return sum <= 1;
	}

	/**
	 * Check if a palindrome exists in the permutation of words. Using an integer
	 * value and using bit manipulation instead of an array. Complexity: O(n),
	 * Space: O(1)
	 * 
	 * @param input
	 * @return isPalindromePermutation
	 */
	private boolean isPalindromePermutationBit(String input) {
		int checker = 0;
		char[] characters = input.toCharArray();

		for (char ch : characters) {
			int diff = ch - 'a';
			int shift = (1 << diff); // set 1 to the diff bit

			// if bit is already set to 1 at the position it can't be 0
			if ((checker & shift) != 0) {
				// toggle that bit
				int val = Integer.MAX_VALUE - (int) Math.pow(2.0, diff);
				// use & to toggle the bit
				checker &= val;
			} else {
				checker |= shift;
			}
		}

		// checker should have one or zero bits set to 1
		return (checker & (checker - 1)) == 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PalindromePermutation palindromePermutation = new PalindromePermutation();
		String input = scanner.nextLine().toLowerCase();

		if (input != null && !input.isEmpty()) {
			System.out.println(palindromePermutation.isPalindromePermutationMap(input));
			System.out.println(palindromePermutation.isPalindromePermutationArr(input));
			System.out.println(palindromePermutation.isPalindromePermutationBit(input));
		}

		scanner.close();
	}
}
