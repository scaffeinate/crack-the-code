package datastructures.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
  Map<Character, TrieNode> children;
  boolean end;
  
  public TrieNode() {
    this(false);
  }
  
  public TrieNode(boolean end) {
    this.end = end;
    children = new HashMap<Character, TrieNode>();
  }
}
