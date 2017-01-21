package datastructures.heap;

public class BinaryMinHeap<T> extends BinaryHeap<T> {

  public BinaryMinHeap(Class<?> clazz) {
    this(clazz, -1);
  }
  
  public BinaryMinHeap(Class<?> clazz, int initialCapacity) {
    super(clazz, initialCapacity, HeapType.MIN_HEAP);
  }
}