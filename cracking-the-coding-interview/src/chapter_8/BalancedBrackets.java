/**
 * 
 */
package chapter_8;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author Sudharsanan Muralidharan
 */
public class BalancedBrackets {

  private static Map<Character, Character> mapping = null;

  public BalancedBrackets() {
    mapping = new HashMap<Character, Character>();
    mapping.put('(', ')');
  }

  public boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty() || (!stack.isEmpty() && c != mapping.getOrDefault(stack.pop(), ' '))) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
