/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sudharsanan Muralidharan
 */
public class LFUCache {

  class Node {
    int key, value;
    Node next = null, prev = null;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  class LFUNode {
    LRUCache lruCache = null;
    int frequency = 0;
    LFUNode next = null, prev = null;

    public LFUNode() {
    }

    public LFUNode(LRUCache lruCache) {
      this.lruCache = lruCache;
    }

    public void incrementFrequency() {
      frequency++;
    }
  }

  class LRUCache {
    private Map<Integer, Node> map = null;
    private Node head = null, tail = null;

    LRUCache() {
      map = new HashMap<Integer, Node>();
    }

    public Node get(int key) {
      return map.get(key);
    }

    public void put(Node node) {
      if (tail == null) {
        head = tail = node;
      } else {
        tail.next = node;
        node.prev = tail;
        tail = node;
      }
      map.put(node.key, node);
    }

    public void removeHead() {
      map.remove(head.key);
      head = head.next;
    }
  }

  private Map<Integer, Integer> itemFrequencyMap = null;
  private Map<Integer, LFUNode> frequencyMap = null;
  private int capacity = 0, size = 0;
  private LFUNode lfuHead = null;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    itemFrequencyMap = new HashMap<Integer, Integer>();
    frequencyMap = new HashMap<Integer, LFUNode>();
  }

  public int get(int key) {
    int frequency = itemFrequencyMap.get(key);
    LFUNode lfuNode = frequencyMap.get(frequency);
    if (lfuNode == null) {
      return -1;
    }

    Node node = lfuNode.lruCache.get(key);
    insertToLFUNode(node, frequency + 1);
    itemFrequencyMap.put(key, frequency + 1);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = new Node(key, value);
    LFUNode lfuNode = insertToLFUNode(node, 1);
    size++;

    if (size > capacity) {
      lfuHead.lruCache.removeHead();
      size--;
    }

    lfuHead = lfuNode;
    frequencyMap.put(1, lfuNode);
    itemFrequencyMap.put(key, 1);
  }

  private LFUNode insertToLFUNode(Node node, int frequency) {
    LFUNode lfuNode = frequencyMap.get(1);
    LRUCache lruCache = new LRUCache();
    if (lfuNode == null) {
      lfuNode = new LFUNode(lruCache);
    } else {
      lruCache = lfuNode.lruCache;
    }

    lruCache.put(node);
    return lfuNode;
  }

  public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    LFUCache cache = new LFUCache(2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1)); // returns 1
    cache.put(3, 3); // evicts key 2
    System.out.println(cache.get(2)); // returns -1 (not found)
    System.out.println(cache.get(3)); // returns 3.
    cache.put(4, 4); // evicts key 1.
    System.out.println(cache.get(1)); // returns -1 (not found)
    System.out.println(cache.get(3)); // returns 3
    System.out.println(cache.get(4)); // returns 4
    // in.close();
  }
}
