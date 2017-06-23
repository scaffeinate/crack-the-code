package chapter_3.additional;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.stack.GenericStack;

/**
 * Push into one queue then transfer the other queue elements into current queue
 * and swap the queues. Pop/peek happens from either of the queues in O(1).
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 */
public class MyStack2<T> implements GenericStack<T> {

    private Queue<T> firstQueue;
    private Queue<T> secondQueue;
    private boolean pushingToFirstQueue = true;
    private int size = 0;

    public MyStack2() {
        firstQueue = new LinkedList<T>();
        secondQueue = new LinkedList<T>();
    }

    @Override
    public void push(T data) {
        if (pushingToFirstQueue) {
            firstQueue.add(data);
            transfer(secondQueue, firstQueue);
        } else {
            secondQueue.add(data);
            transfer(firstQueue, secondQueue);
        }
        size++;
        pushingToFirstQueue = !pushingToFirstQueue;
    }

    @Override
    public T pop() {
        size--;
        return current().poll();
    }

    @Override
    public T peek() {
        return current().peek();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void transfer(Queue<T> queue1, Queue<T> queue2) {
        while (queue1.size() > 0) {
            queue2.add(queue1.remove());
        }
    }

    private Queue<T> current() {
        Queue<T> currentQueue = (pushingToFirstQueue) ? secondQueue : firstQueue;
        return currentQueue;
    }
}
