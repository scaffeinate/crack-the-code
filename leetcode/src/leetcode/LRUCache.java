/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * Problem: https://leetcode.com/problems/lru-cache
 * 
 * @author Sudharsanan Muralidharan
 */
public class LRUCache {
  class Node {
    int key, value;
    Node next = null;
    Node prev = null;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private HashMap<Integer, Node> map = null;
  private Node head = null;
  private Node tail = null;
  private int capacity = 0;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node == null) {
      return -1;
    }
    shiftToTail(node);
    return node.value;
  }
  
  private void shiftToTail(Node node) {
    if(!node.equals(tail)) {
      if(node.equals(head)) {
        head.next.prev = null;
        head = head.next;
      } else {
        node.next.prev = node.prev;
        node.prev.next = node.next;
      }
      
      addToTail(node);
    }
  }
  
  private void addToTail(Node node) {
      tail.next = node;
      node.prev = tail;
      node.next = null;
      tail = node;
  }
  
  public void put(int key, int value) {
    if(map.containsKey(key)) {
        Node node = map.get(key);
        node.value = value;
        shiftToTail(node);
    } else {
        Node node = new Node(key, value);
        map.put(key, node);
        if(tail == null) {
          head = tail = node;
        } else {
          addToTail(node);
        }
        
        if(map.size() > capacity) {
          map.remove(head.key);
          if(head.next != null) {
            head.next.prev = null;
          }
          head = head.next;
        }
    }
  }
}
