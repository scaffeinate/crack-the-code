package datastructures.heap;

/**
 * Binary MinHeap implementation.
 *
 * @param <T>
 * @author Sudharsanan Muralidharan
 * @extends BinaryHeap<T>
 */
public class BinaryMinHeap<T> extends BinaryHeap<T> {

    /**
     * Use clazz to create heapArray of type clazz. InitialCapacity is not set so
     * pass -1.
     *
     * @param clazz
     */
    public BinaryMinHeap(Class<?> clazz) {
        this(clazz, -1);
    }

    /**
     * Use clazz to create heapArray. Set initialCapacity of the heap.
     *
     * @param clazz
     * @param initialCapacity
     */
    public BinaryMinHeap(Class<?> clazz, int initialCapacity) {
        super(clazz, initialCapacity, HeapType.MIN_HEAP);
    }
}