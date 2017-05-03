package chapter_6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parens {
  public List<String> getParans(int n) {
    List<String> result = new ArrayList<String>();
    getParans(n, 0, 0, new StringBuffer(), result);
    return result;
  }

  private void getParans(int n, int numOpeningParams, int numClosingParams, StringBuffer buffer, List<String> result) {
    if (numOpeningParams == n && numClosingParams == n) {
      result.add(buffer.toString());
    } else {
      if (numOpeningParams < n) {
        buffer.append('(');
        numOpeningParams++;
        getParans(n, numOpeningParams, numClosingParams, buffer, result);
        buffer.setLength(buffer.length() - 1);
        numOpeningParams--;
      }

      if (numClosingParams < numOpeningParams) {
        buffer.append(')');
        numClosingParams++;
        getParans(n, numOpeningParams, numClosingParams, buffer, result);
        buffer.setLength(buffer.length() - 1);
        numClosingParams--;
      }
    }
  }

  public List<String> getParans2(int n) {
    List<String> results = new ArrayList<String>();
    Set<String> set = getParans2Set(n);
    results.addAll(set);
    return results;
  }

  private Set<String> getParans2Set(int n) {
    Set<String> set = new HashSet<String>();
    String base = "()";
    if (n == 1) {
      set.add(base);
    } else {
      Set<String> prevSet = getParans2Set(n - 1);
      for (String s : prevSet) {
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '(') {
            set.add(s.substring(0, i + 1) + base + s.substring(i + 1, s.length()));
          }
        }
        set.add(s + base);
      }
    }

    return set;
  }
}
