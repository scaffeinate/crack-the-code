package array;

/**
 * Question: http://www.geeksforgeeks.org/?p=135094
 * 
 * @author Sudharsanan Muralidharan
 */
public class ElementOccursOnce {
  public static int findElement(int[] arr) {
    for (int i = 0; i < arr.length - 1; i += 2) {
      if (arr[i] != arr[i + 1]) {
        return arr[i];
      }
    }
    return arr[arr.length - 1];
  }

  public static int findElement2(int[] arr) {
    return findElement2(arr, 0, arr.length);
  }

  private static int findElement2(int[] arr, int start, int end) {
    if (start == end) {
      return arr[start];
    }

    int middle = (start + end) / 2;
    if (middle != arr.length - 1 && arr[middle] == arr[middle + 1]) {
      return findElement2(arr, ((middle % 2 != 0) ? start : middle + 1), ((middle % 2 != 0) ? middle : end));
    } else if (middle != 0 && arr[middle] == arr[middle - 1]) {
      return findElement2(arr, ((middle % 2 != 0) ? middle + 1 : start), ((middle % 2 != 0) ? end : middle));
    } else {
      return arr[middle];
    }
  }
}
