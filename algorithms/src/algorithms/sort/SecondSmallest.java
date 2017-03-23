package algorithms.sort;

import java.util.Scanner;

public class SecondSmallest {
  static int secondSmallest(int[] x) {
    if (x.length < 2) {
      return 0;
    }

    int smallest = Integer.MAX_VALUE, smallest2 = Integer.MAX_VALUE;

    smallest = Math.min(x[0], x[1]);
    smallest2 = Math.max(x[0], x[1]);

    for (int i = 2; i < x.length; i++) {
      if (x[i] < smallest) {
        smallest2 = smallest;
        smallest = x[i];
      } else if (x[i] < smallest2) {
        smallest2 = x[i];
      }
    }

    return smallest2;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(secondSmallest(arr));
    in.close();
  }
}
