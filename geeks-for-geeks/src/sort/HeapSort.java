package sort;

import datastructures.heap.BinaryMaxHeap;

/**
 * Question: http://www.geeksforgeeks.org/heap-sort/
 *
 * @param <T>
 */
public class HeapSort<T> extends Sort<T> {

    private BinaryMaxHeap<T> binaryMaxHeap = null;

    public HeapSort(Class<T> clazz) {
        binaryMaxHeap = new BinaryMaxHeap<T>(clazz);
    }

    @Override
    public T[] sort(T[] arr) {
        return binaryMaxHeap.sort(arr);
    }

}