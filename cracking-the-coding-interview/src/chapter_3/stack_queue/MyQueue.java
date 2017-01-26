package chapter_3.stack_queue;

import datastructures.stack.CustomStack;

/**
 * MyQueue implementation using two stacks. Two approaches are possible for this
 * problem:
 * 
 * 1. One approach is to have a push stack and pop stack. We transfer elements
 * between push and pop stack. When push is called we transfer from pop stack to
 * push stack and add to push stack. When pop or peek is called we transfer from
 * push stack to pop stack and do the operation. This is unecessary since we
 * keep shifting the elements.
 * 
 * 2. Second approach is to have a stack from newElements and one for
 * oldElements. We add to the newStack when push is called. When pop or peek is
 * called we check whether oldStack.isEmpty() and if so we shift the elements
 * once to the oldStack. Push is always to the newStack and pop/peek is always
 * at the oldStack. We do the shift only when the oldStack gets empty. This is
 * more efficient than the first method.
 * 
 * @author Sudharsanan Muralidharan
 *
 * @param <T>
 */
public class MyQueue<T> {
  private CustomStack<T> oldStack, newStack;

  public MyQueue() {
    oldStack = new CustomStack<T>();
    newStack = new CustomStack<T>();
  }

  /**
   * Push data to the newStack
   * 
   * @param data
   */
  public void add(T data) {
    newStack.push(data);
  }

  /**
   * Shift Stacks if oldStack isEmpty(). Then pop from oldStack.
   * 
   * @return data
   */
  public T remove() {
    shiftStacks();
    return oldStack.pop();
  }

  /**
   * Shift stacks if oldStack isEmpty(). Then peek from oldStack.
   * 
   * @return
   */
  public T peek() {
    shiftStacks();
    return oldStack.peek();
  }

  /**
   * Total size would be combined sizes of oldStack + newStack.
   * 
   * @return size
   */
  public int size() {
    return oldStack.size() + newStack.size();
  }

  /**
   * If oldStack.isEmpty() then shift the elements.
   */
  private void shiftStacks() {
    if (oldStack.isEmpty()) {
      while (!newStack.isEmpty()) {
        oldStack.push(newStack.pop());
      }
    }
  }
}
