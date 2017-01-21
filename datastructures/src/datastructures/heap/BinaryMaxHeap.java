package datastructures.heap;

public class BinaryMaxHeap<T> extends BinaryHeap<T> {

  public BinaryMaxHeap() {
    this(-1);
  }
  
  public BinaryMaxHeap(int initialCapacity) {
    super(initialCapacity, HeapType.MAX_HEAP);
  }
}
