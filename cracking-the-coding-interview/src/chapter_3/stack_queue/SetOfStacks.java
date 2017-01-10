package chapter_3.stack_queue;

import java.util.HashMap;
import java.util.Map;

public class SetOfStacks<T> extends AbstractStack<T> {
  private Map<Integer, CustomStack<T>> map;
  private int threshold = 0;
  private int mostRecentStack = -1;

  public SetOfStacks(int threshold) {
    this.threshold = threshold;
    map = new HashMap<Integer, CustomStack<T>>();
  }

  @Override
  public void push(T data) {
    CustomStack<T> stack = map.get(mostRecentStack);
    if (mostRecentStack == -1 || (stack != null && stack.size() > threshold)) {
      stack = createStack();
      mostRecentStack++; 
    }

    stack.push(data);
    map.put(mostRecentStack, stack);
  }

  @Override
  public T pop() {
    return popAt(mostRecentStack);
  }

  @Override
  public T peek() {
    CustomStack<T> stack = map.get(mostRecentStack);
    if (stack != null) {
      return stack.peek();
    }

    return null;
  }

  public T popAt(int index) {
    CustomStack<T> stack = map.get(index);
    if (stack == null) {
      System.out.println("Sub-stack at " + index + " not found");
      return null;
    }
    
    T popped = stack.pop();
    if (stack.isEmpty()) {
      mostRecentStack--;
      System.out.println("Stack at " + index + " is empty. Updating recent stack to " + mostRecentStack);
    }
    return popped;
  }

  private CustomStack<T> createStack() {
    CustomStack<T> stack = new CustomStack<T>();
    return stack;
  }
}
