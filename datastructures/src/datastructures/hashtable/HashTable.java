package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 7.12: Design and Implement a hash table which uses chaining (linked
 * lists) to handle collisions.
 * 
 * @author Sudharsanan Muralidharan
 */
public class HashTable<K, V> {
  private HashTableNode<K, V>[] hashArray;
  private final int INITIAL_CAPACITY = 32;
  private final double THRESHOLD = 0.75;
  
  private int currentCapacity = INITIAL_CAPACITY;
  private int size = 0;
  private Set<HashTableNode<K, V>> entrySet;
  private Set<K> keySet;

  @SuppressWarnings("unchecked")
  public HashTable() {
    hashArray = new HashTableNode[INITIAL_CAPACITY];
    entrySet = new HashSet<HashTableNode<K, V>>();
    keySet = new HashSet<K>();
  }

  public void put(K key, V value) {
    int index = hash(key);
    HashTableNode<K, V> head = hashArray[index];
    hashArray[index] = add(head, key, value);
    
    if(loadFactor() > THRESHOLD) {
      expand();
    }
  }

  public V get(K key) {
    int index = hash(key);
    HashTableNode<K, V> node = find(hashArray[index], key);
    return (node != null) ? node.value : null;
  }

  public void remove(K key) {
    int index = hash(key);
    HashTableNode<K, V> node = hashArray[index];
    if (node == null) {
      return;
    } else if (node.key.equals(key)) {
      hashArray[index] = node.next;
      entrySet.remove(node);
      keySet.remove(node.key);
      size--;
    } else {
      delete(node, key);
    }
  }

  public boolean containsKey(K key) {
    int index = hash(key);
    if(hashArray[index] == null) {
      return false;
    } else {
      return find(hashArray[index], key) != null;
    }
  }
  
  public int size() {
    return this.size;
  }
  
  public Set<HashTableNode<K, V>> entrySet() {
    return this.entrySet;
  }
  
  public Set<K> keySet() {
    return this.keySet;
  }
  
  private void delete(HashTableNode<K, V> head, K key) {
    HashTableNode<K, V> current = head;
    HashTableNode<K, V> runner = head.next;

    while (runner != null) {
      if (runner.key.equals(key)) {
        current.next = runner.next;
        entrySet.remove(runner);
        keySet.remove(runner.key);
        size--;
      }
      current = current.next;
      runner = runner.next;
    }
  }

  private HashTableNode<K, V> add(HashTableNode<K, V> head, K key, V value) {
    HashTableNode<K, V> node = find(head, key);
    if (node != null) {
      node.value = value;
    } else {
      node = new HashTableNode<K, V>(key, value);
      node.next = head;
      head = node;
      entrySet.add(node);
      keySet.add(key);
      size++;
    }
    return head;
  }

  private HashTableNode<K, V> find(HashTableNode<K, V> head, K key) {
    HashTableNode<K, V> current = head;
    while (current != null) {
      if (current.key.equals(key)) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  private int hash(K key) {
    return (key.hashCode() % currentCapacity);
  }
  
  private double loadFactor() {
    return (size/currentCapacity);
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private void expand() {
    currentCapacity = (currentCapacity * 2);
    HashTableNode[] newArray = new HashTableNode[currentCapacity];
    System.arraycopy(hashArray, 0, newArray, 0, size);
    hashArray = newArray;
  }
}
