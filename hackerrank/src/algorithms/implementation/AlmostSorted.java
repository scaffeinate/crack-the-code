/**
 * 
 */
package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/almost-sorted
 * 
 * @author Sudharsanan Muralidharan
 */
public class AlmostSorted {

  static class Sequence {
    int start;
    int end;
  }

  private static String checkForSwapOrReverse(int[] arr) {
    int numDecreasingSeq = 0;
    List<Sequence> decreasingSequences = new ArrayList<Sequence>();
    int i = 0;
    Sequence sequence = null;

    while (i < arr.length - 1) {
      if (arr[i] > arr[i + 1]) {
        sequence = new Sequence();
        sequence.start = i;
        while (i < (arr.length - 1) && (arr[i] > arr[i + 1])) {
          i++;
        }
        sequence.end = i;
        decreasingSequences.add(sequence);
      }
      i++;
    }

    numDecreasingSeq = decreasingSequences.size();

    if (numDecreasingSeq == 0) {
      return "";
    } else if (numDecreasingSeq == 1) {
      Sequence seq = decreasingSequences.get(0);
      if ((seq.end - seq.start) < 2) {
        int x = seq.start;
        if (checkValid(arr, x, x + 1)) {
          return "swap " + (x + 1) + " " + (x + 2);
        }
      } else {
        int x = seq.start;
        int y = seq.end;
        if (checkValid(arr, x, y)) {
          return "reverse " + (x + 1) + " " + (y + 1);
        }
      }
    } else if (numDecreasingSeq == 2) {
      int x = decreasingSequences.get(0).start;
      int y = decreasingSequences.get(1).end;

      if (checkValid(arr, x, y)) {
        return "swap " + (x + 1) + " " + (y + 1);
      }
    }

    return null;
  }

  private static boolean checkValid(int[] arr, int x, int y) {
    boolean left = (arr[x] >= arr[y - 1]);
    if (y < arr.length - 1) {
      left = left && (arr[x] <= arr[y + 1]);
    }

    boolean right = (arr[y] <= arr[x + 1]);
    if (x >= 1) {
      right = right && (arr[y] >= arr[x - 1]);
    }

    return left && right;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }

    String action = checkForSwapOrReverse(arr);

    if (action == null) {
      System.out.println("no");
    } else {
      System.out.println("yes");
      if (!action.isEmpty()) {
        System.out.println(action);
      }
    }

    in.close();
  }
}
