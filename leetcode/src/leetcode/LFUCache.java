/**
 * 
 */
package leetcode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    @Override
    public String toString() {
      return "Node [key=" + key + ", value=" + value + "]";
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

    @Override
    public String toString() {
      return "LFUNode [lruCache=" + lruCache + "]";
    }
  }

  class LRUCache {
    private Map<Integer, Node> map = null;
    private Node head = null, tail = null;

    @Override
    public String toString() {
      return "LRUCache [map=" + map + "]";
    }

    LRUCache() {
      map = new HashMap<Integer, Node>();
    }

    public Node extract(int key) {
      Node node = map.get(key);
      if (head != null && tail != null) {
        if (head.equals(tail)) {
          head = tail = null;
        } else {
          removeNode(node);
        }
      }
      map.remove(key);
      return node;
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
      if (head != null) {
        map.remove(head.key);
        itemFrequencyMap.remove(head.key);
        head = head.next;
      }
    }

    private void removeNode(Node node) {
      if (node.equals(head)) {
        head = head.next;
        if (head != null) {
          head.prev = null;
        }
      } else if (node.equals(tail)) {
        tail = tail.prev;
        if (tail != null) {
          tail.next = null;
        }
      } else {
        node.next.prev = node.prev;
        node.prev.next = node.next;
      }
    }
  }

  private Map<Integer, Integer> itemFrequencyMap = null;
  private Map<Integer, LFUNode> frequencyMap = null;
  private int capacity = 0, size = 0;
  private LFUNode lfuHead = null, lfuTail = null;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    itemFrequencyMap = new HashMap<Integer, Integer>();
    frequencyMap = new HashMap<Integer, LFUNode>();
  }

  public int get(int key) {
    if (capacity == 0)
      return -1;
    Integer frequency = itemFrequencyMap.get(key);
    LFUNode lfuNode = frequencyMap.get(frequency);
    if (lfuNode == null) {
      return -1;
    }

    Node node = lfuNode.lruCache.extract(key);
    incrementFrequency(node, frequency);

    if (lfuNode.lruCache.map.isEmpty()) {
      frequencyMap.remove(frequency);
      if (lfuNode.equals(lfuHead)) {
        lfuHead = lfuHead.next;
        lfuHead.prev = null;
      } else if (lfuNode.equals(lfuTail)) {
        lfuTail = lfuTail.prev;
        lfuTail.next = null;
      } else {
        lfuNode.prev.next = lfuNode.next;
        lfuNode.next.prev = lfuNode.prev;
      }
    }

    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0)
      return;

    if (itemFrequencyMap.containsKey(key)) {
      int frequency = itemFrequencyMap.get(key);
      LFUNode lfuNode = frequencyMap.get(frequency);
      Node node = lfuNode.lruCache.extract(key);
      node.value = value;
      incrementFrequency(node, frequency);
    } else {
      Node node = new Node(key, value);
      LFUNode lfuNode = insertToLFUNode(node, 1);
      size++;

      if (size > capacity) {
        lfuHead.lruCache.removeHead();
        size--;
      }

      if (!lfuNode.equals(lfuHead)) {
        lfuNode.next = lfuHead;
        lfuHead.prev = lfuNode;
        lfuHead = lfuNode;
      }
      frequencyMap.put(1, lfuNode);
      itemFrequencyMap.put(key, 1);
    }
  }

  private LFUNode insertToLFUNode(Node node, int frequency) {
    LFUNode lfuNode = frequencyMap.get(frequency);
    LRUCache lruCache = new LRUCache();
    if (lfuNode == null) {
      lfuNode = new LFUNode(lruCache);
    } else {
      lruCache = lfuNode.lruCache;
    }

    if (lfuHead == null) {
      lfuHead = lfuTail = lfuNode;
    } else {
      lfuTail.next = lfuNode;
      lfuNode.prev = lfuTail;
      lfuTail = lfuNode;
    }

    lruCache.put(node);
    return lfuNode;
  }

  private void incrementFrequency(Node node, int frequency) {
    LFUNode lfuNode = insertToLFUNode(node, frequency + 1);
    frequencyMap.put(frequency + 1, lfuNode);
    itemFrequencyMap.put(node.key, frequency + 1);
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new FileReader("lfucache"));
    String[] commands, values;
    String input = in.nextLine();
    commands = input.substring(1, input.length() - 1).split(",");
    input = in.nextLine();
    values = input.substring(1, input.length() - 1).split("],");
    LFUCache cache = null;

    for (int i = 0; i < commands.length; i++) {
      String command = commands[i].replaceAll("\"", "");
      String value = values[i].replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
      switch (command) {
      case "LFUCache":
        cache = new LFUCache(Integer.parseInt(value));
        break;
      case "put":
        String[] valuesArr = value.split(",");
        cache.put(Integer.parseInt(valuesArr[0]), Integer.parseInt(valuesArr[1]));
        break;
      case "get":
        System.out.print(cache.get(Integer.parseInt(value)) + " ");
        break;
      }
    }
    in.close();
  }
}
