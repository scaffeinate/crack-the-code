package chapter_3.additional;

import java.io.FileNotFoundException;

import datastructures.stack.GenericStack;
import util.InputUtil;

/**
 * Question: Implement a Stack class using two queues.
 *
 * @author Sudharsanan Muralidharan
 */
public class StackviaQueues {

    /**
     * Using method1 which shifts elements when popping or peeking. O(1) for
     * pushing and Degree of O(n) for pop/peek.
     *
     * @param input
     */
    private void stackMethod1(String[] input) {
        GenericStack<Integer> stack = new MyStack<Integer>();
        stackOperation(stack, input);
    }

    /**
     * Use method2 which shifts elements when pushing. Degree of O(n) for pushing
     * and O(1) for pop/peek.
     *
     * @param input
     */
    private void stackMethod2(String[] input) {
        GenericStack<Integer> stack = new MyStack2<Integer>();
        stackOperation(stack, input);
    }

    /**
     * Stack operations util method
     *
     * @param stack
     * @param input
     */
    private void stackOperation(GenericStack<Integer> stack, String[] input) {
        for (String line : input) {
            if (line.startsWith("push")) {
                int data = Integer.parseInt(InputUtil.getArg(line));
                System.out.println("Pushing to stack: " + data);
                stack.push(data);
            } else if (line.startsWith("pop")) {
                System.out.println("Popping from stack : " + stack.pop());
            } else if (line.startsWith("peek")) {
                System.out.println("Peek: " + stack.peek());
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(3, "stack_via_queues");
        StackviaQueues stackviaQueues = new StackviaQueues();
        System.out.println("Using Method in which transfer is done during Pop/Peek:");
        stackviaQueues.stackMethod1(input);

        System.out.println("\n\nUsing Method in which transfer is done during Push:");
        stackviaQueues.stackMethod2(input);
    }
}
