package datastructures.lists;

/**
 * DoubleLinkedList - Double LinkedList implementation.
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 * @extends AbstractList<T>
 */
public class DoubleLinkedList<T> extends AbstractList<T> {

    /**
     * Add to the DoubleLinkedList
     *
     * @param data
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
            LinkedListNode<T> node = new LinkedListNode<T>(data);
            tail.next = node;
            node.prev = tail;
            tail = node;
            added = true;
        }
        size++;
        return added;
    }

    /**
     * Add data at the index
     *
     * @param index
     * @param data
     * @return added
     */
    @Override
    public boolean add(int index, T data) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            return addToFront(data);
        } else if (index == (size - 1)) {
            return add(data);
        } else {
            return addAt(data, index);
        }
    }

    /**
     * Remove data from LinkedList
     *
     * @param o
     * @return removed
     */
    @Override
    public boolean remove(Object o) {
        if (head.data.equals(o)) {
            return removeFirst();
        } else if (tail.data.equals(o)) {
            return removeLast();
        } else {
            LinkedListNode<T> current = head;
            while (current != null) {
                if (current.data.equals(o)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    /**
     * Remove element at index
     *
     * @param index
     * @return removed
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            LinkedListNode<T> current = head;
            int i = 0;

            while (current != null) {
                if (i == index) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return true;
                }
                i++;
                current = current.next;
            }
        }

        return false;
    }

    /**
     * Get element at index
     *
     * @param index
     * @return T data
     */
    @Override
    public T get(int index) {
        LinkedListNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.data;
            }
            i++;
            current = current.next;
        }

        return null;
    }

    /**
     * Sets element at index to data
     *
     * @param index
     * @param data
     * @return addedData
     */
    @Override
    public T set(int index, T data) {
        LinkedListNode<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                current.data = data;
                return current.data;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    /**
     * Add to front of the DoubleLinkedList
     *
     * @param data
     * @return added
     */
    public boolean addToFront(T data) {
        LinkedListNode<T> node = new LinkedListNode<T>(data, head);
        head.prev = node;
        head = node;
        size++;
        return true;
    }

    /**
     * Remove the front of the DoubleLinkedList
     *
     * @return removed
     */
    public boolean removeFirst() {
        if (head == null) {
            return false;
        }
        head = head.next;
        head.prev = null;
        size--;
        return true;
    }

    /**
     * Remove back of the DoubleLinkedList
     *
     * @return removed
     */
    public boolean removeLast() {
        if (tail == null) {
            return false;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return true;
    }

    /**
     * Add data at index of the DoubleLinkedList
     *
     * @param data
     * @param index
     * @return added
     */
    private boolean addAt(T data, int index) {
        LinkedListNode<T> current = head;
        int i = 1;

        while (current != null) {
            if (i == index) {
                LinkedListNode<T> node = new LinkedListNode<T>(data, current.next, current);
                current.next.prev = node;
                current.next = node;
                size++;
                return true;
            }

            i++;
            current = current.next;
        }

        return false;
    }

    /**
     * Prints DoubleLinkedList
     */
    public void print() {
        System.out.println(this.toString());
    }

    /**
     * Prints the DoubleLinkedList in reverse
     */
    public void printReverse() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<T> current = tail;
        builder.append("null<-");
        while (current.prev != null) {
            builder.append(current.data).append("<=>");
            current = current.prev;
        }
        builder.append(current.data);
        builder.append("->null");
        System.out.println(builder.toString());
    }

    /*
     * Override toString() (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<T> current = head;
        builder.append("null<-");
        while (current.next != null) {
            builder.append(current.data).append("<=>");
            current = current.next;
        }
        builder.append(current.data).append("->null");
        return builder.toString();
    }
}
