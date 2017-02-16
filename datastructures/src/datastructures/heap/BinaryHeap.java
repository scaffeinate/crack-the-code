package datastructures.heap;

import java.lang.reflect.Array;

/**
 * Abstract class BinaryHeap
 * 
 * @param <T>
 * 
 * @author Sudharsanan Muralidharan
 */
public abstract class BinaryHeap<T> {
  // Set Initial heapArray Capacity to 32
  private final int DEFAULT_INITIAL_CAPACITY = 32;
  private int heapCapacity;

  protected HeapType type;
  protected T[] heapArr;
  /*
   * Since the heapArr operations start from index = 1, index = 0 is left empty.
   * So set initial size = 1.
   */
  protected int size = 1;

  /**
   * Constructor which takes in clazz, initialCapacity of the heap and HeapType
   * 
   * @param clazz
   * @param initialCapacity
   * @param type
   */
  @SuppressWarnings("unchecked")
  public BinaryHeap(Class<?> clazz, int initialCapacity, HeapType type) {
    /*
     * If initialCapacity is not specified then default to
     * DEFAULT_INITIAL_CAPACITY
     */
    heapCapacity = (initialCapacity == -1) ? DEFAULT_INITIAL_CAPACITY : initialCapacity;
    heapArr = (T[]) Array.newInstance(clazz, heapCapacity);
    this.type = type;
  }

  /**
   * Inserts new element into the heap
   * 
   * @param data
   */
  public void insert(T data) {
    /*
     * If we reached the heapCapacity then growHeap()
     */
    if (size == heapCapacity) {
      growHeap();
    }

    /*
     * Use size variable as the index where new element needs to be inserted.
     * NOTE: size-1 indicates the actual size of the heap.
     */
    heapArr[size] = data;
    // Insert the root
    if (size == 1) {
      size++;
      return;
    }

    /*
     * Bubble up the element that we inserted to the correct position so that
     * the heap property is maintained.
     */
    int current = size; // start with the index where we inserted
    int parent = (current / 2); // Compute the parent of the element inserted

    /*
     * Bubble up the element unless it stops Violating Heap Property and check
     * till the root at index=1
     */
    while (parent > 0 && violatesProperty(current, parent)) {
      /*
       * Swap current and parent if violation occurs. Make the parent as current
       * and compute it's parent and repeat till violatesProperty is false and
       * parent is root.
       */
      swapElements(current, parent);
      current = parent;
      parent = (current / 2);
    }
    size++;
  }

  /**
   * Given an arr builds the heap using heapify(). Start from the middle of
   * heapArr which indicates the last level of Non-Leaf nodes. While the index >
   * 0 heapify().
   * 
   * Complexity: O(nlgn), Tighter Bound: O(n)
   * 
   * Ref: https://www.cs.bgu.ac.il/~ds122/wiki.files/Presentation09.pdf
   * 
   * @param arr
   */
  @SuppressWarnings("unchecked")
  public void buildHeap(T[] arr) {
    size = arr.length + 1;
    heapArr = (T[]) new Object[size];
    heapCapacity = size;
    System.arraycopy(arr, 0, heapArr, 1, size());

    for (int i = size / 2; i >= 1; i--) {
      heapify(i);
    }
  }

  public T extract() {
    T data = heapArr[1];
    heapArr[1] = heapArr[size()];
    heapArr[size()] = null;
    size--;
    heapify(1);
    return data;
  }

  public T peek() {
    return heapArr[1];
  }

  public int size() {
    return (this.size - 1);
  }

  public void sort(T[] arr) {
    buildHeap(arr);
    int n = size();
    for (int i = n; i >= 2; i--) {
      swapElements(1, i);
      size--;
      heapify(1);
    }

    size = n;
    print();
  }

  public void print() {
    System.out.println("Heap: " + this.toString());
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[ ");
    for (int i = 1; i < size; i++) {
      builder.append(heapArr[i]).append(" ");
    }

    builder.append("]");
    return builder.toString();
  }

  private void heapify(int index) {
    int leftChild = 2 * index;
    int rightChild = (2 * index) + 1;
    int current = index;

    if (leftChild < size && violatesProperty(leftChild, current)) {
      current = leftChild;
    }

    if (rightChild < size && violatesProperty(rightChild, current)) {
      current = rightChild;
    }

    if (index != current) {
      swapElements(index, current);
      heapify(current);
    }
  }

  protected boolean violatesProperty(int childIndex, int parentIndex) {
    int compare = compare(heapArr[childIndex], heapArr[parentIndex]);
    if (type == HeapType.MIN_HEAP) {
      return compare < 0;
    } else if (type == HeapType.MAX_HEAP) {
      return compare > 0;
    }

    return false;
  }

  protected int compare(T data, T o) {
    if (o instanceof Integer) {
      return ((Integer) data).compareTo((Integer) o);
    } else if (o instanceof Float) {
      return ((Float) data).compareTo((Float) o);
    } else if (o instanceof Double) {
      return ((Double) data).compareTo((Double) o);
    } else if (o instanceof Character) {
      return ((Character) data).compareTo((Character) o);
    } else if (o instanceof String) {
      return ((String) data).compareTo((String) o);
    }
    return -1;
  }

  protected void swapElements(int i, int j) {
    T temp = heapArr[i];
    heapArr[i] = heapArr[j];
    heapArr[j] = temp;
  }

  @SuppressWarnings("unchecked")
  private void growHeap() {
    T[] newHeap = (T[]) new Object[heapCapacity * 2];
    System.arraycopy(heapArr, 1, newHeap, 1, size());
    heapArr = newHeap;
    heapCapacity = heapArr.length;
  }
}
