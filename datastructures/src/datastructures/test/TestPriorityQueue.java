package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.heap.HeapType;
import datastructures.heap.PriorityQueue;
import datastructures.util.InputUtil;

public class TestPriorityQueue {
  
  PriorityQueue<Integer, String> priorityQueue; 
  
  public void buildMaxPriorityQueue(String[] input) {
    priorityQueue = new PriorityQueue<Integer, String>(HeapType.MAX_HEAP);
    for(String line:input) {
      if(line.startsWith("insert")) {
        String[] values = line.split(" ");
        priorityQueue.insert(Integer.parseInt(values[1]), values[2]);
      } else if(line.startsWith("peek")) {
        System.out.println("\nProcess with Max Priority => " + priorityQueue.peek());
      } else if(line.startsWith("increaseKey")) {
        String[] values = line.split(" ");
        System.out.print("\nIncreasing Priority for Process at: " + values[1] + " to " + values[2]);
        priorityQueue.increaseKey(Integer.parseInt(values[1]), Integer.parseInt(values[2]));
        System.out.println();
      } else if(line.startsWith("extractAll")) {
        int size = priorityQueue.size();
        System.out.println("\nExtracting All the processes in Priority Queue: [" + size + "]");
        System.out.print("[ ");
        for(int i=0;i<size;i++) {
          System.out.print(priorityQueue.extract() + " ");
        }
        System.out.println("]");
      } else if(line.startsWith("extract")) {
        System.out.println("\nExtracting Process with Max Priority => " + priorityQueue.extract());
      } else if(line.startsWith("print")) {
        System.out.println();
        priorityQueue.print();
      }
    }
  } 
  
  public void buildMinPriorityQueue(String[] input) {
    
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    TestPriorityQueue testPriorityQueue = new TestPriorityQueue();
    String[] input = InputUtil.readContents("test_max_priority_queue");
    testPriorityQueue.buildMaxPriorityQueue(input);
    
    input = InputUtil.readContents("test_min_priority_queue");
    testPriorityQueue.buildMinPriorityQueue(input);
  }
}
