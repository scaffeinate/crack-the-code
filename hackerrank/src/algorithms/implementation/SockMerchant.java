package algorithms.implementation;

import java.util.Scanner;

/**
 * 
 * Challenge: https://www.hackerrank.com/challenges/sock-merchant
 * @author Sudharsanan Muralidharan
 */
public class SockMerchant {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] bitArr = new int[101];
    int n = in.nextInt();
    int count = 0;
    
    for (int i = 0; i < n; i++) {
      int cost = in.nextInt();
      if(bitArr[cost] == 0) {
        bitArr[cost] = 1;
      } else {
        count++;
        bitArr[cost] = 0;
      }
    }

    System.out.println(count);
    in.close();
  }
}
