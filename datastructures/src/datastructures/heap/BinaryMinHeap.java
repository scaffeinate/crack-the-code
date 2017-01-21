package datastructures.heap;

public class BinaryMinHeap<T> extends BinaryHeap<T> {

  public BinaryMinHeap() {
    this(-1);
  }
  
  public BinaryMinHeap(int initialCapacity) {
    super(initialCapacity, HeapType.MIN_HEAP);
  }
}