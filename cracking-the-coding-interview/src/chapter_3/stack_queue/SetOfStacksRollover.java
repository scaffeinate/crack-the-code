package chapter_3.stack_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * SetOfStacks is composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * behaves identical to a single stack.
 * 
 * popAt(int index) performs the pop operation on a specific sub-stack. If there
 * is no rollover adjustment done then it might lead to almost empty sub-stacks
 * in the middle. To support rollover we need a wrapper over the Stack which
 * supports pop from both top and bottom.
 * 
 * @author Sudharsanan Muralidharan
 * 
 * @param <T>
 */
public class SetOfStacksRollover<T> {
  private List<TwoWayStack<T>> listOfStacks = null;
  private int threshold;

  /**
   * Set the threshold after which it carries over to next stack
   * 
   * @param threshold
   */
  public SetOfStacksRollover(int threshold) {
    listOfStacks = new ArrayList<TwoWayStack<T>>();
    this.threshold = threshold;
  }

  /**
   * Push item to stack. If threshold exceeds create new stack and add it to the
   * listOfStacks.
   * 
   * @param data
   */
  public void push(T data) {
    TwoWayStack<T> recentStack = getRecentStack();
    if (recentStack == null || recentStack.size() >= threshold) {
      listOfStacks.add(createNewStack(data));
    } else {
      recentStack.push(data);
    }
  }

  /**
   * Pop top of the most recent stack
   * 
   * @return poppedElement
   */
  public T pop() {
    T data = null;
    TwoWayStack<T> recentStack = getRecentStack();
    if (recentStack != null) {
      data = recentStack.pop();
      // If the recent stack is empty then remove it from listOfStacks
      if (recentStack.isEmpty()) {
        listOfStacks.remove(listOfStacks.size() - 1);
      }
    }
    return data;
  }

  /**
   * Peek top of most recent stack
   */
  public T peek() {
    TwoWayStack<T> recentStack = getRecentStack();
    if (recentStack != null) {
      return recentStack.peek();
    }

    return null;
  }

  /**
   * If stack at index is not empty then pop from it. Roll over the bottom of
   * the next stack to the top of the current stack until we reach the last
   * stack. So for each pop the top of the subsequent stacks are altered.
   * 
   * @param index
   * @return poppedElement
   */
  public T popAt(int index) {
    if (index < 0 || index >= listOfStacks.size()) {
      return null;
    }

    TwoWayStack<T> stackAtIndex = listOfStacks.get(index);
    T data = stackAtIndex.pop();

    // If stack at index(current) is empty then remove from listOfStacks
    if (stackAtIndex.isEmpty()) {
      listOfStacks.remove(index);
      return data;
    }

    /*
     * Start from index+1 to size rollover the elements from bottom of
     * subsequent stack to top of current stack
     */
    for (int i = index + 1; i < listOfStacks.size(); i++) {
      TwoWayStack<T> nextStack = listOfStacks.get(i);
      T newTop = nextStack.popBottom();

      // If the next stack has exhausted all elements then we remove it
      // from listOfStacks
      if (nextStack.isEmpty()) {
        listOfStacks.remove(i);
      }

      // Push the nextStack bottom to currentStack top
      stackAtIndex.push(newTop);
      stackAtIndex = nextStack; // Make currentStack = nextStack
    }

    return data;
  }

  /**
   * @Override toString()
   * 
   * @return contents of stack
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (TwoWayStack<T> stack : listOfStacks) {
      builder.append(stack.toString()).append(" ");
    }
    return builder.toString();
  }

  /**
   * Create new stack and push data into it, add it to listOfStacks
   * 
   * @param data
   */
  private TwoWayStack<T> createNewStack(T data) {
    TwoWayStack<T> stack = new TwoWayStack<T>();
    stack.push(data);
    return stack;
  }

  /**
   * Fetch most recent stack
   * 
   * @return mostRecentStack
   */
  private TwoWayStack<T> getRecentStack() {
    if (listOfStacks.isEmpty()) {
      return null;
    }

    return listOfStacks.get(listOfStacks.size() - 1);
  }
}
