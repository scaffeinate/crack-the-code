package chapter_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PowerSet {
  public List<List<String>> subsets(String[] set) {
    List<List<String>> subsets = new ArrayList<List<String>>();
    subsets(set, 0, new Stack<String>(), subsets);
    return subsets;
  }

  private void subsets(String[] set, int index, Stack<String> result, List<List<String>> subsets) {
    subsets.add((List<String>) result.clone());
    for (int i = index; i < set.length; i++) {
      result.add(set[i]);
      subsets(set, i + 1, result, subsets);
      result.pop();
    }
  }
}
