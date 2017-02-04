/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/strange-code
 * 
 * @author Sudharsanan Muralidharan
 */
public class StrangeCode {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long t = in.nextLong();
    long sum = 0, result = 0;
    int i = 0;

    while (true) {
      sum += 3 * (Math.pow(2, i));
      if(sum > t) {
        break;
      }
      result = sum;
      i++;
    }
    
    System.out.println((((sum - result) - (t - result)) % (sum-result)) + 1);
    in.close();
  }
}
