package datastructures.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
  protected Map<T, Integer> indexesMap = null;
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
    indexesMap = new HashMap<T, Integer>();
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
      indexesMap.put(data, 1);
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

    indexesMap.put(data, current);
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

  /**
   * Extracts the min/max element in the heap based on heapType(root of the
   * heap). Remove root, replace with last leaf element then Heapify.
   * 
   * Complexity: O(lgn)
   * 
   * @return root
   */
  public T extract() {
    T data = heapArr[1];
    indexesMap.remove(heapArr[1]);
    indexesMap.put(heapArr[size()], 1);
    heapArr[1] = heapArr[size()];
    heapArr[size()] = null;
    size--;
    heapify(1);
    return data;
  }

  /**
   * Returns the root of the heap. This is the min/max in the heap based on
   * heapType.
   * 
   * Complexity: O(1)
   * 
   * @return root
   */
  public T peek() {
    return heapArr[1];
  }

  /**
   * Returns the size of the heap. Since we start from index=1 this returns
   * size-1
   * 
   * @return size
   */
  public int size() {
    return (this.size - 1);
  }

  /**
   * Perform HeapSort. BuildHeap using the arr. For sorting in ascending order
   * build a MAX_HEAP, Otherwise MIN_HEAP. Swap the root with the last leaf
   * element. Heapify(1). Continue this until we reach the root node. i.e n to
   * 2.
   * 
   * Complexity: O(nlgn)
   * 
   * @param arr
   */
  public T[] sort(T[] arr) {
    buildHeap(arr);
    int n = size();
    for (int i = n; i >= 2; i--) {
      swapElements(1, i);
      size--;
      heapify(1);
    }

    size = n;
    return Arrays.copyOfRange(heapArr, 1, heapArr.length);
  }

  /**
   * Prints the heapArr
   */
  public void print() {
    System.out.println("Heap: " + this.toString());
  }

  /*
   * @Override toString()
   * 
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
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

  /**
   * Returns if the BinaryHeap is empty
   * 
   * @return isEmpty
   */
  public boolean isEmpty() {
    return this.size() == 0;
  }

  /**
   * Perform Heapify from the specified index. Heapify checks the node at index
   * with it's children and if the heap property is violated then swap the node
   * with the most appropriate child element. i.e. In MIN_HEAP with the
   * smallest, MAX_HEAP largest of the three.
   * 
   * @param index
   */
  private void heapify(int index) {
    int leftChild = 2 * index;
    int rightChild = (2 * index) + 1;
    int current = index;

    /*
     * Check to see if leftChild index is within bounds and violatesProperty. If
     * it does update current index with leftChild.
     */
    if (leftChild < size && violatesProperty(leftChild, current)) {
      current = leftChild;
    }

    /*
     * Check to see if rightChild index is within bounds and violatesProperty.
     * If it does update the current with rightChild.
     */
    if (rightChild < size && violatesProperty(rightChild, current)) {
      current = rightChild;
    }

    /*
     * If we need a swap with any of the children then we continue piping down
     * the element. So swap and call heapify with the current index.
     */
    if (index != current) {
      swapElements(index, current);
      heapify(current);
    }
  }

  /**
   * Important function to check if heap property is in violation. Given the
   * child and parent indices check if to see the parent is greater than child
   * in a MAX_HEAP and lesser than child in MIN_HEAP.
   * 
   * @param childIndex
   * @param parentIndex
   * @return violates
   */
  protected boolean violatesProperty(int childIndex, int parentIndex) {
    int compare = compare(heapArr[childIndex], heapArr[parentIndex]);
    if (type == HeapType.MIN_HEAP) {
      return compare < 0;
    } else if (type == HeapType.MAX_HEAP) {
      return compare > 0;
    }

    return false;
  }

  /**
   * Compare T data, T o
   * 
   * @param data
   * @param o
   * @return compare
   */
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

  /**
   * Swap two elements at index i and index j
   * 
   * @param i
   * @param j
   */
  protected void swapElements(int i, int j) {
    T temp = heapArr[i];
    heapArr[i] = heapArr[j];
    heapArr[j] = temp;
    indexesMap.put(heapArr[i], i);
    indexesMap.put(heapArr[j], j);
  }

  /**
   * If the heap capacity is reached then growheap(). Double the size and copy
   * the heapArr to newHeap.
   */
  @SuppressWarnings("unchecked")
  private void growHeap() {
    T[] newHeap = (T[]) new Object[heapCapacity * 2];
    System.arraycopy(heapArr, 1, newHeap, 1, size());
    heapArr = newHeap;
    heapCapacity = heapArr.length;
  }
}
