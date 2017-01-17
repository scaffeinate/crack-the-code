package datastructures.hashtable;

import java.util.Arrays;

/**
 * Question 7.12: Design and Implement a hash table which uses chaining (linked
 * lists) to handle collisions.
 * 
 * @author Sudharsanan Muralidharan
 */
public class HashTable<K, V> {
  private HashTableNode<K, V>[] hashArray;
  private int hashSize = 32;
  private int size = 0;

  @SuppressWarnings("unchecked")
  public HashTable() {
    hashArray = (HashTableNode<K, V>[]) Arrays.copyOf(new Object[hashSize], hashSize, HashTableNode[].class);
  }

  public void put(K key, V value) {
    int index = hash(key);
    HashTableNode<K, V> head = hashArray[index];
    hashArray[index] = add(head, key, value);
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
      size--;
    } else {
      delete(node, key);
    }
  }

  public void delete(HashTableNode<K, V> head, K key) {
    HashTableNode<K, V> current = head;
    HashTableNode<K, V> runner = head.next;

    while (runner != null) {
      if (runner.key.equals(key)) {
        current.next = runner.next;
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
    return (key.hashCode() % hashSize);
  }
}
