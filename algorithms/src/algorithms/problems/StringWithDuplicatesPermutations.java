/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithms.util.InputUtil;

/**
 * @author Sudharsanan Muralidharan
 */
public class StringWithDuplicatesPermutations {

  class Character {
    private char c;
    private int count = 0;

    public Character(Character obj) {
      this.c = obj.c;
      this.count = obj.count;
    }

    public Character(char c, int count) {
      this.c = c;
      this.count = count;
    }

    @Override
    public String toString() {
      return this.c + " " + this.count;
    }
  }

  public void generatePermutations(char[] arr) {
    Arrays.sort(arr);
    List<Character> charactersList = new ArrayList<Character>();
    int i = 0, j = 0;
    while (i < arr.length - 1) {
      if (arr[i] != arr[i + 1]) {
        charactersList.add(new Character(arr[i], j + 1));
        j = 0;
      } else {
        j++;
      }
      i++;
    }
    charactersList.add(new Character(arr[i], j + 1));
    permutate(charactersList.toArray(new Character[charactersList.size()]), new StringBuilder());
  }

  private void permutate(Character[] characters, StringBuilder builder) {
    int counterSum = 0;
    for (Character character : characters) {
      if (character.count > 0) {
        character.count--;
        counterSum++;
        builder.append(character.c);
        permutate(characters, builder);
        builder.setLength(builder.length() - 1);
        character.count++;
      }
    }

    if (counterSum == 0) {
      System.out.println(builder.toString());
    }
  }

  private void print(Character[] characters) {
    for (Character character : characters) {
      System.out.print(character + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("permutations");
    StringWithDuplicatesPermutations permuations = new StringWithDuplicatesPermutations();
    for (String line : input) {
      permuations.generatePermutations(line.toCharArray());
    }
  }
}
