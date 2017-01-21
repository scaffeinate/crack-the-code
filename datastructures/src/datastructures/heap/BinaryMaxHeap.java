package datastructures.heap;

public class BinaryMaxHeap<T> extends BinaryHeap<T> {

  public BinaryMaxHeap(Class<?> clazz) {
    this(clazz, -1);
  }
  
  public BinaryMaxHeap(Class<?> clazz, int initialCapacity) {
    super(clazz, initialCapacity, HeapType.MAX_HEAP);
  }
}
