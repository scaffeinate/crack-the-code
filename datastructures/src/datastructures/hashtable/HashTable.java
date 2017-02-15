package datastructures.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Question 7.12: Design and Implement a hash table which uses chaining (linked
 * lists) to handle collisions.
 * 
 * HashTable implementation
 * 
 * @param <K>
 * @param <V>
 * 
 * @author Sudharsanan Muralidharan
 */
public class HashTable<K, V> {
  // Set Initial Array Capacity to 32
  private final int INITIAL_CAPACITY = 32;
  // If loadFactor() reaches THRESHOLD the grow hashArray
  private final double THRESHOLD = 0.75;

  /*
   * currentCapacity initially set to INITIAL_CAPACITY Doubles once loadFactor()
   * reaches THRESHOLD
   */
  private int currentCapacity = INITIAL_CAPACITY;
  private int size = 0;

  private HashTableNode<K, V>[] hashArray;
  private Set<HashTableNode<K, V>> entrySet;
  private Set<K> keySet;

  /**
   * Initialize the hashArray, entrySet and keySet
   */
  @SuppressWarnings("unchecked")
  public HashTable() {
    hashArray = new HashTableNode[INITIAL_CAPACITY];
    entrySet = new HashSet<HashTableNode<K, V>>();
    keySet = new HashSet<K>();
  }

  /**
   * Add new <K,V> into the HashTable. Hashes the key to compute the hashArray
   * index
   * 
   * @param key
   * @param value
   */
  public void put(K key, V value) {
    int index = hash(key);
    HashTableNode<K, V> head = hashArray[index];
    hashArray[index] = add(head, key, value);

    // If loadFactor() > THRESHOLD then grow the hashArray
    if (loadFactor() > THRESHOLD) {
      expand();
    }
  }

  /**
   * Get the value stored at key. Compute the hash of the key and find it in the
   * hashArray. If present then return value.
   * 
   * @param key
   * @return value
   */
  public V get(K key) {
    int index = hash(key);
    HashTableNode<K, V> node = find(hashArray[index], key);
    return (node != null) ? node.value : null;
  }

  /**
   * Remove the key from hashArray. The new value added using put() is added to
   * head of the LinkedList. hashArray[index] stores the head of the LinkedList.
   * So set hashArray[index] = head.next if key is at hashArray[index] otherwise
   * find and delete in the LinkedList.
   * 
   * @param key
   */
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

  /**
   * Check if the HashTable contains key. Compute the hash of the key and find
   * it in the LinkedList at hashArray[index]. If found return return otherwise
   * false.
   * 
   * @param key
   * @return contains
   */
  public boolean containsKey(K key) {
    int index = hash(key);
    if (hashArray[index] == null) {
      return false;
    } else {
      return find(hashArray[index], key) != null;
    }
  }

  /**
   * Returns size of the HashTable
   * 
   * @return size
   */
  public int size() {
    return this.size;
  }

  /**
   * Return set of entries HashTableNode<K,V>
   * 
   * @return entrySet
   */
  public Set<HashTableNode<K, V>> entrySet() {
    return this.entrySet;
  }

  /**
   * Return set of keys in the HashTable
   * 
   * @return keySet
   */
  public Set<K> keySet() {
    return this.keySet;
  }

  /**
   * Prints the HashTable
   */
  public void print() {
    System.out.print("[ ");
    for (HashTableNode<K, V> entry : this.entrySet()) {
      System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
    }
    System.out.print("]\n");
  }

  /**
   * Delete k from the LinkedList that starts at head. Also remove the entry
   * from entrySet and key from keySet. Decrement size.
   * 
   * @param head
   * @param key
   */
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

  /**
   * Adds a particular <K,V> pair to the head of LinkedList. Add entry to
   * entrySet and key to keySet. Increment size.
   * 
   * @param head
   * @param key
   * @param value
   * @return head
   */
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

  /**
   * Finds a key in the LinkedList
   * 
   * @param head
   * @param key
   * @return node
   */
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

  /**
   * Compute hash for the key. NOTE: Math.abs is required since the hashCode()
   * of the key can negative.
   * 
   * @param key
   * @return hash
   */
  private int hash(K key) {
    return Math.abs((key.hashCode() % currentCapacity));
  }

  /**
   * Compute loadFactor (size/currentCapacity). When the number of keys in the
   * hashArray gets filled and reaches currentCapacity then grow HashTable.
   * 
   * @return loadFactor
   */
  private double loadFactor() {
    return (size / currentCapacity);
  }

  /**
   * Grow the HashTable to double it's currentCapacity
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private void expand() {
    currentCapacity = (currentCapacity * 2);
    HashTableNode[] newArray = new HashTableNode[currentCapacity];
    System.arraycopy(hashArray, 0, newArray, 0, size);
    hashArray = newArray;
  }
}
