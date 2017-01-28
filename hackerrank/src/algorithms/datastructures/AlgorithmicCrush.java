/**
 * 
 */
package algorithms.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class AlgorithmicCrush {

  static class ArrayElement {
    Long t;
    Long k;
    Boolean isArrival;

    ArrayElement(Long t, Long k, Boolean isArrival) {
      this.t = t;
      this.k = k;
      this.isArrival = isArrival;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    long m = in.nextLong();

    ArrayElement[] aArr = new ArrayElement[(int) m];
    ArrayElement[] dArr = new ArrayElement[(int) m];

    for (int i = 0; i < m; i++) {
      long a = in.nextInt();
      long b = in.nextInt();
      long k = in.nextInt();

      aArr[i] = new ArrayElement(a, k, true);
      dArr[i] = new ArrayElement(b, k, false);
    }

    Arrays.sort(aArr, new Comparator<ArrayElement>() {
      @Override
      public int compare(ArrayElement e1, ArrayElement e2) {
        return e1.t.compareTo(e2.t);
      }
    });

    Arrays.sort(dArr, new Comparator<ArrayElement>() {
      @Override
      public int compare(ArrayElement e1, ArrayElement e2) {
        return e1.t.compareTo(e2.t);
      }
    });

    int i = 0, j = 0;
    Long count = (long) 0;
    Long max = Long.MIN_VALUE;
    while (i < m && j < m) {
      if (aArr[i].t <= dArr[j].t) {
        count += aArr[i].k;
        i++;
      } else {
        count -= dArr[j].k;
        j++;
      }
      
      if(count > max) {
        max = count;
      }
    }

    System.out.println(max);
    
    in.close();
  }
}
