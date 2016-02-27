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

	private boolean isPalindromePermutationMap(String input) {
		Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
		char[] characters = input.toCharArray();

		for (char ch : characters) {
			if (ch != ' ') {
				if (characterMap.containsKey(ch)) {
					int count = characterMap.get(ch);
					characterMap.put(ch, (count == 1) ? 0 : 1);
				} else {
					characterMap.put(ch, 1);
				}
			}
		}

		int sum = 0;
		for (Character key : characterMap.keySet()) {
			sum += characterMap.get(key).intValue();
		}

		return sum <= 1;
	}

	private boolean isPalindromePermutationArr(String input) {
		int[] counter = new int[26];
		char[] characters = input.toCharArray();
		int sum = 0;

		for (char ch : characters) {
			if (ch != ' ') {
				int val = counter[ch - 'a'];
				counter[ch - 'a'] = (val == 1) ? 0 : 1;
			}
		}

		for (int i = 0; i < counter.length; i++) {
			sum += counter[i];
		}
		return sum <= 1;
	}

	private boolean isPalindromePermutationBit(String input) {
		int checker = 0;
		char[] characters = input.toCharArray();

		for (char ch : characters) {
			int diff = ch - 'a';
			int shift = (1 << diff);

			if ((checker & shift) == (int) Math.pow(2.0, diff)) {
				int val = Integer.MAX_VALUE - (int) Math.pow(2.0, diff);
				checker &= val;
			} else {
				checker |= shift;
			}
		}

		int count = 0;

		while (checker > 0) {
			checker &= checker - 1;
			count++;
		}

		return count <= 1;
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
