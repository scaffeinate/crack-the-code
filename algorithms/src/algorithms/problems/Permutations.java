/**
 * 
 */
package algorithms.problems;

import java.io.FileNotFoundException;

import algorithms.util.InputUtil;

/**
 * Problem:
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a
 * -given-string/
 * 
 * @author Sudharsanan Muralidharan
 */
public class Permutations {

  private void generatePermuations(char[] arr) {
    printPermuatations(arr, 0);
  }

  private void printPermuatations(char[] arr, int start) {
    if (start == arr.length - 1) {
      print(arr);
      return;
    }

    for (int i = start; i < arr.length; i++) {
      char[] newArr = swap(arr, i, start);
      printPermuatations(newArr, start + 1);
    }
  }

  private char[] swap(char[] arr, int i, int j) {
    char[] newArr = arr.clone();
    if (i == j) {
      return newArr;
    }
    newArr[i] = (char) (newArr[i] + newArr[j]);
    newArr[j] = (char) (newArr[i] - newArr[j]);
    newArr[i] = (char) (newArr[i] - newArr[j]);
    return newArr;
  }

  private void print(char[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents("permutations");
    Permutations permutations = new Permutations();
    for (String line : input) {
      permutations.generatePermuations(line.toCharArray());
    }
  }
}
