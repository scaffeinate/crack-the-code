/**
 * 
 */
package algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/taum-and-bday
 * 
 * @author Sudharsanan Muralidharan
 */
public class TaumAndBday {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      BigInteger b = BigInteger.valueOf(in.nextInt());
      BigInteger w = BigInteger.valueOf(in.nextInt());
      BigInteger x = BigInteger.valueOf(in.nextInt());
      BigInteger y = BigInteger.valueOf(in.nextInt());
      BigInteger z = BigInteger.valueOf(in.nextInt());
      BigInteger cost = new BigInteger("0");

      if (x.compareTo(y) < 0) {
        cost = cost.add(x.multiply(b));
        cost = cost.add((y.compareTo(x.add(z)) < 0) ? w.multiply(y): (w.multiply(x.add(z))));
      } else {
        cost = cost.add(y.multiply(w));
        cost = cost.add((x.compareTo(y.add(z)) < 0) ? b.multiply(x): (b.multiply(y.add(z))));
      }

      System.out.println(cost);
    }
    in.close();
  }
}
