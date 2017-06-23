package chapter_3.stack_queue;

import java.util.ArrayList;
import java.util.List;

import datastructures.stack.CustomStack;
import datastructures.stack.GenericStack;

/**
 * SetOfStacks is composed of several stacks and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * behaves identical to a single stack.
 * <p>
 * Since there is no popAt(index) there is no rollover. So push & pop always
 * happen to the most recent stack.
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 */
public class SetOfStacks<T> implements GenericStack<T> {
    private List<CustomStack<T>> listOfStacks;
    private int threshold = 0;
    private int size = 0;

    /**
     * Set the threshold after which it carries over to next stack
     *
     * @param threshold
     */
    public SetOfStacks(int threshold) {
        this.threshold = threshold;
        listOfStacks = new ArrayList<CustomStack<T>>();
    }

    /**
     * Push item to stack. If threshold exceeds create new stack and add it to the
     * listOfStacks.
     *
     * @param data
     */
    @Override
    public void push(T data) {
        CustomStack<T> stack = getRecentStack();
        if (stack == null || (stack != null && stack.size() >= threshold)) {
            createStack(data);
        } else {
            stack.push(data);
        }
    }

    /**
     * Pop top of the most recent stack
     *
     * @return poppedElement
     */
    @Override
    public T pop() {
        T data = null;
        CustomStack<T> recentStack = getRecentStack();
        if (recentStack != null) {
            data = recentStack.pop();
            // If the recent stack is empty then remove it from listOfStacks
            if (recentStack.isEmpty()) {
                listOfStacks.remove(listOfStacks.size() - 1);
            }
        }
        return data;
    }

    /**
     * Peek top of most recent stack
     */
    @Override
    public T peek() {
        if (listOfStacks.isEmpty()) {
            System.out.println("Stacks are empty");
            return null;
        }

        CustomStack<T> stack = listOfStacks.get(listOfStacks.size() - 1);
        return stack.peek();
    }

    /**
     * Create new stack and push data into it, add it to listOfStacks
     *
     * @param data
     */
    private void createStack(T data) {
        CustomStack<T> stack = new CustomStack<T>();
        stack.push(data);
        listOfStacks.add(stack);
    }

    /**
     * Fetch most recent stack
     *
     * @return mostRecentStack
     */
    private CustomStack<T> getRecentStack() {
        if (listOfStacks.isEmpty()) {
            return null;
        }

        return listOfStacks.get(listOfStacks.size() - 1);
    }

    /**
     * Return size
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Return isEmpty
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }
}