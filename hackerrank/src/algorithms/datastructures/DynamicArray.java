/**
 * 
 */
package algorithms.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/dynamic-array
 * @author Sudharsanan Muralidharan
 */
public class DynamicArray {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int q = in.nextInt();
    int lastAns = 0;
    List<List<Integer>> seqList = new ArrayList<List<Integer>>(n);

    for (int i = 0; i < n; i++) {
      seqList.add(new ArrayList<Integer>());
    }

    while (q-- > 0) {
      int queryType = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();
      int index = ((x ^ lastAns) % n);
      List<Integer> result = seqList.get(index);

      switch (queryType) {
      case 1:
        result.add(y);
        break;
      case 2:
        lastAns = result.get(y % result.size());
        System.out.println(lastAns);
        break;
      }
    }
    in.close();
  }
}
