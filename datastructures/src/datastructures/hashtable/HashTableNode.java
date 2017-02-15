package datastructures.hashtable;

/**
 * HashTableNode class which holds the Tuple K, V
 *
 * @param <K>
 * @param <V>
 * 
 * @author Sudharsanan Muralidharan
 */
public class HashTableNode<K, V> {
  K key;
  V value;;
  HashTableNode<K, V> next = null;

  public HashTableNode() {
  }

  public HashTableNode(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return this.key;
  }

  public V getValue() {
    return this.value;
  }

}
