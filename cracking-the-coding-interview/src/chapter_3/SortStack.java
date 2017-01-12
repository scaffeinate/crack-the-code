package chapter_3;

import java.io.FileNotFoundException;

import datastructures.stack.CustomStack;
import util.InputUtil;

public class SortStack {

  private CustomStack<Integer> sort(CustomStack<Integer> stack) {
    CustomStack<Integer> compareStack = new CustomStack<Integer>();

    while (!stack.isEmpty()) {
      if (compareStack.isEmpty()) {
        compareStack.push(stack.pop());
      } else {
        Integer stackData = stack.pop();
        Integer compareData = compareStack.peek();

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
      for(String element : elements) {
        stack.push(Integer.parseInt(element));
      }

      System.out.println("Original stack is: " + stack.toString());
      CustomStack<Integer> resultStack = sortStack.sort(stack);
      System.out.println("After sorting: " + resultStack.toString() + " with top = " + resultStack.peek());
      System.out.println();
    }
  }
}
