package chapter_1;

import java.util.Scanner;

/**
 * Question 1.5: There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check of they are one edit(or zero
 * edits) away.
 * 
 * EXAMPLE pale, ple -> true pales, pale -> true pale, bale -> true pale, bake
 * -> false
 * 
 * @author Sudharsanan Muralidharan
 */
public class OneAway {

	private boolean isOneInsertOrDeleteAway(String input1, String input2, int len1, int len2) {
		int i = 0, j = 0, changes = 0;

		while (j < len2) {
			if (changes > 1) {
				return false;
			} else {
				if (input1.charAt(i) == input2.charAt(j)) {
					j++;
				} else {
					changes++;
				}
			}
			i++;
		}

		if (input1.charAt(len1 - 1) != input2.charAt(len2 - 1)) {
			changes++;
		}

		return changes <= 1;
	}

	private boolean isOneEditAway(String input1, String input2, int len) {
		int i = 0, changes = 0;
		while (i < len) {
			if (changes > 1) {
				return false;
			}
			if (input1.charAt(i) != input2.charAt(i)) {
				changes++;
			}
			i++;
		}

		return true;
	}

	private boolean checkOneAway(String input1, String input2) {
		int len1 = input1.length();
		int len2 = input2.length();

		if (len1 == len2) {
			return isOneEditAway(input1, input2, len1);
		} else {
			if (len1 == len2 + 1) {
				return isOneInsertOrDeleteAway(input1, input2, len1, len2);
			} else if (len2 == len1 + 1) {
				return isOneInsertOrDeleteAway(input2, input1, len2, len1);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		OneAway oneAway = new OneAway();

		String input1 = scanner.nextLine();
		String input2 = scanner.nextLine();

		if (input1 != null && input2 != null) {
			System.out.println(oneAway.checkOneAway(input1, input2));
		}

		scanner.close();
	}
}
