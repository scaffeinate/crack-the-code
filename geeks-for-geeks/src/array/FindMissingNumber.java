package array;

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
