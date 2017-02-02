/**
 * 
 */
package algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Challenge: https://www.hackerrank.com/challenges/the-time-in-words
 * 
 * @author Sudharsanan Muralidharan
 */
public class TheTimeinWords {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int h = in.nextInt();
    int minutes = in.nextInt();
    int m = 0;

    StringBuilder builder = new StringBuilder();

    Map<Integer, String> numbersMap = new HashMap<Integer, String>();
    numbersMap.put(0, "");
    numbersMap.put(1, "one");
    numbersMap.put(2, "two");
    numbersMap.put(3, "three");
    numbersMap.put(4, "four");
    numbersMap.put(5, "five");
    numbersMap.put(6, "six");
    numbersMap.put(7, "seven");
    numbersMap.put(8, "eight");
    numbersMap.put(9, "nine");
    numbersMap.put(10, "ten");
    numbersMap.put(11, "eleven");
    numbersMap.put(12, "twelve");
    numbersMap.put(13, "thirteen");
    numbersMap.put(14, "fourteen");
    numbersMap.put(15, "fifteen");
    numbersMap.put(20, "twenty");

    if (minutes > 30) {
      m = 60 - minutes;
    } else {
      m = minutes;
    }

    if (m == 0) {
      builder.append(numbersMap.get(h)).append(" o' clock ");
    } else if (m == 1) {
      builder.append(numbersMap.get(m)).append(" minute");
    } else if (m > 1 && m < 15) {
      builder.append(numbersMap.get(m)).append(" minutes");
    } else if (m > 15 && m <= 19) {
      builder.append(numbersMap.get(m % 10)).append("teen").append(" minutes");
    } else if (m > 19 && m <= 29) {
      builder.append(numbersMap.get(20)).append(" " + numbersMap.get(m % 20)).append((m % 20) == 0 ? "" : " ")
          .append("minutes");
    } else if (m == 15) {
      builder.append("quarter");
    } else if (m == 30) {
      builder.append("half");
    }

    if (minutes > 0 && minutes <= 30) {
      builder.append(" past ").append(numbersMap.get(h));
    } else if (minutes > 30) {
      int hour = (h + 1) % 12;
      builder.append(" to ").append(numbersMap.get(hour == 0 ? 12 : hour));
    }

    System.out.println(builder.toString());
    in.close();
  }
}
