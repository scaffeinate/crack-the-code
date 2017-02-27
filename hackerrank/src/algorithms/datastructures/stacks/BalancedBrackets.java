/**
 * 
 */
package algorithms.datastructures.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Challenge: https://www.hackerrank.com/challenges/balanced-brackets
 * 
 * @author Sudharsanan Muralidharan
 */
public class BalancedBrackets {

  private static Map<Character, Character> mapping = null;

  public BalancedBrackets() {
    mapping = new HashMap<Character, Character>();
    mapping.put('(', ')');
    mapping.put('[', ']');
    mapping.put('{', '}');
  }

  private boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty() || (!stack.isEmpty() && c != mapping.getOrDefault(stack.pop(), ' '))) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BalancedBrackets balancedBrackets = new BalancedBrackets();
    int n = in.nextInt();
    while (n-- > 0) {
      System.out.println(balancedBrackets.isBalanced(in.next()) ? "YES" : "NO");
    }
    in.close();
  }
}
