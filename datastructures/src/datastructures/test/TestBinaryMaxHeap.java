package datastructures.test;

import datastructures.tree.BinaryMaxHeap;

public class TestBinaryMaxHeap {
	public static void main(String[] args) {
		BinaryMaxHeap<Integer> binaryMaxHeap = new BinaryMaxHeap<Integer>();
		binaryMaxHeap.insert(2);
		binaryMaxHeap.insert(5);
		binaryMaxHeap.insert(10);
		binaryMaxHeap.insert(1);
		binaryMaxHeap.insert(7);

		binaryMaxHeap.insert(7);
		binaryMaxHeap.insert(11);
		binaryMaxHeap.insert(3);
		binaryMaxHeap.insert(4);
		binaryMaxHeap.insert(5);
		binaryMaxHeap.insert(8);
		binaryMaxHeap.insert(12);

		int size = binaryMaxHeap.size();

		binaryMaxHeap.print();

		System.out.println("\nExtracting Max from Binary Heap of Size: " + size);

		for (int i = 0; i < size; i++) {
			System.out.print(binaryMaxHeap.extractMax() + " ");
		}
	}
}
