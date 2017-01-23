package algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 * 
 * Input Format: A single line of five space-separated integers.
 * 
 * Constraints: Each integer is in the inclusive range . Output Format
 * 
 * Print two space-separated long integers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * integers. (The output can be greater than 32 bit integer.)
 * 
 * Sample Input 1 2 3 4 5
 * 
 * Sample Output 10 14
 * 
 * @author Sudharsanan Muralidharan
 */
public class MiniMaxSum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Long> numbers = new ArrayList<Long>();
    for (int i = 0; i < 5; i++) {
      numbers.add(in.nextLong());
    }

    long sum = 0, min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    for (Long number : numbers) {
      if(number < min) {
        min = number;
      }
      if(number > max) {
        max = number;
      }
      sum += number;
    }

    System.out.println((sum - max) + " " + (sum - min));
    in.close();
  }
}
