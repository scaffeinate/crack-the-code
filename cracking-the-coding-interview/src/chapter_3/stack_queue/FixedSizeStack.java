package chapter_3.stack_queue;

/**
 * Fixed stack size approach. When Limit is reached items are not further added
 * to the stack.
 * 
 * @author Sudharsanan Muralidharan
 */
public class FixedSizeStack implements MultiStack {
  private int stackCapacity = 0;
  private int numStacks = 0;
  private int[] arr;
  private int[] size;

  public FixedSizeStack(int stackCapacity, int numStacks) {
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
   * 
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
   * 
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
