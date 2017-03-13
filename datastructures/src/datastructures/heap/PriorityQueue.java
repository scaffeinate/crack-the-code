package datastructures.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * PriorityQueue Implementation using BinaryHeap. PriorityQueue is nothing but a
 * BinaryHeap but stores a value at the key(priority), which is used to
 * construct the heap.
 * 
 * @extends BinaryHeap
 * 
 * @param <P>
 * @param <V>
 * 
 * @author Sudharsanan Muralidharan
 */
public class PriorityQueue<P, V> extends BinaryHeap<PriorityQueueElement<P, V>> {

  private Map<V, PriorityQueueElement<P, V>> elementsMap = null;

  /**
   * InitialCapacity is not set since it's -1.
   * 
   * @param type
   */
  public PriorityQueue(HeapType type) {
    this(-1, type);
  }

  /**
   * Set initialCapacity of the BinaryHeap
   * 
   * @param initialCapacity
   * @param type
   */
  public PriorityQueue(int initialCapacity, HeapType type) {
    super(PriorityQueueElement.class, initialCapacity, type);
    elementsMap = new HashMap<V, PriorityQueueElement<P, V>>();
  }

  /**
   * Inserts a new element into the PriorityQueue given the priority and value.
   * 
   * @param priority
   * @param val
   */
  public void insert(P priority, V val) {
    PriorityQueueElement<P, V> element = new PriorityQueueElement<P, V>(priority, val);
    elementsMap.put(val, element);
    super.insert(element);
  }

  /**
   * Increases the priority of the element at the index. Check if the index is
   * valid and existing priority is not greater than the specified. Otherwise
   * change the priority of the element and bubble up to find the appropriate
   * index.
   * 
   * @param index
   * @param priority
   */
  public boolean increaseKey(V val, P priority) {
    PriorityQueueElement<P, V> element = elementsMap.get(val);
    if (element == null) {
      return false;
    } else {
      if (type == HeapType.MAX_HEAP && comparePriority(priority, element.priority) <= 0) {
        return false;
      } else {
        element.priority = priority;
        int current = indexesMap.get(element);
        int parent = (current / 2);
        while (parent > 0 && violatesProperty(current, parent)) {
          swapElements(current, parent);
          current = parent;
          parent = (current / 2);
        }

        return true;
      }
    }
  }

  /**
   * Decreases the priority of the element at the index. Check if the index is
   * valid and existing priority is not lesser than the specified. Otherwise
   * change the priority of the element and bubble up to find the appropriate
   * index.
   * 
   * @param index
   * @param priority
   */
  public boolean decreaseKey(V val, P priority) {
    PriorityQueueElement<P, V> element = elementsMap.get(val);
    if (element == null) {
      return false;
    } else {
      if (type == HeapType.MIN_HEAP && comparePriority(priority, element.priority) >= 0) {
        return false;
      } else {
        element.priority = priority;
        int current = indexesMap.get(element);
        int parent = (current / 2);
        while (parent > 0 && violatesProperty(current, parent)) {
          swapElements(current, parent);
          current = parent;
          parent = (current / 2);
        }

        return true;
      }
    }
  }

  @Override
  public void print() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Priority Queue: Size=").append("[").append(this.size()).append("]\n");
    for (int i = 1; i < size; i++) {
      builder.append(i + "::" + heapArr[i].toString()).append("\n");
    }
    return builder.toString();
  }

  /*
   * Override super.compare() to compare the priority of the
   * PriorityQueueElement rather than the actual object.
   * 
   * (non-Javadoc)
   * 
   * @see datastructures.heap.BinaryHeap#compare(java.lang.Object,
   * java.lang.Object)
   */
  @Override
  protected int compare(PriorityQueueElement<P, V> data, PriorityQueueElement<P, V> o) {
    return comparePriority(data.priority, o.priority);
  }

  @Override
  public PriorityQueueElement<P, V> extract() {
    PriorityQueueElement<P, V> element = super.extract();
    elementsMap.remove(element.getValue());
    return element;
  }

  public boolean contains(V val) {
    return elementsMap.containsKey(val) && indexesMap.containsKey(elementsMap.get(val));
  }
  
  public V extractValue() {
    return extract().getValue();
  }

  /**
   * Compare the priority(key) of two elements
   * 
   * @param priority
   * @param priority2
   * @return
   */
  private int comparePriority(P priority, P priority2) {
    if (priority2 instanceof Integer) {
      return ((Integer) priority).compareTo((Integer) priority2);
    } else if (priority2 instanceof Float) {
      return ((Float) priority).compareTo((Float) priority2);
    } else if (priority2 instanceof Double) {
      return ((Double) priority).compareTo((Double) priority2);
    } else if (priority2 instanceof Character) {
      return ((Character) priority).compareTo((Character) priority2);
    } else if (priority2 instanceof String) {
      return ((String) priority).compareTo((String) priority2);
    }

    return -1;
  }
}
