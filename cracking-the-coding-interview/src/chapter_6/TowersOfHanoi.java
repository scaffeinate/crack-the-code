package chapter_6;

import java.util.Stack;

public class TowersOfHanoi {
  public Stack<Integer> towers(Stack<Integer> source) {
    Stack<Integer> dest = new Stack<Integer>();
    towersOfHanoi(source.size(), source, new Stack<Integer>(), dest);
    return dest;
  }

  private void towersOfHanoi(int n, Stack<Integer> source, Stack<Integer> temp, Stack<Integer> dest) {
    if (n > 0) {
      towersOfHanoi(n - 1, source, dest, temp);
      dest.push(source.pop());
      towersOfHanoi(n - 1, temp, source, dest);
    }
  }
}
