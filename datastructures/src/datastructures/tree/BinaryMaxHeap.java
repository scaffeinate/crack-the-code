package datastructures.tree;

public class BinaryMaxHeap<T> {
	private final int INITIAL_CAPACITY = 32 + 1;
	private T[] heapArr;
	private int size = 0;
	private int insertAt = 1;
	private int maxCapacity;

	@SuppressWarnings("unchecked")
	public BinaryMaxHeap() {
		maxCapacity = INITIAL_CAPACITY;
		heapArr = (T[]) new Object[maxCapacity];
	}

	public void insert(T data) {
		heapArr[insertAt] = data;
		if (insertAt != 1) {
			int index = insertAt;
			int parentIndex = (index / 2);
			while ((compare(heapArr[index], heapArr[parentIndex]) > 0) && parentIndex > 0) {
				T temp = heapArr[parentIndex];
				heapArr[parentIndex] = heapArr[index];
				heapArr[index] = temp;

				index = parentIndex;
				parentIndex = (index / 2);
			}
		}
		insertAt++;
		size++;
	}

	public T max() {
		T data = heapArr[1];
		return data;
	}

	public T extractMax() {
		T data = heapArr[1];
		heapArr[1] = heapArr[insertAt - 1];
		heapArr[insertAt - 1] = null;
		maxHeapify(1);
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

	private void maxHeapify(int index) {
		int leftIndex = 2 * index;
		int rightIndex = (2 * index) + 1;
		int largestIndex = index;

		if (leftIndex < size && (compare(heapArr[leftIndex], heapArr[largestIndex]) > 0)) {
			largestIndex = leftIndex;
		}

		if (rightIndex < size && (compare(heapArr[rightIndex], heapArr[largestIndex]) > 0)) {
			largestIndex = rightIndex;
		}

		if (index != largestIndex) {
			T temp = heapArr[largestIndex];
			heapArr[largestIndex] = heapArr[index];
			heapArr[index] = temp;

			maxHeapify(largestIndex);
		}
	}

	private int compare(T data, T o) {
		if (o instanceof Integer) {
			return ((Integer) data).compareTo((Integer) o);
		} else if (o instanceof Float) {
			return ((Float) data).compareTo((Float) o);
		} else if (o instanceof Double) {
			return ((Double) data).compareTo((Double) o);
		} else if (o instanceof Character) {
			return ((Character) data).compareTo((Character) o);
		} else if (o instanceof String) {
			return ((String) data).compareTo((String) o);
		}

		return -1;
	}
}
