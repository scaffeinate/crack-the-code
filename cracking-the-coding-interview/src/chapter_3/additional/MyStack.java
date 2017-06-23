package chapter_3.additional;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.stack.GenericStack;

/**
 * Keep pushing to one queue and when pop/peek is called transfer 0 to n-2
 * elements to other queue. Pop element or peek. Swap the queues.
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 */
public class MyStack<T> implements GenericStack<T> {
    private Queue<T> firstQueue, secondQueue;
    boolean pushingToFirstQueue = true;
    private int size = 0;

    public MyStack() {
        firstQueue = new LinkedList<T>();
        secondQueue = new LinkedList<T>();
    }

    @Override
    public T peek() {
        T data = null;
        if (pushingToFirstQueue) {
            data = transfer(firstQueue, secondQueue);
            secondQueue.add(data);
        } else {
            data = transfer(secondQueue, firstQueue);
            firstQueue.add(data);
        }
        pushingToFirstQueue = !pushingToFirstQueue;
        return data;
    }

    @Override
    public void push(T data) {
        if (pushingToFirstQueue) {
            firstQueue.add(data);
        } else {
            secondQueue.add(data);
        }

        size++;
    }

    @Override
    public T pop() {
        T data = null;
        if (pushingToFirstQueue) {
            data = transfer(firstQueue, secondQueue);
        } else {
            data = transfer(secondQueue, firstQueue);
        }
        size--;
        pushingToFirstQueue = !pushingToFirstQueue;
        return data;
    }

    private T transfer(Queue<T> queue1, Queue<T> queue2) {
        T data = null;
        int queueSize = queue1.size();
        while (queueSize-- > 0) {
            data = queue1.remove();
            if (queueSize != 0) {
                queue2.add(data);
            }
        }
        return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }
}
