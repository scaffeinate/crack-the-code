package algorithms.implementation;

import java.util.Scanner;

/**
 * 
 * Challenge: https://www.hackerrank.com/challenges/divisible-sum-pairs
 * 
 * @author Sudharsanan Muralidharan
 */
public class DivisibleSumPairs {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int arr[] = new int[n];
    int[] modArr = new int[k];

    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
      int mod = arr[i] % k;
      modArr[mod]++;
    }
    
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      int mod = arr[i] % k;
      int diff = (mod == 0) ? mod : (k - mod);
      sum += (diff == mod) ? (modArr[diff] - 1) : modArr[diff];
      modArr[mod]--;
    }

    System.out.println(sum);
    in.close();
  }
}
