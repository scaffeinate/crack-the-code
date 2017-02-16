package datastructures.heap;

/**
 * Binary MaxHeap implementation.
 *
 * @extends BinaryHeap<T>
 * 
 * @param <T>
 * 
 * @author Sudharsanan Muralidharan
 */
public class BinaryMaxHeap<T> extends BinaryHeap<T> {

  /**
   * Use clazz to create heapArray of type clazz. InitialCapacity is not set so
   * pass -1.
   * 
   * @param clazz
   */
  public BinaryMaxHeap(Class<?> clazz) {
    this(clazz, -1);
  }

  /**
   * Use clazz to create heapArray. Set initialCapacity of the heap.
   * 
   * @param clazz
   * @param initialCapacity
   */
  public BinaryMaxHeap(Class<?> clazz, int initialCapacity) {
    super(clazz, initialCapacity, HeapType.MAX_HEAP);
  }
}
