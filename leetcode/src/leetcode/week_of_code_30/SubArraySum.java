package leetcode.week_of_code_30;

import java.util.Scanner;

public class SubArraySum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arr = new int[] { 1, 1, 2, 1, -3 };
    int k = in.nextInt();
    System.out.println(subarraySum(arr, k));
    in.close();
  }

  public static int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = 0;
      for (int j = i; j < nums.length; j++) {
        if ((sum = sum + nums[j]) == k)
          count++;
      }
    }
    return count;
  }
}
