package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.MyQueue;
import util.InputUtil;

public class QueueViaStacks {
  public static void main(String[] args) throws FileNotFoundException {
    String[] input = InputUtil.readContents(3, "queue_via_stacks");
    MyQueue<Integer> myQueue = new MyQueue<Integer>();
    for (String line : input) {
      if(line.startsWith("add")) {
        int data = Integer.parseInt(InputUtil.getArg(line));
        System.out.println("Adding to queue: " + data);
        myQueue.add(data);
      } else if(line.startsWith("remove")) {
        System.out.println("Removing from queue : " + myQueue.remove());
      } else if(line.startsWith("peek")) {
        System.out.println("Peek: " + myQueue.peek());
      }
    }
  }
}
