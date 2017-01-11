package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.SetOfStacksRollover;
import util.InputUtil;

public class SetOfPlatesRollover {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "set_of_plates_rollover");
    int threshold = Integer.parseInt(input[0]);
    SetOfStacksRollover<Integer> setOfStacks = new SetOfStacksRollover<Integer>(threshold);
    for (String line:input) {
      if(line.startsWith("push")) {
        int data = Integer.parseInt(InputUtil.getArg(line));
        System.out.println("Pushing to stack : " + data);
        setOfStacks.push(data);
      } else if(line.startsWith("pop()")) {
        System.out.println("Popping from stack : " + setOfStacks.pop());
      } else if(line.startsWith("peek")) {
        System.out.println("Top: " + setOfStacks.peek());
      } else if(line.startsWith("popAt")) {
        int stackNumber = Integer.parseInt(InputUtil.getArg(line));
        Integer popped = setOfStacks.popAt(stackNumber);
        if(popped != null) {
          System.out.println("PoppingAt from stack: " + stackNumber + " -> " + popped);
        }
      }
    }
    
    System.out.println(setOfStacks.toString());
    
  }
}
