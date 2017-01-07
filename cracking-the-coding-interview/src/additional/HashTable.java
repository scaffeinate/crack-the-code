package additional;

import java.util.Arrays;

/**
 * Question 7.12: Design and Implement a hash table which uses chaining (linked
 * lists) to handle collisions.
 * 
 * @author Sudharsanan Muralidharan
 */
public class HashTable<K, V> {
  private Node<K, V>[] hashArray;
  private int hashSize = 32;

  @SuppressWarnings("unchecked")
  public HashTable() {
    hashArray = (Node<K, V>[]) Arrays.copyOf(new Object[hashSize], hashSize, Node[].class);
  }
  
  public void put(K key, V value) {
      // TODO implement
    int index = key.hashCode() % hashSize;
    Node<K, V> head;
    
    if(hashArray[index] == null) {
      hashArray[index] = add(key, value, null);
    } else {
      head = hashArray[index];
      add(key, value, head);
    }
  }

  public V get(K key) {
      // TODO implement
     int index = key.hashCode() % hashSize;
     return find(key, hashArray[index]);
  }
  
  private Node<K, V> add(K key, V value, Node<K, V> head) {
    // TODO Auto-generated method stub
    if (head == null) {
      head = new Node<K, V>();
      head.key = key;
      head.value = value;
      head.next = null;
    } else {
      Node<K, V> current = head;
      
      while(current.next != null) {
        current = current.next;
      }
      
      current.key = key;
      current.value = value;
      current.next = null;
    }

    return head;
  }
  
  private V find(K key, Node<K, V> head) {
    // TODO Auto-generated method stub
    Node<K, V> current = head;
    while (current != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      
      current = current.next;
    }

    return null;
  }
}
