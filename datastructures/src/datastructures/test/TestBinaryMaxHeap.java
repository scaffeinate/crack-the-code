package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.heap.BinaryHeap;
import datastructures.heap.BinaryMaxHeap;
import datastructures.util.InputUtil;

public class TestBinaryMaxHeap {
  
  BinaryHeap<Integer> binaryMaxHeap;
  
  public TestBinaryMaxHeap() {
    binaryMaxHeap = new BinaryMaxHeap<Integer>();
  }
  
  private void buildMaxHeap(String[] input) {
    binaryMaxHeap = new BinaryMaxHeap<Integer>();
    for (String line : input) {
      if (line.startsWith("insert")) {
        String[] values = line.split(" ")[1].split(":");
        if(values.length == 1) {
          System.out.println("Inserting " + values[0] + " into Max Heap");
        } else {
          System.out.println("Inserting bunch of values into Max Heap");
        }
        for (String value : values) {
          binaryMaxHeap.insert(Integer.parseInt(value));
        }
      } else if (line.startsWith("buildHeap")) {
        String[] values = line.split(" ")[1].split(":");
        System.out.println("Building a MaxHeap from Unsorted Array");
        Integer[] arr = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
        binaryMaxHeap.buildHeap(arr);
      } else if (line.startsWith("head")) {
        System.out.println("Maximum from Heap: " + binaryMaxHeap.head());
      } else if (line.startsWith("extract")) {
        int size = binaryMaxHeap.size();
        System.out.println("Extract Max From Heap for n times: ");
        for (int i = 0; i < size; i++) {
          System.out.print(binaryMaxHeap.extract() + " ");
        }
        System.out.println("\n");
      } else if(line.startsWith("print")) {
        binaryMaxHeap.print();
      }
    }
  }
  
	public static void main(String[] args) throws FileNotFoundException {
	  TestBinaryMaxHeap testBinaryMaxHeap = new TestBinaryMaxHeap();
    String[] input = InputUtil.readContents("test_binary_heap");
    testBinaryMaxHeap.buildMaxHeap(input);
	}
}
