/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/save-the-prisoner
 * 
 * @author Sudharsanan Muralidharan
 */
public class SaveThePrisoner {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int m = in.nextInt();
      int s = in.nextInt();
      
      int offset = (m < n) ? m : (m % n);
      int num = ((s-1) + offset);
      if(num == 0) {
        System.out.println(n);
      } else if(num > n) {
        System.out.println(num % n);
      } else {
        System.out.println(num);
      }
    }
    in.close();
  }
}
