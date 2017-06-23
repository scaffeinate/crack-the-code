package datastructures.stack;

/**
 * AbstractStack Interface which has the basic stack functions. push(), pop()
 * and peek()
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 */

public interface GenericStack<T> {

    void push(T data);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}