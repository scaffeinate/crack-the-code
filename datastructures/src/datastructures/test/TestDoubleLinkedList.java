package datastructures.test;

import datastructures.lists.DoubleLinkedList;

public class TestDoubleLinkedList {
  public static void main(String[] args) {
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    list.print();
    list.printReverse();
  }
}
