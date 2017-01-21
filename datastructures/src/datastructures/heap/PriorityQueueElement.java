package datastructures.heap;

public class PriorityQueueElement<P, V> {
  P priority;
  V value;

  public PriorityQueueElement() {
  }

  public PriorityQueueElement(P priority, V value) {
    this.priority = priority;
    this.value = value;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(priority).append(":").append(value);
    return builder.toString();
  }

}
