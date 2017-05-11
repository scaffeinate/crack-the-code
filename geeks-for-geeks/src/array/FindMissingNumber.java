package array;

/**
 * Question: http://www.geeksforgeeks.org/?p=146802
 * 
 * @author Sudharsanan Muralidharan
 */
public class FindMissingNumber {
  public int findNumber(int[] arr, int[] copy) {
    int sum = 0;
    for (int num : arr) {
      sum += num;
    }

    for (int num : copy) {
      sum -= num;
    }

    return sum;
  }
}
