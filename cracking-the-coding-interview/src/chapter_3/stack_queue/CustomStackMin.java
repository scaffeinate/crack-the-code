package chapter_3.stack_queue;

import datastructures.common.Node;
import datastructures.lists.stack.CustomStack;

/**
 * Extend the CustomStack to include the method min which returns the minValue
 * that we track
 * 
 * @author Sudharsanan Muralidharan
 */
public class CustomStackMin extends CustomStack<Integer> {
  Integer minVal = Integer.MAX_VALUE;

  /**
   * If data is less than minVal then update minVal
   */
  @Override
  public void push(Integer data) {
    if (data <= minVal) {
      minVal = data;
    }
    super.push(data);
  }

  /**
   * If the minVal is popped then search for the next minVal
   */
  @Override
  public Integer pop() {
    Integer data = super.pop();
    if (data == minVal) {
      minVal = findMin(data);
    }
    return data;
  }

  /**
   * @return minVal
   */
  public Integer min() {
    return minVal;
  }

  /**
   * Find Min value in the stack.
   * @param data
   * @return minVal
   */
  private int findMin(int data) {
    Node<Integer> node = super.top();
    int min = node.data;
    while (node != null) {
      if (node.data <= min) {
        min = node.data;
      }
      node = node.next;
    }

    return min;
  }
}
