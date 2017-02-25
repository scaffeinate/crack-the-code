/**
 * 
 */
package algorithms.warmup;

import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class CompareTheTriplets {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] a = new int[3];
    int[] b = new int[3];
    int pointsa = 0, pointsb = 0;

    for (int i = 0; i < 3; i++) {
      a[i] = in.nextInt();
    }
    
    for (int i = 0; i < 3; i++) {
      b[i] = in.nextInt();
    }
    
    for (int i = 0; i < 3; i++) {
      if(a[i] > b[i]) {
        pointsa++;
      } else if(b[i] > a[i]) {
        pointsb++;
      }
    }
    System.out.println(pointsa + " " + pointsb);
    in.close();
  }
}
