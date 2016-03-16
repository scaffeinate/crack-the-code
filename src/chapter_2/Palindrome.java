package chapter_2;

import java.io.FileNotFoundException;
import java.util.Stack;

import chapter_2.list.CustomLinkedList;
import chapter_2.list.Node;
import util.InputUtil;

/**
 * Question 2.6: Implement a function to check if a linked list is a palindrome.
 * 
 * @author Sudharsanan Muralidharan
 *
 */
public class Palindrome {

  private boolean isPalindrome(CustomLinkedList<Character> list) {
    Node<Character> current = list.head();
    int i = 0;

    while (i < list.size() / 2) {
      current = current.next;
      i++;
    }
    
    Node<Character> runner = current.next;
    Node<Character> temp;
    
    while (runner != null && runner.next != null) {
      temp = runner.next;
      runner.next = current;
      current = runner;
      runner = temp;
    }
    
    Node<Character> head = list.head();
    
    if(head.data == runner.data) {
      head = head.next;
    } else {
      return false;
    }
    
    for (i = 0; i < (list.size() / 2)-1; i++) {
      if(head.data != current.data) {
        return false;
      }
      
      head = head.next;
      current = current.next;
    }

    return true;
  }
  
  private boolean isPalindrome2(CustomLinkedList<Character> list) {
    Node<Character> head = list.head();
    Node<Character> current = head;
    Stack<Character> stack = new Stack<Character>();
    
    for(int i=0;i<list.size()/2;i++) {
      current = current.next;
    }
    
    if(list.size() % 2 != 0) {
      current = current.next;
    }
    
    for(int i=0;i<list.size()/2;i++) {
      stack.push(current.data);
      current = current.next;
    }
    
    for(int i=0;i<list.size()/2;i++) {
      if(head.data != stack.pop()) {
        return false;
      }
      
      head = head.next;
    }
    
    return true;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Palindrome palindrome = new Palindrome();
    String[] input = InputUtil.readContents(2, "palindrome");
    CustomLinkedList<Character> list;

    for (String line : input) {
      line = line.toLowerCase();
      list = new CustomLinkedList<Character>();

      for (int i = 0; i < line.length(); i++) {
        list.add(line.charAt(i));
      }

      System.out.println("Input: " + line);
      System.out.println("Is it Palindrome? " + palindrome.isPalindrome2(list));
      System.out.println();
    }
  }
}
