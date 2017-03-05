/**
 * 
 */
package datastructures.disjointsets;

/**
 * @author Sudharsanan Muralidharan
 */
public class DisjointSet<T> {

  public SetElement<T> makeSet(T data) {
    SetList<T> setList = new SetList<T>();
    return setList.insert(data);
  }

  public void union(SetElement<T> setElement1, SetElement<T> setElement2) {
    if (setElement1.listRef.equals(setElement2.listRef)) {
      return;
    }

    if (setElement1.listRef.size >= setElement2.listRef.size) {
      setElement1.listRef.append(setElement2.listRef);
    } else {
      setElement2.listRef.append(setElement1.listRef);
    }
  }

  public SetElement<T> findSet(SetElement<T> setElement) {
    if (setElement == null || setElement.listRef == null) {
      return null;
    }
    
    return setElement.listRef.head;
  }

  public class SetList<T> {
    SetElement<T> head = null;
    SetElement<T> tail = null;
    int size = 0;

    public SetElement<T> insert(T data) {
      SetElement<T> setElement = new SetElement<T>(data);
      head = tail = setElement;
      setElement.listRef = this;
      this.size++;
      return setElement;
    }

    public void append(SetList<T> set) {
      this.tail.next = set.head;
      this.tail = set.tail;
      SetElement<T> current = set.head;
      while (current != null) {
        current.listRef = this;
        current = current.next;
      }

      this.size += set.size;
    }
  }

  public class SetElement<T> {
    public T data;
    SetElement<T> next = null;
    SetList<T> listRef = null;

    public SetElement(T data) {
      this(data, null);
    }

    public SetElement(T data, SetList<T> listRef) {
      this.data = data;
      this.listRef = listRef;
    }
  }
}
