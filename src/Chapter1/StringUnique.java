package Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class StringUnique {

	private boolean checkUniqueChars(String word) {

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

	private boolean checkUniqueCharsSorted(String word) {

		char[] characters = word.toCharArray();
		Arrays.sort(characters);

		for (int i = 0; i < characters.length - 1; i++) {
			if (characters[i] == characters[i + 1]) {
				return false;
			}
		}

		return true;
	}

	private boolean checkUniqueCharsArray(String word) {
		int counter[] = new int[256];
		char[] characters = word.toCharArray();

		for (int i = 0; i < characters.length; i++) {
			counter[characters[i]]++;
		}

		for (int i = 0; i < counter.length; i++) {
			if (counter[i] > 1) {
				return false;
			}
		}

		return true;
	}

	private boolean checkUniqueCharsBits(String word) {
		int checker = 0;
		char[] characters = word.toCharArray();

		for (int i = 0; i < characters.length; i++) {
			int val = characters[i] - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}

			checker |= 1 << val;
		}

		return true;
	}

	public static void main(String[] args) {

		StringUnique stringUnique = new StringUnique();
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine().toLowerCase();

		System.out.println(stringUnique.checkUniqueChars(word));
		System.out.println(stringUnique.checkUniqueCharsSorted(word));
		System.out.println(stringUnique.checkUniqueCharsArray(word));
		System.out.println(stringUnique.checkUniqueCharsBits(word));

		scanner.close();
	}
}
