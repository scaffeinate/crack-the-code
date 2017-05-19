package chapter_8;

import java.util.Stack;

public class TowersOfHanoi {
  public Stack<Integer> towers(Stack<Integer> source) {
    Stack<Integer> dest = new Stack<Integer>();
    towersOfHanoi(source.size(), source, new Stack<Integer>(), dest);
    return dest;
  }

  private void towersOfHanoi(int n, Stack<Integer> source, Stack<Integer> temp, Stack<Integer> dest) {
    if (n > 0) {
      // Move N-1 disks from source to temp
      towersOfHanoi(n - 1, source, dest, temp);
      // Move Nth disk from source to dest
      dest.push(source.pop());
      // Move back the N-1 disks from temo to dest
      towersOfHanoi(n - 1, temp, source, dest);
    }
  }
}
