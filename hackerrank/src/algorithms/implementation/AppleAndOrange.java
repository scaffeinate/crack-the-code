package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/apple-and-orange
 * 
 * @author Sudharsanan Muralidharan
 */
public class AppleAndOrange {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int t = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();
    int m = in.nextInt();
    int n = in.nextInt();

    int numApples = 0;
    int numOranges = 0;

    for (int i = 0; i < m; i++) {
      int point = a + in.nextInt();
      if(point >= s && point <= t) {
        numApples++;
      }
    }

    for (int i = 0; i < n; i++) {
      int point = b + in.nextInt();
      if(point <= t && point >= s) {
        numOranges++;
      }
    }
    
    System.out.println(numApples);
    System.out.println(numOranges);
    in.close();
  }
}
