package chapter_3;

import java.io.FileNotFoundException;

import util.InputUtil;

/**
 * Question 3.1: Describe how you could use a single array to implement three
 * stacks.
 * 
 * @author Sudharsanan Muralidharan
 */
public class ThreeinOne {
  private Stack stack;

  public ThreeinOne(Stack stack) {
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
    Stack fixedStack = new FixedSizeStack(stackCapacity, numStacks);
    ThreeinOne threeinOne = new ThreeinOne(fixedStack);

    for (int i = 1; i < input.length; i++) {
      String line = input[i];
      int stackNumber, val;
      if (line.startsWith("push(")) {
        stackNumber = Integer.parseInt(String.valueOf(line.charAt(5)));
        val = Integer.parseInt(line.subSequence(line.indexOf(',') + 1, line.indexOf(')')).toString());
        System.out.println("Pushing " + val + " to stack " + stackNumber);
        threeinOne.push(stackNumber, val);
      } else if (line.startsWith("pop(")) {
        stackNumber = Integer.parseInt(String.valueOf(line.charAt(4)));
        System.out.println("Popping from stack " + stackNumber + " -> " + threeinOne.pop(stackNumber));
      }
    }

    System.out.println();

    for (int i = 0; i < numStacks; i++) {
      threeinOne.print(i);
    }

    threeinOne.print();
  }

  /**
   * Fixed stack size approach. When Limit is reached items are not further
   * added to the stack.
   * 
   * @author Sudharsanan Muralidharan
   */
  static class FixedSizeStack implements Stack {
    private int stackCapacity = 0;
    private int numStacks = 0;
    private int[] arr;
    private int[] size;

    FixedSizeStack(int stackCapacity, int numStacks) {
      this.stackCapacity = stackCapacity;
      this.numStacks = numStacks;
      this.arr = new int[numStacks * stackCapacity];
      this.size = new int[numStacks];

      for (int i = 0; i < arr.length; i++) {
        arr[i] = -1;
      }
    }

    /**
     * Push item to stack
     * 
     * @param stackNumber
     * @param value
     */
    @Override
    public void push(int stackNumber, int value) {
      if (stackNumber > numStacks || stackNumber < 0) {
        System.out.println("Not a valid stack number");
        return;
      }

      if (size[stackNumber] >= stackCapacity) {
        System.out.println("Stack Capacity Reached");
        return;
      }

      int offset = ((stackNumber * stackCapacity) + size[stackNumber]);
      arr[offset] = value;
      size[stackNumber]++;
    }

    /**
     * Pop item from stack
     * 
     * @param stackNumber
     * @return value
     */
    @Override
    public int pop(int stackNumber) {
      int val = -1, offset = ((stackNumber * stackCapacity) + size[stackNumber] - 1);
      if (size[stackNumber] == 0) {
        System.out.println("Stack is Empty");
        return -1;
      }
      val = arr[offset];
      arr[offset] = -1;
      size[stackNumber]--;
      return val;
    }

    /**
     * Check is stack is empty
     * 
     * @param stackNumber
     * @return isEmpty
     */
    @Override
    public boolean isEmpty(int stackNumber) {
      return size[stackNumber] == 0;
    }

    /**
     * Contents of the stack at stackNumber
     * @param stackNumber
     * @return contents
     */
    @Override
    public String toString(int stackNumber) {
      int offset = (stackNumber * stackCapacity);
      int i = offset, limit = (offset + stackCapacity);
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      while (i < limit) {
        builder.append(arr[i]).append((i == (limit - 1) ? "]" : " "));
        i++;
      }
      return builder.toString();
    }

    /**
     * Contents of the array containing all stacks
     * @return content
     */
    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      for (int i = 0; i < arr.length; i++) {
        builder.append(arr[i]).append((i == (arr.length - 1) ? "]" : " "));
      }

      return builder.toString();
    }
  }

  /**
   * Interface Multistack operations
   * 
   * @author Sudharsanan Muralidharan
   */
  public interface Stack {
    void push(int stackNumber, int value);

    int pop(int stackNumber);

    boolean isEmpty(int stackNumber);

    String toString(int stackNumber);

    String toString();
  }
}
