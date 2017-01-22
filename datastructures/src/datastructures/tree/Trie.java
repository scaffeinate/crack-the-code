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
    current.children.put('*', new TrieNode(true));
  }

  public void insertRecurse(String word) {
    insertRecurse(this.root, word, 0);
    size++;
  }

  private void insertRecurse(TrieNode root, String word, int index) {
    if (index == word.length()) {
      root.children.put('*', new TrieNode(true));
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

    return (current.children.get('*') != null) && (current.children.get('*').end);
  }

  public boolean delete(String pattern) {
    return delete(this.root, pattern, 0);
  }

  private boolean delete(TrieNode root, String word, int index) {
    if (index == word.length()) {
      if (root.children.containsKey('*')) {
        root.children.remove('*');
        size--;
        return isLeafNode(root);
      }
    } else {
      Character c = word.charAt(index);
      TrieNode node = root.children.get(c);
      if (node != null) {
        boolean childDeleted = delete(node, word, index + 1);
        if(childDeleted) {
          root.children.remove(c);
        }
        return childDeleted && isLeafNode(root);
      }
    }

    return false;
  }

  private boolean isLeafNode(TrieNode node) {
    Map<Character, TrieNode> children = node.children;
    if (children.size() > 1) {
      return false;
    } else if (children.size() == 1) {
      TrieNode nullNode = children.get('*'); 
      return  (nullNode != null && !nullNode.end);
    }
    
    return true;
  }

  public void traverse(TrieNode root, StringBuilder builder) {
    Set<Entry<Character, TrieNode>> children = root.children.entrySet();
    for (Entry<Character, TrieNode> entry : children) {
      if (!entry.getValue().end) {
        builder.append(entry.getKey());
        traverse(entry.getValue(), builder);
        builder.setLength(builder.length() - 1);
      } else {
        System.out.println(builder.toString());
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
