package datastructures.lists;

public interface GenericList<T> {
  public boolean add(T e);

  public boolean addToFront(T e);

  public boolean remove(Object o);

  public T remove(int index);

  public T get(int index);

  public T set(int index, T element);

  public void add(int index, T element);

  public LinkedListNode<T> head();

  public void head(LinkedListNode<T> node);

  public void tail(LinkedListNode<T> node);

  public LinkedListNode<T> tail();

  public boolean contains(Object o);

  public int size();

  public boolean isEmpty();
}
