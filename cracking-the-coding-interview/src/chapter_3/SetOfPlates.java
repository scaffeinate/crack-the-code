package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.SetOfStacks;
import util.InputUtil;

/**
 * Question 3.3: Imagine a (literal) stack of plates. If the stack gets too high
 * it might topple.
 * 
 * @author Sudharsanan Muralidharan
 */
public class SetOfPlates {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "set_of_plates");
    int threshold = Integer.parseInt(input[0]);
    SetOfStacks<Integer> setOfStacks = new SetOfStacks<Integer>(threshold);
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
