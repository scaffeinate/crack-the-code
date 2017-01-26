package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.SetOfStacks;
import datastructures.stack.GenericStack;
import util.InputUtil;

/**
 * Question 3.3: Imagine a (literal) stack of plates. If the stack gets too high
 * it might topple. Therefore in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several
 * stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identical to a single
 * stack.
 * 
 * @author Sudharsanan Muralidharan
 */
public class SetOfPlates {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "set_of_plates");
    int threshold = Integer.parseInt(input[0]);
    GenericStack<Integer> setOfStacks = new SetOfStacks<Integer>(threshold);
    for (String line : input) {
      if (line.startsWith("push")) {
        int data = Integer.parseInt(InputUtil.getArg(line));
        System.out.println("Pushing to stack : " + data);
        setOfStacks.push(data);
      } else if (line.startsWith("pop()")) {
        System.out.println("Popping from stack : " + setOfStacks.pop());
      } else if (line.startsWith("peek")) {
        System.out.println("Top: " + setOfStacks.peek());
      }
    }
  }
}
