package datastructures.test;

import java.io.FileNotFoundException;

import datastructures.tree.Trie;
import datastructures.util.InputUtil;

public class TestTrie {
  public static void main(String[] args) throws FileNotFoundException {
    Trie trie = new Trie();
    String[] input = InputUtil.readContents("test_trie");

    for (String line : input) {
      String[] values = line.split(" ");
      if (line.startsWith("insert")) {
        for (int i = 1; i < values.length; i++) {
          System.out.println("Inserting word [" + values[i] + "]");
          trie.insert(values[i]);
        }
      } else if (line.startsWith("remove")) {
        if(trie.remove(values[1])) {
          System.out.println("Removed word [" + values[1] + "] from Trie ");
        }
      } else if (line.startsWith("prefixRemove")) {
        if(trie.removePrefix(values[1])) {
          System.out.println("Removed words with prefix [" + values[1] + "] from Trie ");
        }
      } else if (line.startsWith("search")) {
        System.out.println("Searching for [" + values[1] + "] in Trie => " + trie.matches(values[1]));
      } else if (line.startsWith("prefixSearch")) {
        System.out.println("Searching for words with prefix [" + values[1] + "] in Trie => " + trie.prefixMatches(values[1]));
      } else if (line.startsWith("print")) {
        trie.print();
      }
    }
  }
}
