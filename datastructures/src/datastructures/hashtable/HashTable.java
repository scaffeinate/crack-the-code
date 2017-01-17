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
    
    if(hashArray[index] == null) {
      hashArray[index] = new HashTableNode<K, V>(key, value);
    } else {
      HashTableNode<K, V> head = hashArray[index];
      hashArray[index] = addToLinkedList(head, key, value);
    }
  }

  public V get(K key) {
     int index = hash(key);
     return find(key, hashArray[index]);
  }
  
  private HashTableNode<K, V> addToLinkedList(HashTableNode<K, V> head, K key, V value) {
    HashTableNode<K, V> current = head;
    while(current != null) {
      if(current.key.equals(key)) {
        current.value = value;
        return head;
      }
      current = current.next;
    }
    
    HashTableNode<K, V> node = new HashTableNode<K, V>(key, value);
    node.next = head;
    return node;
  }
  
  private V find(K key, HashTableNode<K, V> head) {
    HashTableNode<K, V> current = head;
    while (current != null) {
      if (current.key.equals(key)) {
        return current.value;
      }
      
      current = current.next;
    }

    return null;
  }
  
  private int hash(K key) {
    return (key.hashCode() % hashSize);
  }
}
