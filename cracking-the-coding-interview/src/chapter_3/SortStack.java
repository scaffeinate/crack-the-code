package chapter_3;

import java.io.FileNotFoundException;

import datastructures.stack.CustomStack;
import util.InputUtil;

/**
 * 
 * Question 3.5: Write a program to sort a stack such that the smallest items
 * are on the top. You can use an additional temporary stack, but you may not
 * copy the elements into any other data structure(such as an array). The stack
 * supports the following operations: push, pop, peek and isEmpty.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class SortStack {

  /**
   * Use a temporary stack as buffer to swap elements. Simple selection sort
   * algorithm.
   * 
   * @param stack
   * @return sortedStack
   */
  private CustomStack<Integer> sort(CustomStack<Integer> stack) {
    CustomStack<Integer> compareStack = new CustomStack<Integer>();

    while (!stack.isEmpty()) {
      if (compareStack.isEmpty()) {
        // If the compareStack is empty then pop from stack and add
        compareStack.push(stack.pop());
      } else {
        Integer stackData = stack.pop();
        Integer compareData = compareStack.peek();

        /*
         * Compare stack top (pop) vs compareStack top (peek). If stack top is lesser then
         * push to compareStack. Otherwise find an appropriate position for popped item stackData in
         * compareStack and until then pop items of compareStack and to stack.
         */
        if (stackData < compareData) {
          compareStack.push(stackData);
        } else {
          while (!compareStack.isEmpty() && stackData > compareData) {
            stack.push(compareStack.pop());
          }
          compareStack.push(stackData);
        }
      }
    }

    return compareStack;
  }

  public static void main(String[] args) throws FileNotFoundException {
    SortStack sortStack = new SortStack();
    String[] input = InputUtil.readContents(3, "sort_stack");
    CustomStack<Integer> stack = null;
    for (String line : input) {
      stack = new CustomStack<Integer>();
      String[] elements = line.split(" ");
      for (String element : elements) {
        stack.push(Integer.parseInt(element));
      }

      System.out.println("Original stack is: " + stack.toString());
      CustomStack<Integer> resultStack = sortStack.sort(stack);
      System.out.println("After sorting: " + resultStack.toString() + " with top = " + resultStack.peek());
      System.out.println();
    }
  }
}
