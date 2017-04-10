package leetcode.week_of_code_27;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NextGreaterElement {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(nextGreaterElement(n));
    in.close();
  }

  public static int nextGreaterElement(int n) {
    int result = -1, nextLargestDigit = Integer.MAX_VALUE, index = 0;

    LinkedList<Integer> digits = new LinkedList<Integer>();
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> resultList = new ArrayList<Integer>();
    StringBuilder bulder = new StringBuilder();

    while (n > 0) {
      int digit = n % 10;
      digits.addFirst(digit);
      n = n / 10;
    }

    list = digits.subList(1, digits.size());
    Collections.sort(list);
    resultList.add(digits.get(0));
    resultList.addAll(list);

    if (resultList.get(0) < resultList.get(1)) {
      int temp = resultList.get(0);
      resultList.set(0, resultList.get(1));
      resultList.set(1, temp);

      for (int i = 0; i < resultList.size(); i++) {
        bulder.append(resultList.get(i));
      }

      return Integer.parseInt(bulder.toString());
    } else {
      return -1;
    }
  }
}
