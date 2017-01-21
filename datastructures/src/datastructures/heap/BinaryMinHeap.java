package datastructures.heap;

public class BinaryMinHeap<T> extends BinaryHeap<T> {

  public BinaryMinHeap(int initialCapacity, HeapType type) {
    super(initialCapacity, type);
  }

  public BinaryMinHeap(HeapType type) {
    super(-1, type);
  }
}