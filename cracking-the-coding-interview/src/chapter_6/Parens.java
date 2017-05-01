package chapter_6;

import java.util.ArrayList;
import java.util.List;

public class Parens {
  public List<String> getParans(int n) {
    List<String> result = new ArrayList<String>();
    getParans(n, 0, 0, new StringBuffer(), result);
    return result;
  }

  private void getParans(int n, int numOpeningParams, int numClosingParams, StringBuffer buffer,
      List<String> result) {

    if (numOpeningParams == n && numClosingParams == n) {
      result.add(buffer.toString());
    } else {
      if (numOpeningParams < n) {
        buffer.append('(');
        getParans(n, numOpeningParams + 1, numClosingParams, buffer, result);
        buffer.setLength(buffer.length() - 1);
      }

      if (numClosingParams < numOpeningParams) {
        buffer.append(')');
        getParans(n, numOpeningParams, numClosingParams + 1, buffer, result);
        buffer.setLength(buffer.length() - 1);
      }
    }
  }
}
