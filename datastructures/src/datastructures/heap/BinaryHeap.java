package datastructures.heap;

public abstract class BinaryHeap<T> {
  private final int DEFAULT_INITIAL_CAPACITY = 32;
  private int heapCapacity;

  public enum HeapType {
    MIN_HEAP, MAX_HEAP
  }

  protected HeapType type;
  protected T[] heapArr;
  protected int size = 1;

  @SuppressWarnings("unchecked")
  public BinaryHeap(int initialCapacity, HeapType type) {
    heapCapacity = (initialCapacity == -1) ? DEFAULT_INITIAL_CAPACITY : initialCapacity;
    heapArr = (T[]) new Object[heapCapacity];
    this.type = type;
  }

  public void insert(T data) {
    if (size == heapCapacity) {
      growHeap();
    }

    heapArr[size] = data;
    if (size == 1) {
      size++;
      return;
    }

    int current = size;
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
    size++;
  }

  @SuppressWarnings("unchecked")
  public void buildHeap(T[] arr) {
    size = arr.length + 1;
    heapArr = (T[]) new Object[size];
    heapCapacity = size;
    System.arraycopy(arr, 0, heapArr, 1, size - 1);

    for (int i = size / 2; i >= 1; i--) {
      heapify(i);
    }
  }

  public T extract() {
    T data = heapArr[1];
    heapArr[1] = heapArr[size - 1];
    heapArr[size - 1] = null;
    size--;
    heapify(1);
    return data;
  }

  public T head() {
    return heapArr[1];
  }

  public int size() {
    return (this.size - 1);
  }

  public void sort(T[] arr) {
    buildHeap(arr);
    int n = this.size - 1;
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

  private boolean violatesProperty(int childIndex, int parentIndex) {
    int compare = compare(heapArr[childIndex], heapArr[parentIndex]);
    if (type == HeapType.MIN_HEAP) {
      return compare < 0;
    } else if (type == HeapType.MAX_HEAP) {
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

  @SuppressWarnings("unchecked")
  private void growHeap() {
    T[] newHeap = (T[]) new Object[heapCapacity * 2];
    System.arraycopy(heapArr, 1, newHeap, 1, size - 1);
    heapArr = newHeap;
    heapCapacity = heapArr.length;
  }
}
