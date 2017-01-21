package datastructures.test;

import datastructures.heap.BinaryHeap;
import datastructures.heap.BinaryMaxHeap;
import datastructures.heap.BinaryHeap.HeapType;

public class TestBinaryMaxHeap {
	public static void main(String[] args) {
		BinaryHeap<Integer> binaryMaxHeap = new BinaryMaxHeap<Integer>(HeapType.MAX_HEAP);
		binaryMaxHeap.insert(2);
		binaryMaxHeap.insert(5);
		binaryMaxHeap.insert(10);
		binaryMaxHeap.insert(1);
		binaryMaxHeap.insert(7);
		binaryMaxHeap.insert(7);
		binaryMaxHeap.insert(0);
		binaryMaxHeap.insert(3);
		binaryMaxHeap.insert(4);
		binaryMaxHeap.insert(5);
		binaryMaxHeap.insert(8);
		binaryMaxHeap.insert(12);

		int size = binaryMaxHeap.size();

		binaryMaxHeap.print();

		System.out.println("\nExtracting Max from Binary Heap of Size: " + size);

		for (int i = 0; i < size; i++) {
			System.out.print(binaryMaxHeap.extract() + " ");
		}
	}
}
