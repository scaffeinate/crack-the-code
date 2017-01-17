package datastructures.stack;

/**
 * AbstractStack Interface which has the basic stack functions. push(), pop()
 * and peek()
 * 
 * @author Sudharsanan Muralidharan
 * @param <T>
 */

public interface GenericStack<T> {

  void push(T data);

  T pop();

  T peek();

  int size();

  boolean isEmpty();

}