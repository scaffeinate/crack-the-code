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

    Map<Box, Integer> results = new HashMap<Box, Integer>();

    for (int i = 0; i < boxes.size(); i++) {
      Box box = boxes.get(i);
      int height = (!results.containsKey(box)) ? maximumHeight(boxes, i, results) + box.height : results.get(box);
      maxHeight = Math.max(height, maxHeight);
    }
    
    return maxHeight;
  }

  private int maximumHeight(List<Box> boxes, int index, Map<Box, Integer> results) {
    if (index == boxes.size()) {
      return 0;
    }

    int maxHeight = 0;
    for (int i = index + 1; i < boxes.size(); i++) {
      Box box = boxes.get(i);
      if (boxes.get(index).greaterThan(box)) {
        int height = (!results.containsKey(box)) ? maximumHeight(boxes, i, results) + box.height : results.get(box);
        results.putIfAbsent(box, height);
        maxHeight = Math.max(maxHeight, height);
      }
    }

    return maxHeight;
  }

  public int maximumHeight2(List<Box> boxes) {
    Collections.sort(boxes, new BoxComparator());
    return maximumHeight2(boxes, 0, null, new HashMap<Box, Integer>());
  }

  private int maximumHeight2(List<Box> boxes, int index, Box prevBox, Map<Box, Integer> results) {
    int maxHeight = 0;
    if(index == boxes.size()) {
      return 0;
    }

    Box box = boxes.get(index);

    if(prevBox == null || prevBox.greaterThan(box)) {
      if(!results.containsKey(box)) {
        maxHeight = Math.max(maxHeight, (maximumHeight2(boxes, index + 1, box, results) + box.height));
        results.put(box, maxHeight);
      }
    }

    maxHeight = Math.max(maxHeight, maximumHeight2(boxes, index + 1, prevBox, results));

    return maxHeight;
  }

  private class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
      return Integer.valueOf(o2.height).compareTo(Integer.valueOf(o1.height));
    }
  }

}
