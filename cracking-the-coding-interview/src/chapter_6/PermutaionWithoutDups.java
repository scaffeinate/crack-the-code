package chapter_6;

import java.util.ArrayList;
import java.util.List;

public class PermutaionWithoutDups {
  public List<String> permutations(String s) {
    List<String> results = new ArrayList<String>();
    permutate(s.toCharArray(), 0, results);
    return results;
  }

  private void permutate(char[] ch, int index, List<String> results) {
    if (index == ch.length) {
      results.add(constructString(ch));
      return;
    }

    for (int i = index; i < ch.length; i++) {
      swap(ch, i, index);
      permutate(ch, index + 1, results);
      swap(ch, index, i);
    }
  }

  private String constructString(char[] arr) {
    StringBuilder builder = new StringBuilder();
    for (char c : arr) {
      builder.append(c);
    }
    return builder.toString();
  }

  private void swap(char[] arr, int i, int j) {
    char c = arr[i];
    arr[i] = arr[j];
    arr[j] = c;
  }

  public static void main(String[] args) {
    PermutaionWithoutDups p = new PermutaionWithoutDups();
    System.out.println(p.permutations("Rubix"));
  }
}
