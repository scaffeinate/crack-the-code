package datastructures.test;

import datastructures.heap.BinaryHeap;
import datastructures.heap.BinaryMinHeap;
import datastructures.heap.BinaryHeap.HeapType;

public class TestBinaryMinHeap {
  public static void main(String[] args) {
    BinaryHeap<Integer> binaryMinHeap = new BinaryMinHeap<Integer>(HeapType.MIN_HEAP);
    binaryMinHeap.insert(2);
    binaryMinHeap.insert(5);
    binaryMinHeap.insert(10);
    binaryMinHeap.insert(1);
    binaryMinHeap.insert(7);
    binaryMinHeap.insert(7);
    binaryMinHeap.insert(0);
    binaryMinHeap.insert(3);
    binaryMinHeap.insert(4);
    binaryMinHeap.insert(5);
    binaryMinHeap.insert(8);
    binaryMinHeap.insert(12);
    int size = binaryMinHeap.size();
    
    binaryMinHeap.print();
    
    System.out.println("Extracting Min from Binary Heap");
    
    for(int i=0;i<size;i++) {
      System.out.print(binaryMinHeap.extract() + " ");
    }
  }
}
