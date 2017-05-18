package chapter_6;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOfBoxes {
  public int maximumHeight(List<Box> boxes) {
    int maxHeight = 0;
    Collections.sort(boxes, new Comparator<Box>() {
      @Override
      public int compare(Box o1, Box o2) {
        return Integer.valueOf(o2.height).compareTo(Integer.valueOf(o1.height));
      }
    });

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
}
