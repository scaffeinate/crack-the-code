package chapter_3;

import java.io.FileNotFoundException;

import chapter_3.stack_queue.FixedSizeStack;
import chapter_3.stack_queue.MultiStack;
import util.InputUtil;

/**
 * Question 3.1: Describe how you could use a single array to implement three
 * stacks.
 *
 * @author Sudharsanan Muralidharan
 */
public class ThreeinOne {
    private MultiStack stack;

    public ThreeinOne(MultiStack stack) {
        this.stack = stack;
    }

    /**
     * Add value to stack at stackNumber
     *
     * @param stackNumber
     * @param value
     */
    public void push(int stackNumber, int value) {
        this.stack.push(stackNumber, value);
    }

    /**
     * Pops item of stack at stackNumber
     *
     * @param stackNumber
     * @return value
     */
    public int pop(int stackNumber) {
        return this.stack.pop(stackNumber);
    }

    /**
     * Prints stack at stackNumber
     *
     * @param stackNumber
     */
    private void print(int stackNumber) {
        System.out.println("Printing stack " + stackNumber + " : " + this.stack.toString(stackNumber));
    }

    /**
     * Prints array containing all stacks
     */
    private void print() {
        System.out.println("Printing all three stacks: " + this.stack);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String[] input = InputUtil.readContents(3, "three_in_one");
        String[] values = input[0].split(" ");
        int stackCapacity = Integer.parseInt(values[0]);
        int numStacks = Integer.parseInt(values[1]);
        MultiStack fixedStack = new FixedSizeStack(stackCapacity, numStacks);
        ThreeinOne threeinOne = new ThreeinOne(fixedStack);

        for (int i = 1; i < input.length; i++) {
            String line = input[i];
            int stackNumber, val;
            if (line.startsWith("push")) {
                String[] inputArgs = InputUtil.getArgs(line, 2);
                stackNumber = Integer.parseInt(inputArgs[0]);
                val = Integer.parseInt(inputArgs[1]);
                threeinOne.push(stackNumber, val);
            } else if (line.startsWith("pop")) {
                stackNumber = Integer.parseInt(InputUtil.getArg(line));
                System.out.println("Popping from stack " + stackNumber + " -> " + threeinOne.pop(stackNumber));
            }
        }

        System.out.println();

        for (int i = 0; i < numStacks; i++) {
            threeinOne.print(i);
        }

        threeinOne.print();
    }
}
