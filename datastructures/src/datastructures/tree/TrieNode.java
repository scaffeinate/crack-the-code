package datastructures.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}
