package chapter_3.stack_queue;

/**
 * abstract class Animal
 * 
 * @author Sudharsanan Muralidharan
 * 
 * @param <T>
 */
public abstract class Animal<T> {
  private T name;
  private int order;

  public Animal(T name) {
    this.name = name;
  }

  public T getName() {
    return name;
  }

  public void setName(T name) {
    this.name = name;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public boolean isOlderThan(Animal<T> animal) {
    return (this.order < animal.order);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Name: ").append(this.name).append(" Of Type: ").append(this.getClass().getSimpleName());
    builder.append(" Of Order: ").append(this.order);
    return builder.toString();
  }
}
