package datastructures.heap;

/**
 * PriorityQueueElement class to hold the priority(key) and value
 *
 * @param <P>
 * @param <V>
 * 
 * @author Sudharsanan Muralidharan
 */
public class PriorityQueueElement<P, V> {
  protected P priority;
  protected V value;

  public PriorityQueueElement() {
  }

  public PriorityQueueElement(P priority, V value) {
    this.priority = priority;
    this.value = value;
  }

  public P getPriority() {
    return priority;
  }

  public void setPriority(P priority) {
    this.priority = priority;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(priority).append(":").append(value);
    return builder.toString();
  }

}
