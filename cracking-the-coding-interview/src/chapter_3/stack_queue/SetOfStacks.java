package chapter_3.stack_queue;

import java.util.ArrayList;
import java.util.List;

import datastructures.stack.AbstractStack;
import datastructures.stack.CustomStack;

public class SetOfStacks<T> extends AbstractStack<T> {
  private List<CustomStack<T>> listOfStacks;
  private int threshold = 0;

  public SetOfStacks(int threshold) {
    this.threshold = threshold;
    listOfStacks = new ArrayList<CustomStack<T>>();
  }

  @Override
  public void push(T data) {
    CustomStack<T> stack = getRecentStack();
    if (stack == null || (stack != null && stack.size() >= threshold)) {
      createStack(data);
    } else {
      stack.push(data);
    }
  }

  @Override
  public T pop() {
    CustomStack<T> stack = getRecentStack();
    T popped = stack.pop();
    if (stack.isEmpty()) {
      listOfStacks.remove(listOfStacks.size() - 1);
    }

    return popped;
  }

  @Override
  public T peek() {
    if (listOfStacks.isEmpty()) {
      System.out.println("Stacks are empty");
      return null;
    }

    CustomStack<T> stack = listOfStacks.get(listOfStacks.size() - 1);
    return stack.peek();
  }

  private void createStack(T data) {
    CustomStack<T> stack = new CustomStack<T>();
    stack.push(data);
    listOfStacks.add(stack);
  }

  private CustomStack<T> getRecentStack() {
    CustomStack<T> stack = null;
    try {
      stack = listOfStacks.get(listOfStacks.size() - 1);
    } catch (IndexOutOfBoundsException e) {

    }

    return stack;
  }
}