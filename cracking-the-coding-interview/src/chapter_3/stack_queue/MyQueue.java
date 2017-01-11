package chapter_3.stack_queue;

import datastructures.stack.CustomStack;

public class MyQueue<T> {
  private CustomStack<T> oldStack, newStack;

  public MyQueue() {
    oldStack = new CustomStack<T>();
    newStack = new CustomStack<T>();
  }

  public void add(T data) {
    newStack.push(data);
  }

  public T remove() {
    shiftStacks();
    return oldStack.pop();
  }

  public T peek() {
    shiftStacks();
    return oldStack.peek();
  }
  
  public int size() {
    return oldStack.size() + newStack.size();
  }
  
  private void shiftStacks() {
    if (oldStack.isEmpty()) {
      while (!newStack.isEmpty()) {
        oldStack.push(newStack.pop());
      }
    }
  }
}
