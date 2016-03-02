package chapter_2;

public class RemoveDups {
  public static void main(String[] args) {
    CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    
    System.out.println(list.contains(2));
    
    System.out.println(list.remove(1));
    System.out.println(list.contains(2));
  }
}
