package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/bon-appetit
 * 
 * @author Sudharsanan Muralidharan
 */
public class BonAppetit {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int sum = 0;
    
    for (int i = 0; i < n; i++) {
      int item = in.nextInt();
      if(i != k) {
        sum += item;
      }
    }

    int c = in.nextInt();
    if(c == (sum/2)) {
      System.out.println("Bon Appetit");
    } else {
      System.out.println(c - (sum/2));
    }
    in.close();
  }
}
