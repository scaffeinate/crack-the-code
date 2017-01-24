package datastructures.test;

import java.io.FileNotFoundException;
import java.util.Set;

import datastructures.hashtable.HashTable;
import datastructures.util.InputUtil;

public class TestHashTable {
  public static void main(String[] args) throws FileNotFoundException {
    HashTable<String, String> hashTable = new HashTable<String, String>();
    String[] input = InputUtil.readContents("test_hash_table");
    for (String line : input) {
      String[] values = line.split(" ");
      String action = values[0];

      switch (action) {
      case "put":
        System.out.println("Inserting key: " + values[1] + " => " + values[2]);
        hashTable.put(values[1], values[2]);
        break;
      case "get":
        System.out.println("Value at key: " + values[1] + " => " + hashTable.get(values[1]));
        break;
      case "print":
        System.out.print("HashTable: ");
        hashTable.print();
        break;
      case "size":
        System.out.println("Size of HashTable: " + hashTable.size());
        break;
      case "keys":
        Set<String> keys = hashTable.keySet();
        System.out.print("Keys: { ");
        for (String key : keys) {
          System.out.print(key + " ");
        }
        System.out.println("}");
        break;
      case "remove":
        System.out.println("Removing key: " + values[1]);
        hashTable.remove(values[1]);
        break;
      }
    }
  }
}
