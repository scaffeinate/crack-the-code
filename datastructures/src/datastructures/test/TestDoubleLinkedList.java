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
    
    System.out.println(list.remove(4));
    
    list.addToFront(10);
    list.add(11, 0);
    list.add(15, 4);
    list.add(12, 2);
    
    list.print();
    list.printReverse();
  }
}
