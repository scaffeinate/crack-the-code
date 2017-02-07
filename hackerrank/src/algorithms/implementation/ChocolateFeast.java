/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/chocolate-feast
 * 
 * @author Sudharsanan Muralidharan
 */
public class ChocolateFeast {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
   
    while (t-- > 0) {
      int n = in.nextInt();
      int c = in.nextInt();
      int m = in.nextInt();

      int chocolates = 0;
      int numBought = (n / c);
      chocolates += numBought;
      
      int wrappers = numBought;
      while (wrappers >= m) {
        numBought = (wrappers / m);
        chocolates += numBought;
        int wrappersLeft = (wrappers % m);
        wrappers = numBought + wrappersLeft;
      }

      System.out.println(chocolates);
    }
    in.close();
  }
}
