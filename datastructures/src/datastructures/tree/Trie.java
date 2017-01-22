package datastructures.tree;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Trie {
  private TrieNode root = null;
  private int size = 0;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;

    for (Character c : word.toCharArray()) {
      TrieNode node = current.children.get(c);
      if (node == null) {
        node = new TrieNode();
        current.children.put(c, node);
      }
      current = node;
    }

    size++;
    current.children.put('*', new TrieNode());
  }

  public void insertRecurse(String word) {
    insertRecurse(this.root, word, 0);
    size++;
  }

  private void insertRecurse(TrieNode root, String word, int index) {
    if (index == word.length()) {
      root.children.put('*', new TrieNode());
      return;
    }

    TrieNode node = root.children.get(word.charAt(index));
    if (node == null) {
      node = new TrieNode();
      root.children.put(word.charAt(index), node);
    }
    insertRecurse(node, word, index + 1);
  }

  public boolean prefixMatches(String pattern) {
    TrieNode current = root;

    for (Character c : pattern.toCharArray()) {
      TrieNode node = current.children.get(c);
      if (node == null) {
        return false;
      } else {
        current = node;
      }
    }
    return true;
  }

  public boolean matches(String pattern) {
    TrieNode current = root;

    for (Character c : pattern.toCharArray()) {
      TrieNode node = current.children.get(c);
      if (node == null) {
        return false;
      } else {
        current = node;
      }
    }

    return current.children.containsKey('*');
  }

  public boolean remove(String word) {
    int prevSize = this.size;
    remove(this.root, word, 0);
    return (prevSize != size);
  }

  public boolean removePrefix(String prefix) {
    TrieNode current = root;
    TrieNode prev = null;
    char c = 0;

    for (int i = 0; i < prefix.length(); i++) {
      c = prefix.charAt(i);
      TrieNode node = current.children.get(c);
      if (node == null) {
        return false;
      }
      prev = current;
      current = node;
    }

    if (prev != null && prev.children.remove(c) != null) {
      size = size - countSubWords(current);
      return true;
    }

    return false;
  }

  private int countSubWords(TrieNode root) {
    Set<Entry<Character, TrieNode>> children = root.children.entrySet();
    int sum = 0;
    for (Entry<Character, TrieNode> child : children) {
      if (child.getKey() == '*') {
        sum += 1;
      } else {
        sum += countSubWords(child.getValue());
      }
    }

    return sum;
  }

  private boolean remove(TrieNode root, String word, int index) {
    if (index == word.length()) {
      if (root.children.remove('*') != null) {
        size--;
        return isLeafNode(root);
      }
    } else {
      Character c = word.charAt(index);
      TrieNode node = root.children.get(c);
      if (node != null) {
        boolean childDeleted = remove(node, word, index + 1);
        if (childDeleted) {
          root.children.remove(c);
        }
        return isLeafNode(root);
      }
    }

    return false;
  }

  private boolean isLeafNode(TrieNode node) {
    Map<Character, TrieNode> children = node.children;
    return children.isEmpty();
  }

  public void print() {
    System.out.println("\nPrinting Trie of size: " + size);
    traverse(root, new StringBuilder());
    System.out.println("\n");
  }

  public void traverse(TrieNode root, StringBuilder builder) {
    Set<Entry<Character, TrieNode>> children = root.children.entrySet();
    for (Entry<Character, TrieNode> entry : children) {
      if (entry.getKey() != '*') {
        builder.append(entry.getKey());
        traverse(entry.getValue(), builder);
        builder.setLength(builder.length() - 1);
      } else {
        System.out.print(builder.toString() + " ");
      }
    }
  }

  public TrieNode getRoot() {
    return this.root;
  }

  public int size() {
    return this.size;
  }
}
