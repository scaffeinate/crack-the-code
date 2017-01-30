/**
 * 
 */
package algorithms.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Challenge: https://www.hackerrank.com/challenges/beautiful-triplets/
 * 
 * TODO: Implement this in Constant space
 * 
 * @author Sudharsanan Muralidharan
 */
public class BeautifulTriplets {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int d = in.nextInt();
    int[] arr = new int[n];
    Set<Integer> numbers = new HashSet<Integer>();
    int count = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      numbers.add(arr[i]);
    }

    for (int i = 0; i < n; i++) {
      int sec = arr[i] + d;
      int next = sec + d;
      if(numbers.contains(sec) && numbers.contains(next)) {
        count++;
      }
    }
    
    System.out.println(count);
    in.close();
  }
}
