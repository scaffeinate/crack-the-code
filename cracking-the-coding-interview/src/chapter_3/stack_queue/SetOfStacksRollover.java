package chapter_3.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacksRollover<T> {
  private List<TwoWayStack<T>> listOfStacks = null;
  private int threshold;

  public SetOfStacksRollover(int threshold) {
    listOfStacks = new ArrayList<TwoWayStack<T>>();
    this.threshold = threshold;
  }

  public void push(T data) {
    TwoWayStack<T> recentStack = getRecentStack();
    if (recentStack == null || recentStack.size() >= threshold) {
      listOfStacks.add(createNewStack(data));
    } else {
      recentStack.push(data);
    }
  }

  public T pop() {
    T data = null;
    TwoWayStack<T> recentStack = getRecentStack();
    if (recentStack != null) {
      data = recentStack.pop();
      if (recentStack.isEmpty()) {
        listOfStacks.remove(listOfStacks.size() - 1);
      }
    }
    return data;
  }

  public T peek() {
    TwoWayStack<T> recentStack = getRecentStack();
    if(recentStack != null) {
      return recentStack.peek();
    }
    
    return null;
  }

  public T popAt(int index) {
    if (index < 0 || index >= listOfStacks.size()) {
      return null;
    }

    TwoWayStack<T> stackAtIndex = listOfStacks.get(index);
    T data = stackAtIndex.pop();
    
    if (stackAtIndex.isEmpty()) {
      listOfStacks.remove(index);
      return data;
    }

    for (int i = index + 1; i < listOfStacks.size(); i++) {
      TwoWayStack<T> nextStack = listOfStacks.get(i);
      T newTop = nextStack.popBottom();
      if(nextStack.isEmpty()) {
        listOfStacks.remove(i);
      }
      stackAtIndex.push(newTop);
      stackAtIndex = nextStack;
    }

    return data;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (TwoWayStack<T> stack : listOfStacks) {
      builder.append(stack.toString()).append(" ");
    }
    return builder.toString();
  }

  private TwoWayStack<T> createNewStack(T data) {
    TwoWayStack<T> stack = new TwoWayStack<T>();
    stack.push(data);
    return stack;
  }

  private TwoWayStack<T> getRecentStack() {
    if (listOfStacks.isEmpty()) {
      return null;
    }

    return listOfStacks.get(listOfStacks.size() - 1);
  }
}
