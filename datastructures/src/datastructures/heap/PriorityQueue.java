package datastructures.heap;

public class PriorityQueue<P, V> extends BinaryHeap<PriorityQueueElement<P, V>> {

  public PriorityQueue(HeapType type) {
    super(-1, type);
  }

  public PriorityQueue(int initialCapacity, HeapType type) {
    super(initialCapacity, type);
  }

  public void insert(P priority, V val) {
    PriorityQueueElement<P, V> element = new PriorityQueueElement<P, V>(priority, val);
    super.insert(element);
  }

  public void increaseKey(int index, P priority) {
    PriorityQueueElement<P, V> element = heapArr[index];
    if (element == null) {
      System.out.println("Invalid index");
    } else {
      if (comparePriority(priority, element.priority) < 0) {
        System.out.println("Priority is not increased.");
      } else {
        element.priority = priority;
        int current = index;
        int parent = (current / 2);
        while (parent > 0 && violatesProperty(current, parent)) {
          swapElements(current, parent);
          current = parent;
          parent = (current / 2);
        }
      }
    }
  }

  @Override
  protected int compare(PriorityQueueElement<P, V> data, PriorityQueueElement<P, V> o) {
    return comparePriority(data.priority, o.priority);
  }

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
