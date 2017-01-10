package chapter_3;

import java.io.FileNotFoundException;
import java.util.EmptyStackException;

import chapter_3.stack_queue.CustomStack;
import chapter_3.stack_queue.CustomStackMin;
import util.InputUtil;

/**
 * Question 3.2: How would you design a stack which, in addition push and pop,
 * has a function min which returns the minimum element? Push, pop and min
 * should all operate in O(1) time.
 * 
 * @author Sudharsanan Muralidharan
 */
public class StackMin {

  /**
   * Using a minVariable to track the minimum in the stack. When the minValue is
   * popped from the stack we need to search for the next minimum and update
   * which takes O(n) worst case.
   * 
   * Complexity: O(1), O(n) when min element is removed, Space: O(n)
   * 
   * @param input
   */
  private void stackMin(String[] input) {
    CustomStackMin customStackMin = new CustomStackMin();
    for (String line : input) {
      if (line.startsWith("push")) {
        int val = Integer.parseInt(line.subSequence(line.indexOf('(') + 1, line.indexOf(')')).toString());
        System.out.println("Pusing " + val + " to stack");
        customStackMin.push(val);
      } else if (line.startsWith("pop")) {
        System.out.println("Popped from stack : " + customStackMin.pop());
      } else if (line.startsWith("min")) {
        System.out.println("Minimum is : " + customStackMin.min());
      }
    }
  }

  /**
   * Tracking the minimum at each level so when top is popped we can get the
   * minimum at the next level which is min in stack.
   * 
   * Complexity: O(1), Space: O(n) + O[n] [More than O(n) to store the min
   * variable at each level]
   * 
   * @param input
   */
  private void stackMinUsingWrapper(String[] input) {
    CustomStack<MinNodeWrapper> customStack = new CustomStack<MinNodeWrapper>();
    for (String line : input) {
      if (line.startsWith("push")) {
        int val = Integer.parseInt(line.subSequence(line.indexOf('(') + 1, line.indexOf(')')).toString());
        MinNodeWrapper nodeWrapper = new MinNodeWrapper();
        nodeWrapper.data = val;
        nodeWrapper.min = val;
        try {
          if (customStack.peek().min < val) {
            nodeWrapper.min = customStack.peek().min;
          }
        } catch (EmptyStackException e) {

        }
        System.out.println("Pushing " + val + " to stack");
        customStack.push(nodeWrapper);
      } else if (line.startsWith("pop")) {
        System.out.println("Popped from stack : " + customStack.pop().data);
      } else if (line.startsWith("min")) {
        System.out.println("Minimum is : " + customStack.peek().min);
      }
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "stack_min");
    StackMin stackMin = new StackMin();
    System.out.println("Stack Min using variable");
    stackMin.stackMin(input);
    System.out.println();
    System.out.println("Stack Min Using Wrapper");
    stackMin.stackMinUsingWrapper(input);
  }

  /**
   * MinNode wrapper class
   * @author Sudharsanan Muralidharan
   */
  class MinNodeWrapper {
    int data;
    int min;
  }
}
