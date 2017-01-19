package datastructures.lists;

public interface GenericList<T> {
  public boolean add(T e);

  public boolean add(int index, T element);

  public boolean remove(Object o);

  public T remove(int index);

  public T get(int index);

  public T set(int index, T element);

  public boolean contains(Object o);

  public LinkedListNode<T> head();

  public void head(LinkedListNode<T> node);

  public LinkedListNode<T> tail();

  public void tail(LinkedListNode<T> node);
  
  public Object[] toArray();

  public int size();

  public boolean isEmpty();
}
