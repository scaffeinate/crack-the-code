package datastructures.tree;

public class BinaryMinHeap {
  private final int INITIAL_CAPACITY = 32 + 1;
  private int[] heapArr;
  private int insertAt = 1;
  private int size = 0;

  public BinaryMinHeap() {
    heapArr = new int[INITIAL_CAPACITY];
  }

  public void insert(int data) {
    heapArr[insertAt] = data;
    if (insertAt != 1) {
      int index = insertAt;
      int parentIndex = index / 2;
      while (heapArr[index] < heapArr[parentIndex]) {
        int temp = heapArr[parentIndex];
        heapArr[parentIndex] = heapArr[index];
        heapArr[index] = temp;

        index = parentIndex;
        parentIndex = index / 2;
      }
    }

    size++;
    insertAt++;
  }

  public int min() {
    if (size > 1) {
      return heapArr[1];
    }

    return -1;
  }

  public int extractMin() {
    int data = heapArr[1];
    heapArr[1] = heapArr[insertAt - 1];
    heapArr[insertAt - 1] = -1;
    minHeapify(1);
    insertAt--;
    size--;
    return data;
  }

  public void print() {
    for (int i = 1; i <= size; i++) {
      System.out.print(heapArr[i] + " ");
    }
  }
  
  public int size() {
    return this.size;
  }

  private void minHeapify(int i) {
    int leftIndex = 2 * i;
    int rightIndex = leftIndex + 1;
    int smallestIndex = i;
    
    if(leftIndex < size && heapArr[leftIndex] < heapArr[smallestIndex]) {
      smallestIndex = leftIndex;
    }
    
    if(rightIndex < size && heapArr[rightIndex] < heapArr[smallestIndex]) {
      smallestIndex = rightIndex;
    }
    
    if(i != smallestIndex) {
      int temp = heapArr[smallestIndex];
      heapArr[smallestIndex] = heapArr[i];
      heapArr[i] = temp;
      
      minHeapify(smallestIndex);
    }
  }
}
