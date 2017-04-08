package linked_list;

import datastructures.lists.CustomLinkedList;
import datastructures.lists.LinkedListNode;

public class AddPolynomialsLinkedList {

  private CustomLinkedList<Variable> linkedList = null;
  private CustomLinkedList<Variable> linkedList2 = null;

  public void constructLinkedList(String input, String input2) {
    linkedList = new CustomLinkedList<Variable>();
    linkedList2 = new CustomLinkedList<Variable>();
    String[] elements = input.split("\\+");
    String[] elements2 = input2.split("\\+");

    for (String e : elements) {
      if (e != null && !e.trim().isEmpty()) {
        String[] values = e.trim().split("x\\^");
        linkedList.add(new Variable(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
      }
    }

    for (String e : elements2) {
      if (e != null && !e.trim().isEmpty()) {
        String[] values = e.trim().split("x\\^");
        linkedList2.add(new Variable(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
      }
    }
  }

  public String addPolynomials() {
    StringBuilder builder = new StringBuilder();
    LinkedListNode<Variable> current = linkedList.head();
    LinkedListNode<Variable> current2 = linkedList2.head();

    while (current != null && current2 != null) {
      if (current.data.power == current2.data.power) {
        builder.append(current.data.coefficient + current2.data.coefficient).append("x^").append(current.data.power)
            .append(" + ");
        current = current.next;
        current2 = current2.next;
      } else if (current.data.power > current2.data.power) {
        builder.append(current.data.getVariableString());
        current = current.next;
      } else {
        builder.append(current2.data.getVariableString());
        current2 = current2.next;
      }
    }
    
    while(current != null) {
      builder.append(current.data.getVariableString());
      current = current.next;
    }
    
    while(current2 != null) {
      builder.append(current2.data.getVariableString());
      current2 = current2.next;
    }

    return builder.toString().substring(0, builder.length() - 3);
  }

  class Variable {
    private int coefficient = 0;
    private int power = 0;

    public Variable(int coefficent, int power) {
      this.coefficient = coefficent;
      this.power = power;
    }
    
    public String getVariableString() {
      StringBuilder builder = new StringBuilder();
      builder.append(coefficient).append("x^").append(power).append(" + ");
      return builder.toString();
    }
  }
}
