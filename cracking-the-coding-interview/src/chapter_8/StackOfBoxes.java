package chapter_8;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOfBoxes {
  public int maximumHeight(List<Box> boxes) {
    int maxHeight = 0;
    Collections.sort(boxes, new BoxComparator());

    Map<Integer, Integer> results = new HashMap<Integer, Integer>();

    for (int i = 0; i < boxes.size(); i++) {
      int height = maximumHeight(boxes, i, results);
      maxHeight = Math.max(height, maxHeight);
    }

    return maxHeight;
  }

  private int maximumHeight(List<Box> boxes, int index, Map<Integer, Integer> results) {
    if (results.containsKey(index)) {
      return results.get(index);
    }

    int maxHeight = 0;
    Box current = boxes.get(index);
    for (int i = index + 1; i < boxes.size(); i++) {
      Box box = boxes.get(i);
      if (current.greaterThan(box)) {
        int height = maximumHeight(boxes, i, results);
        maxHeight = Math.max(maxHeight, height);
      }
    }

    maxHeight += current.height;
    results.put(index, maxHeight);
    return maxHeight;
  }

  public int maximumHeight2(List<Box> boxes) {
    Collections.sort(boxes, new BoxComparator());
    Map<Integer, Integer> results = new HashMap<Integer, Integer>();
    return maximumHeight2(boxes, 0, null, results);
  }

  private int maximumHeight2(List<Box> boxes, int index, Box prevBox, Map<Integer, Integer> results) {
    int maxHeight = 0;
    if (index == boxes.size()) {
      return 0;
    }

    Box box = boxes.get(index);
    if (prevBox == null || prevBox.greaterThan(box)) {
      if (!results.containsKey(index)) {
        maxHeight = maximumHeight2(boxes, index + 1, box, results) + box.height;
        results.put(index, maxHeight);
      } else {
        maxHeight = results.get(index);
      }
    }

    maxHeight = Math.max(maxHeight, maximumHeight2(boxes, index + 1, prevBox, results));

    return maxHeight;
  }

  private class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
      return Integer.valueOf(o2.depth * o2.width * o2.height).compareTo(Integer.valueOf(o1.depth * o1.width * o1.height));
    }
  }

}
