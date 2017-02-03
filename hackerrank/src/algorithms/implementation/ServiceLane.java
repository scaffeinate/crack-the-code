/**
 * 
 */
package algorithms.implementation;

import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/service-lane
 * 
 * @author Sudharsanan Muralidharan
 */
public class ServiceLane {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int t = in.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    while (t-- > 0) {
      int i = in.nextInt();
      int j = in.nextInt();
      int min = Integer.MAX_VALUE;
      
      while(i <= j) {
        if(arr[i] < min) {
          min = arr[i];
        }
        i++;
      }
      
      System.out.println(min);
    }
    in.close();
  }
}
