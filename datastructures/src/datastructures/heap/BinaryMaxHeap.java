package datastructures.heap;

public class BinaryMaxHeap<T> extends BinaryHeap<T> {

  public BinaryMaxHeap(int initialCapacity, HeapType type) {
    super(initialCapacity, type);
  }

  public BinaryMaxHeap(HeapType type) {
    super(-1, type);
  }
}
