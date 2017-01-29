/**
 * 
 */
package algorithms.implementation;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Sudharsanan Muralidharan
 */
public class ACMICPCTeam {

  private static BigInteger bitwiseOR(String topic, String topic2) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < topic.length(); i++) {
      char c1 = topic.charAt(i);
      char c2 = topic2.charAt(i);

      builder.append(c1 == '1' || c2 == '1' ? "1" : "0");
    }

    return new BigInteger(builder.toString(), 2);
  }

  public static <T> void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    String topic[] = new String[n];
    Queue<BigInteger> results = new PriorityQueue<BigInteger>(new Comparator<BigInteger>() {
      @Override
      public int compare(BigInteger o1, BigInteger o2) {
        return ((Integer) o2.bitCount()).compareTo((Integer) o1.bitCount());
      }
    });
    for (int i = 0; i < n; i++) {
      topic[i] = in.next();
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        results.add(bitwiseOR(topic[i], topic[j]));
      }
    }

    BigInteger max = results.poll();
    System.out.println(max.bitCount());
    int count = 1;

    for (int i = 0; i < results.size(); i++) {
      BigInteger e = results.poll();
      if (e.bitCount() == max.bitCount()) {
        count++;
      }
    }

    System.out.println(count);

    in.close();
  }
}
