package datastructures.lists.stack;

/**
 * AbstractStack class which has the basic stack functions. push(), pop() and
 * peek() are abstract and should be overridden by extending class.
 * 
 * @author Sudharsanan Muralidharan
 * @param <T>
 */
public abstract class AbstractStack<T> {
  protected int size = 0;

  public abstract void push(T data);

  public abstract T pop();

  public abstract T peek();

  /**
   * Get stack size
   * 
   * @return size
   */
  public int size() {
    return this.size;
  }

  /**
   * Check if stack is Empty
   * 
   * @return size == 0
   */
  public boolean isEmpty() {
    return (size == 0);
  }
}
