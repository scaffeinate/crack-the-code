package chapter_3.stack_queue;

/**
 * Interface Multistack operations
 *
 * @author Sudharsanan Muralidharan
 */
public interface MultiStack {
    void push(int stackNumber, int value);

    int pop(int stackNumber);

    boolean isEmpty(int stackNumber);

    String toString(int stackNumber);

    String toString();
}