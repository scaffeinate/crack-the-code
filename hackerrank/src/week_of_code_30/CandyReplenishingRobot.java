package week_of_code_30;

import java.util.Scanner;

public class CandyReplenishingRobot {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int originalN = n;
    int t = in.nextInt();
    int count = 0;

    while (t-- > 1) {
      int b = in.nextInt();
      n -= b;
      if (n < 5) {
        count += (originalN - n);
        n = originalN;
      }
    }
    
    System.out.println(count);
    in.close();
  }
}
