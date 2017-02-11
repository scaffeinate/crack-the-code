package algorithms.sort;

public abstract class Sort<T> {
  
  public abstract T[] sort(T[] arr);
  
  protected void swap(T[] arr, int i, int j) {
    T temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
  
  protected int compare(T a, T b) {
    if (a instanceof Integer && b instanceof Integer) {
      return ((Integer) a).compareTo((Integer) b);
    } else if (a instanceof Float) {
      return ((Float) a).compareTo((Float) b);
    } else if (a instanceof Double) {
      return ((Double) a).compareTo((Double) b);
    } else if (a instanceof Character) {
      return ((Character) a).compareTo((Character) b);
    } else if (a instanceof String) {
      return ((String) a).compareTo((String) b);
    }
    return -1;
  }
}
