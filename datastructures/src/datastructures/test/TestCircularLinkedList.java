package datastructures.test;

import datastructures.lists.CircularLinkedList;

public class TestCircularLinkedList {
  public static void main(String[] args) {
    CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    list.addToFront(15);
    list.add(12, 14);
    
    System.out.println(list.toString());
  }
}
