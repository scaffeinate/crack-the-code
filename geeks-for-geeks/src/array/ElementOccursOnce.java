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
}
