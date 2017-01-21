package datastructures.heap;

public abstract class BinaryHeap<T> {
  private final int INITIAL_CAPACITY = 32;

  public enum HeapType {
    MIN_HEAP, MAX_HEAP
  }

  protected HeapType type;
  protected T[] heapArr;
  protected int insertAt = 1;

  @SuppressWarnings("unchecked")
  public BinaryHeap(HeapType type) {
    heapArr = (T[]) new Object[INITIAL_CAPACITY];
    this.type = type;
  }

  public void insert(T data) {
    heapArr[insertAt] = data;
    if (insertAt != 1) {
      int current = insertAt;
      int parent = (current / 2);
      while (parent > 0) {
        if (violatesProperty(current, parent) && current > 0) {
          swapElements(current, parent);
          current = parent;
          parent = (current / 2);
        } else {
          break;
        }
      }
    }
    insertAt++;
  }

  public T extract() {
    T data = heapArr[1];
    heapArr[1] = heapArr[insertAt - 1];
    heapArr[insertAt - 1] = null;
    insertAt--;
    heapify(1);
    return data;
  }

  public T head() {
    return heapArr[1];
  }

  public int size() {
    return (this.insertAt - 1);
  }

  public void print() {
    System.out.println("Heap: " + this.toString());
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[ ");
    for (int i = 1; i < insertAt; i++) {
      builder.append(heapArr[i]).append(" ");
    }

    builder.append("]");
    return builder.toString();
  }

  private void heapify(int index) {
    int leftChild = 2 * index;
    int rightChild = (2 * index) + 1;
    int current = index;
    
    if (leftChild < insertAt && violatesProperty(leftChild, current)) {
      current = leftChild;
    }

    if (rightChild < insertAt && violatesProperty(rightChild, current)) {
      current = rightChild;
    }

    if (index != current) {
      swapElements(index, current);
      heapify(current);
    }
  }

  private boolean violatesProperty(int childIndex, int parentIndex) {
    int compare = compare(heapArr[childIndex], heapArr[parentIndex]);
    if(type == HeapType.MIN_HEAP) {
      return compare < 0;
    } else if(type == HeapType.MAX_HEAP) {
      return compare > 0;
    }
    
    return false;
  }

  private int compare(T data, T o) {
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

  private void swapElements(int i, int j) {
    T temp = heapArr[i];
    heapArr[i] = heapArr[j];
    heapArr[j] = temp;
  }
}
