/**
 *
 */
package datastructures.lists;

import datastructures.util.ListUtil;
import org.omg.SendingContext.RunTime;

/**
 * CustomLinkedList: Single LinkedList implementation
 *
 * @author Sudharsanan Muralidharan
 * @param<T>
 * @extends AbstractList<T>
 */
public class CustomLinkedList<T> extends AbstractList<T> implements Cloneable {

    /**
     * Default Constructor
     */
    public CustomLinkedList() {
    }

    /**
     * Constructor which takes the head node. Shallow copy.
     *
     * @param head
     */
    public CustomLinkedList(LinkedListNode<T> head) {
        this.head = head;
    }

    /**
     * Copy an existing CustomLinkedList<T>. Deep copy.
     *
     * @param copyList
     */
    public CustomLinkedList(CustomLinkedList<T> copyList) {
        LinkedListNode<T> current = copyList.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }

    /**
     * Add new object to LinkedList
     *
     * @param e
     * @return added
     */
    @Override
    public boolean add(T data) {
        boolean added = false;

        if (head == null) {
            head = new LinkedListNode<T>(data);
            tail = head;
            added = true;
        } else {
            LinkedListNode<T> current = new LinkedListNode<T>(data);
            tail.next = current;
            tail = current;
            added = true;
        }

        size++;
        return added;
    }

    /**
     * Add an element at the index
     *
     * @param index
     * @param element
     */
    @Override
    public boolean add(int index, T data) {
        LinkedListNode<T> current = head;
        int i = 0;

        if (index == 0) {
            LinkedListNode<T> node = new LinkedListNode<T>(data, head);
            head = node;
            size++;
            return true;
        }

        if (index == size - 1) {
            LinkedListNode<T> node = new LinkedListNode<T>(data, head);
            tail = node;
            size++;
            return true;
        }

        while (current != null) {
            if (i == index - 1) {
                LinkedListNode<T> node = new LinkedListNode<T>(data, current.next);
                current.next = node;
                size++;
                return true;
            }

            current = current.next;
            i++;
        }

        return false;
    }

    /**
     * Removes the object from the list
     *
     * @param o
     * @return removed
     */
    @Override
    public boolean remove(Object o) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> runner = current.next;

        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        while (runner != null) {
            if (runner.data.equals(o)) {
                current.next = runner.next;
                size--;
                if (runner.equals(tail)) {
                    tail = current;
                }
                return true;
            } else {
                current = current.next;
            }
            runner = runner.next;
        }

        return false;
    }

    /**
     * Removes the object at index from list
     *
     * @param index
     * @return removed
     */
    @Override
    public boolean remove(int index) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> runner = current.next;
        int i = 1;

        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }

        while (runner != null) {
            if (i == index) {
                current.next = runner.next;
                size--;
                if (i == size) {
                    tail = current;
                }
                return true;
            } else {
                current = current.next;
            }
            runner = runner.next;
            i++;
        }

        return false;
    }

    /**
     * Removed the front of the LinkedList
     *
     * @return removed
     */
    @Override
    public boolean removeFirst() {
        if (head == null) {
            return false;
        }

        head = head.next;
        size--;
        return true;
    }

    /**
     * Remove the back of the LinkedList
     *
     * @return removed
     */
    @Override
    public boolean removeLast() {
        if (tail == null) {
            return false;
        }

        LinkedListNode<T> current = head;
        LinkedListNode<T> runner = current.next;
        while (runner != null) {
            if (runner.equals(tail)) {
                current.next = null;
                tail = current;
                size--;
                return true;
            }
        }

        return false;
    }

    /**
     * Get the element value at the index
     *
     * @param index
     * @return found.data
     */
    @Override
    public T get(int index) {
        LinkedListNode<T> node = find(index);
        if (node != null) {
            return node.data;
        }
        return null;
    }

    /**
     * Set the element value at the specified index
     *
     * @param index
     * @param element
     * @return found.data
     */
    @Override
    public T set(int index, T element) {
        LinkedListNode<T> node = find(index);
        if (node != null) {
            node.data = element;
            return node.data;
        }
        return null;
    }

    /**
     * Add to front of the LinkedList
     *
     * @param e
     * @return added
     */
    public boolean addToFront(T e) {
        boolean added = false;

        if (head == null) {
            head = new LinkedListNode<T>();
            head.data = e;
            head.next = null;
            tail = head;
            added = true;
        } else {
            LinkedListNode<T> node = new LinkedListNode<T>();
            node.data = e;
            node.next = head;
            head = node;
            added = true;
        }

        size++;
        return added;
    }

    /**
     * Prints the list
     */
    public void print() {
        ListUtil.printList(this.head);
    }

    /**
     * Returns the Node<T> at index
     *
     * @param index
     * @return Node<T>
     */
    public LinkedListNode<T> getNode(int index) {
        return find(index);
    }

    /**
     * Returns the Node<T> at the index
     *
     * @param index
     * @return node
     */
    public LinkedListNode<T> find(int index) {
        LinkedListNode<T> current = head;
        int i = 0;

        if (index == 0) {
            return current;
        }

        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.next;
        }

        return null;
    }

    @Override
    public CustomLinkedList<T> clone() {
        CustomLinkedList<T> clone = new CustomLinkedList<T>();
    /*try {
      clone = (CustomLinkedList<T>) super.clone();
    } catch(CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }*/

        LinkedListNode<T> current = this.head;
        while (current != null) {
            clone.add(current.data);
            current = current.next;
        }

        return clone;
    }
}
