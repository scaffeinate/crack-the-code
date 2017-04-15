package array;

import java.util.Arrays;

public class NobleIntegersInArray {

  public int nobleInteger(int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if ((arr.length - 1 - i) == arr[i]) {
        return arr[i];
      }
    }
    
    return -1;
  }
}
