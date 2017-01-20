package datastructures.tree;

public class BinaryMinHeap<T> {
	private final int INITIAL_CAPACITY = 32 + 1;
	private T[] heapArr;
	private int insertAt = 1;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public BinaryMinHeap() {
		heapArr = (T[]) new Object[INITIAL_CAPACITY];
	}

	public void insert(T data) {
		heapArr[insertAt] = data;
		if (insertAt != 1) {
			int index = insertAt;
			int parentIndex = (index / 2);
			while ((compare(heapArr[index], heapArr[parentIndex]) < 0) && parentIndex > 0) {
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

	public T min() {
		if (size > 1) {
			return heapArr[1];
		}

		return null;
	}

	public T extractMin() {
		T data = heapArr[1];
		heapArr[1] = heapArr[insertAt - 1];
		heapArr[insertAt - 1] = null;
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

		if (leftIndex < size && (compare(heapArr[leftIndex], heapArr[smallestIndex]) < 0)) {
			smallestIndex = leftIndex;
		}

		if (rightIndex < size && (compare(heapArr[rightIndex], heapArr[smallestIndex]) < 0)) {
			smallestIndex = rightIndex;
		}

		if (i != smallestIndex) {
			T temp = heapArr[smallestIndex];
			heapArr[smallestIndex] = heapArr[i];
			heapArr[i] = temp;

			minHeapify(smallestIndex);
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
